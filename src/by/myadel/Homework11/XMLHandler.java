package by.myadel.Homework11;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private Root root;
    private People people;
    private boolean isPeople = false;
    private boolean isRootName = false;
    private boolean isPeopleId = false;
    private boolean isPeopleAge = false;
    private boolean isPeopleIsDegree = false;
    private boolean isPeopleName = false;
    private boolean isPeopleSurname = false;

    public Root getRoot() {
        return root;
    }

    @Override
    public void startDocument() throws SAXException {
        root = new Root();
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("people")) {
            isPeople = true;
        } else if (qName.equals("element")) {
            people = new People();
        } else if (qName.equals("name") && !isPeople) {
            isRootName = true;
        } else if (qName.equals("age") && isPeople) {
            isPeopleAge = true;
        } else if (qName.equals("id") && isPeople) {
            isPeopleId = true;
        } else if (qName.equals("isDegree") && isPeople) {
            isPeopleIsDegree = true;
        } else if (qName.equals("name") && isPeople) {
            isPeopleName = true;
        } else if (qName.equals("surname") && isPeople) {
            isPeopleSurname = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("people")) {
            isPeople = false;
        } else if (qName.equals("element")) {
            root.addPeople(people);
        } else if (qName.equals("name") && !isPeople) {
            isRootName = false;
        } else if (qName.equals("age") && isPeople) {
            isPeopleAge = false;
        } else if (qName.equals("id") && isPeople) {
            isPeopleId = false;
        } else if (qName.equals("isDegree") && isPeople) {
            isPeopleIsDegree = false;
        } else if (qName.equals("name") && isPeople) {
            isPeopleName = false;
        } else if (qName.equals("surname") && isPeople) {
            isPeopleSurname = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isRootName) {
            root.setName(new String(ch, start, length));
        } else if (isPeopleAge) {
            people.setAge(Integer.valueOf(new String(ch, start, length)));
        } else if (isPeopleId) {
            people.setId(Integer.valueOf(new String(ch, start, length)));
        } else if (isPeopleIsDegree) {
            people.setDegree(Boolean.valueOf(new String(ch, start, length)));
        } else if (isPeopleName) {
            people.setName(new String(ch, start, length));
        } else if (isPeopleSurname) {
            people.setSurname(new String(ch, start, length));
        }
    }
}
