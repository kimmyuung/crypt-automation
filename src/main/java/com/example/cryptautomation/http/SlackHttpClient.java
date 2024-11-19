package com.example.cryptautomation.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class SlackHttpClient {
    public void send(String message) {
        try {
            Slack instance = Slack.getInstance();
            Payload payload = Payload.builder()
                    .text(message)
                    .build();
            instance.send("https://hooks.slack.com/services/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", payload);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
