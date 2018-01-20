package by.myadel.Homework16.Task1;

public class Main {
    private static final String LINK_JSON = "http://kiparo.ru/t/it_news.json";
    private static final String LINK_XML = "http://kiparo.ru/t/it_news.xml";
    private static final String NAME_JSON = "it_news.json";
    private static final String NAME_XML = "it_news.xml";

    public static void main(String[] args) {
        Object synchronizer = new Object();
        new ParserThread( synchronizer, NAME_JSON, NAME_XML ).start();
        new DownloaderThread( synchronizer, LINK_JSON, LINK_XML, NAME_JSON, NAME_XML ).start();
    }


}
