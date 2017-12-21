package by.myadel.Homework11;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static final String LINK = "http://kiparo.ru/t/test.xml";

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        try {
            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == httpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                parseSAX(inputStream);
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

    public static void parseSAX(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        InputSource inputSource = new InputSource(inputStream);
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XMLHandler xmlHandler = new XMLHandler();
        try {
            parser.parse(inputSource, xmlHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(xmlHandler.getRoot());
    }
}
