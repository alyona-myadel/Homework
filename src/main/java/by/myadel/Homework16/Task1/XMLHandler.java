package by.myadel.Homework16.Task1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private NewsStorage newsStorage;
    private NewsBuilder newsBuilder;
    private boolean isNews = false;
    private boolean isNewsStorageName = false;
    private boolean isNewsStorageLocation = false;
    private boolean isDate = false;
    private boolean isDescription = false;
    private boolean isId = false;
    private boolean isTitle = false;
    private boolean isVisible = false;
    private boolean isKeywords = false;
    private boolean isKeywordsElement = false;

    public NewsStorage getNewsStorage() {
        return newsStorage;
    }

    @Override
    public void startDocument() throws SAXException {
        newsStorage = new NewsStorage();
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals( "news" )) {
            isNews = true;
        } else if (qName.equals( "element" ) && !isKeywords) {
            newsBuilder = new NewsBuilder();
        } else if (qName.equals( "location" ) && !isNews) {
            isNewsStorageLocation = true;
        } else if (qName.equals( "date" ) && isNews) {
            isDate = true;
        } else if (qName.equals( "keywords" ) && isNews) {
            isKeywords = true;
        } else if (qName.equals( "element" ) && isKeywords && isNews) {
            isKeywordsElement = true;
        } else if (qName.equals( "description" ) && isNews) {
            isDescription = true;
        } else if (qName.equals( "id" ) && isNews) {
            isId = true;
        } else if (qName.equals( "title" ) && isNews) {
            isTitle = true;
        } else if (qName.equals( "visible" ) && isNews) {
            isVisible = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals( "news" )) {
            isNews = false;
        } else if (qName.equals( "element" ) && !isKeywords) {
            newsStorage.setNewsList( newsBuilder.build() );
        } else if (qName.equals( "location" ) && !isNews) {
            isNewsStorageLocation = false;
        } else if (qName.equals( "date" ) && isNews) {
            isDate = false;
        } else if (qName.equals( "keywords" ) && isNews) {
            isKeywords = false;
        } else if (qName.equals( "element" ) && isKeywords && isNews) {
            isKeywordsElement = false;
        } else if (qName.equals( "description" ) && isNews) {
            isDescription = false;
        } else if (qName.equals( "id" ) && isNews) {
            isId = false;
        } else if (qName.equals( "title" ) && isNews) {
            isTitle = false;
        } else if (qName.equals( "visible" ) && isNews) {
            isVisible = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isNewsStorageLocation) {
            newsStorage.setLocation( new String( ch, start, length ) );
        } else if (isNewsStorageName) {
            newsStorage.setName( new String( ch, start, length ) );
        } else if (isDate) {
            newsBuilder.setDate( new String( ch, start, length ) );
        } else if (isDescription) {
            newsBuilder.setDescription( new String( ch, start, length ) );
        } else if (isId) {
            newsBuilder.setID( Long.valueOf( new String( ch, start, length ) ) );
        } else if (isTitle) {
            newsBuilder.setTitle( new String( ch, start, length ) );
        } else if (isVisible) {
            newsBuilder.setVisible( Boolean.valueOf( new String( ch, start, length ) ) );
        } else if (isKeywordsElement) {
            newsBuilder.setKeywords( new String( ch, start, length ) );
        }
    }
}
