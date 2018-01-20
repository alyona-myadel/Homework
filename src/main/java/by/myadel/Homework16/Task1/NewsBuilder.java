package by.myadel.Homework16.Task1;

public class NewsBuilder {
    private News news = new News();

    public NewsBuilder setDate(String date) {
        news.setDate( date );
        return this;
    }

    public NewsBuilder setDescription(String description) {
        news.setDescription( description );
        return this;
    }

    public NewsBuilder setID(long id) {
        news.setId( id );
        return this;
    }

    public NewsBuilder setKeywords(String keyword) {
        news.setKeywords( keyword );
        return this;
    }

    public NewsBuilder setTitle(String title) {
        news.setTitle( title );
        return this;
    }

    public NewsBuilder setVisible(boolean visible) {
        news.setVisible( visible );
        return this;
    }

    public News build() {
        return news;
    }

}
