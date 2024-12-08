package com.example.cryptautomation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CryptAutomationApplicationTests {

   @Mock
    private SlackHttpClient slackHttpClient;

   @Mock
    private UpbitHttpClient upbitHttpClient;

   @Mock
    private ReportHistoryRepository repository;

   @InjectMocks
    private UpbitSlackService sut;

   @Test
    void test() {
       // given
       String market = "KRW-BTC";
       when(upbitHttpClient.getTicketByMarket(market))
               .thenReturn(new UpbitTickerDto()
               .builder()
               .trade_price(10.0)
               .build()
       );
       // when
       sut.execute(market);

       // then
       verify(upbitHttpClient, atMostOnce()).getTickerByMarket(market);
       verify(slackHttpClient, atMostOnce()).send(any);
       verify(repository, atMostOnce()).save(any(), any());
   }



}
