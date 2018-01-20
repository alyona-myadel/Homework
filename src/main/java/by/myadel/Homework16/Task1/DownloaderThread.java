package by.myadel.Homework16.Task1;

import java.io.IOException;

public class DownloaderThread extends Thread {
    private static final String THREAD_NAME = "Downloader thread";
    private String linkJson;
    private String linkXml;
    private String nameJSON;
    private String nameXml;
    private Object synchronizer;

    public DownloaderThread(Object synchronizer, String linkJson, String linkXml, String nameJSON, String nameXML) {
        super( THREAD_NAME );
        this.synchronizer = synchronizer;
        this.linkJson = linkJson;
        this.linkXml = linkXml;
        this.nameJSON = nameJSON;
        this.nameXml = nameXML;
    }

    @Override
    public void run() {
        DownloadFile downloadFile = new DownloadFile();
        try {
            System.out.println( THREAD_NAME + " started downloading json" );
            downloadFile.downloadFile( nameJSON, linkJson );
            System.out.println( THREAD_NAME + " finished downloaded json" );
            synchronized (synchronizer) {
                synchronizer.notify();
                synchronizer.wait();
            }
            System.out.println( THREAD_NAME + " started downloading xml" );
            downloadFile.downloadFile( nameXml, linkXml );
            System.out.println( THREAD_NAME + " finished downloaded xml" );
            synchronized (synchronizer) {
                synchronizer.notify();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
