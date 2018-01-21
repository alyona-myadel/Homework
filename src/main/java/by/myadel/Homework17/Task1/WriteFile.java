package by.myadel.Homework17.Task1;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

class WriteFile {
    private static final String FILENAME = "result.xml";

    void recordFile(FileStore fileStore) {

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            for (DataFile dataFile : fileStore.getDataFiles()) {
                Element file = document.createElement("file");
                root.appendChild(file);

                Element name = document.createElement("name");
                name.setTextContent(dataFile.getFileName());
                file.appendChild(name);

                Element path = document.createElement("path");
                path.setTextContent(dataFile.getFilePath());
                file.appendChild(path);

                Element size = document.createElement("size");
                size.setTextContent(String.valueOf(dataFile.getFileSize()));
                file.appendChild(size);

                Element datetime = document.createElement("datetime");
                datetime.setTextContent(String.valueOf(dataFile.getDataTime()));
                file.appendChild(datetime);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + File.separator
                    + FILENAME));
            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.transform(source, result);
            System.out.println("Документ сохранен!");
        } catch (ParserConfigurationException | TransformerException ex) {
            ex.getStackTrace();
        }
    }
}
