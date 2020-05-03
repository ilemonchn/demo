package com.cnicg.lemon.demo.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class HttpUrlConTest {
    public static void main(String[] args)throws Exception {

        String urll = "http://s3plus.sankuai.com/v1/mss_049a9c3f186c4e44a5047dfc4ac74ea1/coupon/coupon_import_sku_template.xls";
        HttpGet get = new HttpGet(urll);
        CloseableHttpResponse response = HttpClients.createDefault().execute(get);
        int available = response.getEntity().getContent().available();
        System.out.println(response.getStatusLine().getStatusCode());
        FileOutputStream fio = new FileOutputStream(new File("/Users/chenmeng/Documents/mydocs/ttt.xls"));
        byte[] bytes = new byte[available];


//        System.out.println(available);

                URL url = new URL(urll);
        //获取此路径的连接
        URLConnection conn = url.openConnection();
        Long fileLength = conn.getContentLengthLong();//获取文件大小

        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());//构造读取流
        byte[] b = new byte[fileLength.intValue()];
        conn.getInputStream().read(b);
        fio.write(b);
        System.out.println(b.length);

        System.out.println(fileLength);
        fio.close();
    }
}
