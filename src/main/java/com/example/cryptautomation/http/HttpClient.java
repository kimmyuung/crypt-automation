package com.example.cryptautomation.http;

import com.example.cryptautomation.exception.UpbitClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class HttpClient {
    private final RestTemplate restTemplate;

    public String excute(String url, HttpMethod method, HttpHeaders httpHeaders) {
        try {
            restTemplate.exchange(
                    url,
                    method,
                    new HttpEntity<>(httpHeaders),
                    new ParameterizedTypeReference<String>() {
                    }
            ).getBody();
        } catch (RestClientException e) {
            throw new UpbitClientException(e.getMessage());
        }
        return null;
    }

}
