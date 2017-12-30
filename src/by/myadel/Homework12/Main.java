package by.myadel.Homework12;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static final String LINK = "http://kiparo.ru/t/test.json";

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        try {
            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == httpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                parseJackson(inputStream);
            } else {
                System.out.println("Filled = " + responseCode);
                System.out.println("Данные не найдены, code = " + responseCode);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            if (inputStream == null) {
                inputStream.close();
            }
        }
    }

    private static void parseJackson(InputStream inputStream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Root root = (Root) mapper.readValue(inputStream, Root.class);
            System.out.println(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
