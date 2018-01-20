package by.myadel.Homework16.Task1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownloadFile {


    public void downloadFile(String pathName, String LINK) throws IOException {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL( LINK );
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == httpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File( pathName );
                fileOutputStream = new FileOutputStream( file );
                int byteRead;
                byte[] buffer = new byte[2048];
                while ((byteRead = inputStream.read( buffer )) != -1) {
                    fileOutputStream.write( buffer, 0, byteRead );
                }
            } else {
                System.out.println( "Filled = " + responseCode );
                System.out.println( "Code = " + responseCode );
            }
        } catch (Exception ex) {
            System.out.println( ex.toString() );
        } finally {
            if (inputStream == null) {
                inputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        }
    }

}
