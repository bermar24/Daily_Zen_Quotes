package com.example.daily_zen_quote;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class fetchQuot {

    private static final String API_URL = "https://zenquotes.io/api/quotes/";

    public static String[] getQuotes() {
        String jsonResponse = fetchAPI(API_URL);
        return extractQuotes(jsonResponse);
    }

    public static String fetchAPI(String urlString) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("GET request failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
    public static String[] extractQuotes(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            String[] quotesArray = new String[rootNode.size()];

            for (int i = 0; i < rootNode.size(); i++) {
                String quote = rootNode.get(i).get("q").asText();
                String author = rootNode.get(i).get("a").asText();
                quotesArray[i] = "\"" + quote + "\" - " + author;
            }
            return quotesArray;
        } catch (Exception e) {
            System.out.println("Error parsing JSON.");
            e.printStackTrace();
        }
        return new String[0];
    }
}