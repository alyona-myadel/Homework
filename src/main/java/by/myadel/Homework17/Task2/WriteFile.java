package by.myadel.Homework17.Task2;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class WriteFile {
    private static final String FILENAME = "result.xml";

    void recordFile(FileDataStore dataFiles) {

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element file = document.createElement("file");
            document.appendChild(file);
            for (Map.Entry<String, ArrayList<String>> data : dataFiles.getDataFiles().entrySet()) {

                Element ext = document.createElement("ext");
                file.appendChild(ext);

                Attr attr = document.createAttribute("name");
                attr.setValue(data.getKey());
                ext.setAttributeNode(attr);

                for (String pathFile : data.getValue()) {
                    Element path = document.createElement("path");
                    path.setTextContent(pathFile);
                    ext.appendChild(path);
                }
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + File.separator
                    + FILENAME));

            transformer.transform(source, result);

            System.out.println("Документ сохранен!");

        } catch (ParserConfigurationException | TransformerException ex) {
            ex.getStackTrace();
        }
    }
}
