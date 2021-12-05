package com.example.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 웹 소켓을 이용하여 HTTP를 호출하는 예제
 * @author jinwoopark
 */
public class WebSocketExample {
    private static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println(
                    "신규 실행자 생성 : " + (thread.isDaemon() ? "데몬 " : "")
                    + ", 스레드 그룹 : " + thread.getThreadGroup());
            return thread;
        }
    });

    // 웹소켓 리스너를 구현한다.
    private static class WebSocketListener implements Listener {
        /**
         * WebSocket이 연결되었을 때 실행된다.
         * @param webSocket
         */
        @Override
        public void onOpen(WebSocket webSocket) {
            System.out.println("WebSocket 연결");
            webSocket.sendText("안녕하세요. WebSocket 테스트 입니다.", true);
            Listener.super.onOpen(webSocket);
        }

        /**
         * 서버로부터 메시지를 수신하였을 때 실행된다.
         * @param webSocket
         * @param data
         * @param last
         * @return
         */
        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println("수신 받은 메시지 (from 서버) : " + data);

            if(!webSocket.isOutputClosed()) {
                webSocket.sendText("안녕하세요. WebSocket 다시 테스트 입니다.", true);
            }
            return Listener.super.onText(webSocket, data, last);
        }

        /**
         * WebSocket을 종료했을 때 실행된다.
         * @param webSocket
         * @param statusCode
         * @param reason
         * @return
         */
        @Override
        public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
            System.out.println("종료 상태 코드 :" + statusCode + ", 이유 : " + reason);
            executor.shutdown();
            return Listener.super.onClose(webSocket, statusCode, reason);
        }

        /**
         * WebSocket이 에러가 발생했을 때 실행된다.
         * @param webSocket
         * @param error
         */
        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.out.println("Error occurred" + error);
            Listener.super.onError(webSocket, error);
        }
    }

    public static void main(String[] args) throws Exception {
        // 멀티 스레드 기반의 HTTP 클라이언트를 생성
        var httpClient = HttpClient.newBuilder().executor(executor).build();

        // 비동기로 호출한 WebSocket 객체 생성
        var webSocket = httpClient.newWebSocketBuilder()
                .buildAsync(URI.create("wss://echo.websocket.org"), new WebSocketListener()).join();

        System.out.println("WebSocket를 호출하였습니다.");

        Thread.sleep(1000);

        webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok")
                .thenRun(() -> System.out.println("호출 종료"));
    }
}
