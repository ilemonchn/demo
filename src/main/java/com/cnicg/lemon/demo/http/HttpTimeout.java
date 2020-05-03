package com.cnicg.lemon.demo.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

public class HttpTimeout {
    public static void main(String[] args) {
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10)
                .setConnectTimeout(1)
                .setSocketTimeout(10).build();
        httpGet.setConfig(requestConfig);

        CloseableHttpClient client = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity(), Charset.forName("utf-8")));
        } catch (IOException e) {
            System.out.println("io_error");
            e.printStackTrace();
        }

    }
}
