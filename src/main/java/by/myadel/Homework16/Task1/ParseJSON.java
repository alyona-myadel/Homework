package by.myadel.Homework16.Task1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


public class ParseJSON {
    NewsStorage newsStorage = new NewsStorage();

    public void parseJSON(String nameFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = null;
        try {
            Object object = parser.parse( new FileReader( nameFile ) );
            JSONObject jsonObject = (JSONObject) object;
            String location = (String) jsonObject.get( "location" );
            String name = (String) jsonObject.get( "name" );
            newsStorage.setLocation( location );
            newsStorage.setName( name );
            JSONArray news = (JSONArray) jsonObject.get( "news" );
            for (Object elementNews : news) {
                JSONObject elementObj = (JSONObject) elementNews;
                NewsBuilder newsBuilder = new NewsBuilder();
                newsBuilder.setID( (long) elementObj.get( "id" ) );
                newsBuilder.setDate( (String) elementObj.get( "date" ) );
                newsBuilder.setTitle( (String) elementObj.get( "title" ) );
                newsBuilder.setDescription( (String) elementObj.get( "description" ) );
                JSONArray keywords = (JSONArray) elementObj.get( "keywords" );
                for (Object keyword : keywords) {
                    newsBuilder.setKeywords( (String) keyword );
                }
                newsBuilder.setVisible( (boolean) elementObj.get( "visible" ) );
                newsStorage.setNewsList( newsBuilder.build() );

            }
            print();
        } catch (Exception ex) {
            System.out.println( "не возможно открыть json error = " + ex.toString() );
            return;
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception ex) {
                    System.out.println( ex.toString() );
                }
            }
        }
    }

    void print() {
        System.out.println( "\n----------------parse JSON----------------\n" );
        System.out.println( "location = " + newsStorage.getLocation() + "\nname = " + newsStorage.getName() );
        for (News element : newsStorage.getNewsList()) {
            System.out.println( "id: " + element.getId() );
            System.out.println( "title: " + element.getTitle() );
            System.out.println( "description: " + element.getDescription() );
            System.out.println( "date: " + element.getDate() );
            System.out.println( "keywords: " );
            for (String key : element.getKeywords()) {
                System.out.println( "         " + key );
            }
            System.out.println( "visible: " + element.isVisible() );
        }
    }
}
