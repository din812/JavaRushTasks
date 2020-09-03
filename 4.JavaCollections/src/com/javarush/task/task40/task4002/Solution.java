package com.javarush.task.task40.task4002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/* 
Опять POST, а не GET
*/

public class Solution {

  public static void main(String[] args) throws Exception {
    Solution solution = new Solution();
    solution.sendPost("http://requestb.in/1h4qhvv1", "name=zapp&mood=good&locale=&id=777");
  }

  public void sendPost(String url, String urlParameters) throws Exception {
    HttpClient client = getHttpClient();
    HttpPost request = new HttpPost(url);
    URL connection = new URL(url);

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    String[] pars = urlParameters.split("&");

    for (String values : pars) {
      params.add(new BasicNameValuePair(values.substring(0, values.indexOf("=")),
          values.substring(values.indexOf("=") + 1)));
    }

    request.setEntity(new UrlEncodedFormEntity(params));

    /*OutputStream os = connection.openConnection().getOutputStream();
    os.write(urlParameters.getBytes());
    os.close();
    os.flush();*/

    request.addHeader("User-Agent", "Mozilla/5.0");

    HttpResponse response = client.execute(request);

    System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(response.getEntity().getContent()));

    StringBuffer result = new StringBuffer();
    String responseLine;
    while ((responseLine = bufferedReader.readLine()) != null) {
      result.append(responseLine);
    }

    System.out.println("Response: " + result.toString());
  }

  protected HttpClient getHttpClient() {
    return HttpClientBuilder.create().build();
  }
}
