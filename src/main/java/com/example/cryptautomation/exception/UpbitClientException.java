package com.example.cryptautomation.exception;

public class UpbitClientException extends RuntimeException{
    public UpbitClientException(String errmsg) {
        super(String.format("업비트 API 호출 중 에러 발생. error = ", errmsg));
    }
}
