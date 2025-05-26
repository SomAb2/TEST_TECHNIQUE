package org.example;


import org.example.interfaces.ClientDataReader;
import org.example.readers.CsvClientReader;
import org.example.readers.JsonClientReader;
import org.example.readers.TxtClientReader;
import org.example.readers.XmlClientReader;

public class FileReaderFactory {
    public static ClientDataReader getReader(String extension) {

        switch (extension.toLowerCase()) {
            case "csv":
                return new CsvClientReader();
            case "json":
                 return new JsonClientReader();
             case "xml":
                 return new XmlClientReader();
             case "txt":
                 return new TxtClientReader();
            default:
                throw new IllegalArgumentException("Format non supporté : " + extension);
        }
    }
}