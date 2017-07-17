package com.baoquan.shuxin.third.util.fahai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Created by Administrator on 2017/5/2.
 */
public class FaHaiHttpClient {
    public String Get(CloseableHttpClient httpClient, URI uri) throws IOException {
        System.out.println(uri);
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() != 200) {
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }

        HttpEntity httpEntity = response.getEntity();
        if (httpEntity == null) {
            throw new ClientProtocolException("Response contains no content");
        }

        ContentType contentType = ContentType.getOrDefault(httpEntity);
        Charset charset = contentType.getCharset();
        Reader reader = new InputStreamReader(httpEntity.getContent(), charset);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder data = new StringBuilder();
        for (String line = null; ((line = bufferedReader.readLine()) != null); data.append(line))
            ;
        bufferedReader.close();
        return data.toString();
    }
}
