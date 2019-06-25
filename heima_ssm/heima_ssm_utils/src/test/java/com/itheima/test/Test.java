package com.itheima.test;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {

        /*//创建httpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //创建httpGet
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        //发送请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        HttpEntity entity = httpResponse.getEntity();

        String string = EntityUtils.toString(entity, "UTF-8");
        System.out.println(string);*/

        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //创建httpGet对象
        HttpGet httpGet = new HttpGet("http://www.itcast.cn/images/teacher/20172024182029213.jpg");

        //发送请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        //获得响应数据
        HttpEntity entity = httpResponse.getEntity();

        InputStream inputStream = entity.getContent();

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\1.jpg");

        IOUtils.copy(inputStream, fileOutputStream);

        fileOutputStream.close();
        httpClient.close();
    }
}
