package com.example.cryptautomation.controller;


import com.example.cryptautomation.service.UpbitSlackService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import repository.ReportHistoryRepository;

@RestController
@RequiredArgsConstructor
public class TestController {

  private final UpbitSlackService upbitSlackService;

    @GetMapping("/api/v1/ticker/{market}")
    public void test (@PathVariable String market) throws JsonProcessingException {
//        upbitSlackService.execute(market);
    }

}
