package com.example.cryptautomation.batch;

import com.example.cryptautomation.service.UpbitSlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class TickerSlackJobConfiguration {
    private final UpbitSlackService upbitSlackService;

    @Bean
    public Job tickerSlackJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("tickerSlackJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step simpleStep(JobRepository jobRepository, Tasklet tasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("step" , jobRepository)
                .tasklet(tasklet, platformTransactionManager)
                .build();
    }

    @Bean
    public Tasklet tasklet() {
        return (((contribution, chunkContext) -> {
            Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();
            //Object unitObj = jobParameters.get("unit");
            //Integer unit = Integer.valueOf(unitObj.toString());

            String market = String.valueOf(jobParameters.get("market").toString());
            upbitSlackService.execute(market);

            System.out.println(">>> This is step 1");
            return RepeatStatus.FINISHED;
        }));
    }
}