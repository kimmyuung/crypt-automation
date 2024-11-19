package com.example.cryptautomation.service;

import com.example.cryptautomation.http.SlackHttpClient;
import com.example.cryptautomation.http.UpbitHttpClient;
import com.example.cryptautomation.http.UpbitTickerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;

    public void execute(String market) {
        // upbit
        UpbitTickerDto tickerByMarket = upbitHttpClient.getTickerDto(market);

        // slack
        StringBuilder sb = new StringBuilder();
        sb.append("[실시간 데이터");
        sb.append(market);
        sb.append("price = ");
        sb.append(tickerByMarket.getTrade_price());

        slackHttpClient.send(sb.toString());
    }
}
