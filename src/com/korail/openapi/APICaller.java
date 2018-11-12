package com.korail.openapi;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class APICaller {

    String execute(String url) throws IOException {

        System.out.println("Call URL : " + url);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        StringBuffer buffer = new StringBuffer();

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                int status = httpResponse.getStatusLine().getStatusCode();

                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("UnException reesponse status :" + status);
                }
            }
        };

        String responseBody = httpClient.execute(httpGet, responseHandler);
        System.out.println("-------------------------");
        System.out.println(responseBody);
        System.out.println("-------------------------");

        buffer.append(responseBody);

        return buffer.toString();
    }

}
