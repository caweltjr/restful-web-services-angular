package com.spring.rest.yahoo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class Finance {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?region=US&q=tesla")
                .get()
                .addHeader("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "1e7ddf4ec1msh94ea3cb92200ce7p1924c9jsndbac5bdf9a3a")
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseString = responseBody.string();
        int x = 1;
    }

    public Finance() throws IOException {
    }
}
