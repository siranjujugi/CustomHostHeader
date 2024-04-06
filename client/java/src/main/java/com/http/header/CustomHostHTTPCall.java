package com.http.header;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomHostHTTPCall {
    public static void main(String[] args) throws Exception {
        // Define the URL of the sample REST service
        String url = "http://localhost:3000/";

        // Define the custom value for the "Host" header
        String customHost = "custom.example.com";

        // Create an instance of CloseableHttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // Create an instance of HttpGet with the URL
        HttpGet request = new HttpGet(url);

        // Set the custom value for the "Host" header
        request.setHeader("Host", customHost);

        // Execute the request and get the response
        HttpResponse response = httpClient.execute(request);

        // Get the response code
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + statusCode);

        // Read the response body
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();

        // Print the response body
        System.out.println("Response Body:");
        System.out.println(responseBody.toString());

        // Close the HttpClient
        httpClient.close();
    }
}

