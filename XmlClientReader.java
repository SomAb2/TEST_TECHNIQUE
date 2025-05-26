package org.example.readers;


import org.example.interfaces.ClientDataReader;
import org.example.modele.Client;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class XmlClientReader implements ClientDataReader {
    public List<Client> readClients(File file) throws Exception {
        List<Client> clients = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList clientNodes = doc.getDocumentElement().getChildNodes();

        for (int i = 0; i < clientNodes.getLength(); i++) {
            Node node = clientNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("client")) {
                String nom = "";
                String prenom = "";
                int age = 0;
                String profession = "";
                double salaire = 0.0;

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node child = childNodes.item(j);

                    if (child.getNodeType() == Node.ELEMENT_NODE) {
                        String tag = child.getNodeName();
                        String value = child.getTextContent().trim();

                        switch (tag) {
                            case "nom" -> nom = value;
                            case "prenom" -> prenom = value;
                            case "age" -> age = Integer.parseInt(value);
                            case "profession" -> profession = value;
                            case "salaire" -> salaire = Double.parseDouble(value);
                        }
                    }
                }

                clients.add(new Client(nom, prenom, age, profession, salaire));
            }
        }

        return clients;
    }
}