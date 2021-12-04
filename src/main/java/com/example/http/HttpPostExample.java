package com.example.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * HTTP POST 방식으로 호출하는 예제
 * @author jinwoopark
 */
public class HttpPostExample {

    public static void main(String[] args) {
        String json = "...";

        // HttpRequest를 정의한다.
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://someurl.com"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // HttpClient 객체를 생성한다.
        HttpClient httpClient = HttpClient.newHttpClient();

        // 요청을 호출한다.
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
            System.out.println("Response Code : " + httpResponse.statusCode());
            System.out.println("Response Header : " + httpResponse.headers());
            System.out.println("Response Body : " + httpResponse.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
