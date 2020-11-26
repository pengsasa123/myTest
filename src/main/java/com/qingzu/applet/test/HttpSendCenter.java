package com.qingzu.applet.test;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 */
@Slf4j
public final class HttpSendCenter {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient httpClient = new OkHttpClient.Builder()
                                                    .connectTimeout(40, TimeUnit.SECONDS)
                                                    .readTimeout(40, TimeUnit.SECONDS)
                                                    .build();
    //
    public static JSONObject get(String apiKey, String url) {
        Request request = new Request.Builder()
                        .header("token", apiKey)
                        .url(url)
                        .build();
        return handleRequest(request);
    }

    public static void getAsync(String apiKey, String url, Callback callback) {
        Request request = new Request.Builder()
                .header("token", apiKey)
                .url(url)
                .build();
       handleAsyncRequest(request, callback);
    }

    public static JSONObject post(String apiKey, String url, JSONObject body) {
        RequestBody requestBody = RequestBody.create(JSON, body.toString());
        Request request = new Request.Builder()
                            .url(url)
                            .header("token", apiKey)
                            .post(requestBody)
                            .build();
        return handleRequest(request);
    }

    public static JSONObject post( String url, JSONObject body) {
        RequestBody requestBody = RequestBody.create(JSON, body.toString());
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .post(requestBody)
                .build();
        return handleRequest(request);
    }
    public static JSONObject postNotBody(String apiKey, String url) {
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, new JSONObject().toString()))
                .header("token", apiKey)
                .build();
        return handleRequest(request);
    }

    public static JSONObject postNotHeader(String url, JSONObject body) {
        RequestBody requestBody = RequestBody.create(JSON, body.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return handleRequest(request);
    }

    public static void postAsync(String apiKey, String url, JSONObject body, Callback callback) {
        RequestBody requestBody = RequestBody.create(JSON, body.toString());
        Request request = new Request.Builder()
                .url(url)
                .header("token", apiKey)
                .post(requestBody)
                .build();
        handleAsyncRequest(request, callback);
    }
    public static void postNotBodyAsync(String apiKey, String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, new JSONObject().toString()))
                .header("token", apiKey)
                .build();
        handleAsyncRequest(request, callback);
    }

    public static JSONObject put(String apiKey, String url) {

        return null;
    }

    public static void putAsync(String apiKey, String url, JSONObject body, Callback callback) {


    }

    public static JSONObject delete(String apiKey, String url) {

        return null;
    }

    public static void deleteAsync(String apiKey, String url, Callback callback) {

    }

    private static void handleAsyncRequest(Request request, Callback callback) {
        httpClient.newCall(request).enqueue(callback);
    }



    private static JSONObject handleRequest(Request request) {
        try {
            Response response = httpClient.newCall(request).execute();
            if (response != null) {
                String st = new String(response.body().bytes(), "utf-8");
                return (JSONObject) new JSONObject().parse(st);
            }else {

                throw new RuntimeException();
            }
        } catch (IOException e) {
            log.error("http request error::{}", e.getMessage());
            throw new RuntimeException();
        }
    }
}
