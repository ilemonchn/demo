package com.cnicg.lemon.demo.ocf;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

public class Oct {
    public static void main(String[] args)throws Exception {
        CloseableHttpClient client = HttpClientBuilder.create().build();

        // 创建Get请求
        HttpGet httpGet = new HttpGet("https://caibaoshuo.com/companies/600276/financials#al_sheet_tab");
        httpGet.addHeader("Host","caibaoshuo.com");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:66.0) Gecko/20100101 Firefox/66.0");
        httpGet.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.addHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        httpGet.addHeader("Accept-Encoding","gzip, deflate, br");
        httpGet.addHeader("Connection","keep-alive");
        httpGet.addHeader("Cookie","Hm_lvt_09f1f334db9a482bdf5fa1cb58cc9bf5=1557761822,1559455527; intercom-id-jaxkolxz=4ed4963b-536d-47a8-939d-e00468d5d833; fs_uid=rs.fullstory.com`JY6C2`5367868305506304:5773006859993088; intercom-session-jaxkolxz=bUJ1SWQzK1pITHdBY0JCZkdqMldyQ2p4c2p6TjgwL3pLcnF6WVQvMENGQW1GbFg5RHJ2RnBzZnVnQ0lTYVFZVy0tUmlOWWMwQVhoYUtpTXF5b1orcmoxUT09--8309e95787bce3941a8043b5929b8daeb7b6dada; _ga=GA1.2.1690092676.1558242429; _caibaoshuo_rails_session=Z3RXS2xQN0QrdGpQSnF0WWNoNEQ1Y2JEcUM4NStob2FqT1N3Y0dBSnB6Z0xPRWhOcHdzN1lvUU8xVGVGRlZJUmdIckRrakZCNHJpY1FaQ1lZWE9xaFVDaVQ0WXJHd2N1S2FLVEYxc3Nna2lBNjRJS2hsc1RNcWJ4dzY3WndQM1p3YUlWc1RER1JXTDVQMzlac0tCMllPUk5oN3U0dHhFOWF5L1lrVHBaY1pvU0VCSkFhcGhOYzJmYnVoU2w0OU4vNjE5RzVPUm5LV2ZnQkpMWmhCbUNrSlhYMTZCRmhwMEI0STMxSDlEeG8ycWdRTkFGVjFta0hxNzYwTGVuQTdZWHZjbmVZbTAySmxhem8wVHJ2T2dNU01DQ0VYSjI4RkF5ZUJBRGdSV1VYditEWnFJOS9xYkRiK05Fb21pZ3NZRjNwSk41VjJCdGxPQUorODUyUnp6TzRaUk1PakIwbDljRkZiMWRSUjBEMUlHc0lPTDNpV3BTVlkxQXRJS3dpbVpuVUUrMzUzOXRON2l3R0hKR3ZuT1FWZz09LS1OckxlVEVFdCsyaUlKaXVzSkRSNTJ3PT0%3D--49f12bf6119db716b88decd64cf33a6881983731; Hm_lpvt_09f1f334db9a482bdf5fa1cb58cc9bf5=1559455596");
        httpGet.addHeader("Upgrade-Insecure-Requests","1");
        httpGet.addHeader("If-None-Match","W/\"a0dfcf17555651ef7a752e59b94b17a4\"");
        httpGet.addHeader("TE","Trailers");


//Cache-Control: max-age=0



        // 响应模型
        CloseableHttpResponse response = null;

        // 由客户端执行(发送)Get请求
        response = client.execute(httpGet);
        // 从响应模型中获取响应实体
        HttpEntity responseEntity = response.getEntity();
        System.out.println("响应状态为:" + response.getStatusLine());
//        ContentType contentType = ContentType.create(responseEntity.getContentType().getValue());
        String result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));

        System.out.println(result);




    }
}
