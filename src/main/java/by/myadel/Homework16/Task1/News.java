package by.myadel.Homework16.Task1;

import java.util.ArrayList;

public class News {
    private String date;
    private String description;
    private long id;
    private ArrayList<String> keywords = new ArrayList<>();
    private String title;
    private boolean visible;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKeywords(String keyword) {
        this.keywords.add( keyword );
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
