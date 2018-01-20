package by.myadel.Homework16.Task1;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class ParserThread extends Thread {
    private String nameJSON;
    private String nameXML;
    private static final String THREAD_NAME = "Parser thread";
    private Object synchronizer;

    public ParserThread(Object synchronizer, String nameJSON, String nameXML) {
        super( THREAD_NAME );
        this.synchronizer = synchronizer;
        this.nameJSON = nameJSON;
        this.nameXML = nameXML;
    }

    @Override
    public void run() {
        try {
            synchronized (synchronizer) {
                synchronizer.wait();
            }
            System.out.println( THREAD_NAME + " started parsing json" );
            ParseJSON parseJSON = new ParseJSON();
            parseJSON.parseJSON( nameJSON );
            System.out.println( THREAD_NAME + " finished parsing json" );
            synchronized (synchronizer) {
                synchronizer.notify();
                synchronizer.wait();
            }
            System.out.println( THREAD_NAME + " started parsing xml" );
            ParseXML parseXML = new ParseXML();
            parseXML.parseSAX( nameXML );
            System.out.println( THREAD_NAME + " finished parsing xml" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
