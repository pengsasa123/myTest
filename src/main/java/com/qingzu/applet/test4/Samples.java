package com.qingzu.applet.test4;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Samples {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        //创建表单请求参数
        String text="神州泰岳";
        String cantou="true";
        String type="7";
        String url = "http://www.nlpai.cn/api/zidongxieshi";
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("text", text);
        builder.add("cangtou", cantou);
        builder.add("type", type);
        builder.add("url", url);
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
            .url(url)
            .post(formBody)
            .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}