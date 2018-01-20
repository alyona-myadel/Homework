package by.myadel.Homework16.Task1;

import java.util.LinkedList;

public class NewsStorage {
    private String location;
    private String name;
    private LinkedList<News> newsList = new LinkedList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(News newsList) {
        this.newsList.add( newsList );
    }
}
