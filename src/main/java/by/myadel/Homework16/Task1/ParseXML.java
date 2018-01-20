package by.myadel.Homework16.Task1;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class ParseXML {

    public void parseSAX(String nameFile) throws ParserConfigurationException, SAXException, IOException {
        File file = new File( nameFile );
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XMLHandler xmlHandler = new XMLHandler();
        try {
            parser.parse( file, xmlHandler );
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        print( xmlHandler.getNewsStorage() );
    }

    void print(NewsStorage newsStorage) {
        System.out.println( "\n----------------parse XML----------------\n" );
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
