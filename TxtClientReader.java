package org.example.readers;

import org.example.interfaces.ClientDataReader;
import org.example.modele.Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TxtClientReader implements ClientDataReader {
    public List<Client> readClients(File file) throws Exception {
        List<Client> clients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Ignore les lignes vides ou mal formées
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");

                if (parts.length != 5) continue; // Vérifie qu'il y a bien 5 champs

                String nom = parts[0].trim();
                String prenom = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                String profession = parts[3].trim();
                double salaire = Double.parseDouble(parts[4].trim());

                clients.add(new Client(nom, prenom, age, profession, salaire));
            }
        }

        return clients;
    }
}
