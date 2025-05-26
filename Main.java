package org.example;


import org.example.interfaces.ClientDataReader;
import org.example.modele.Client;
import org.example.services.SalaryStatisticsService;

import java.io.File;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Fichier à lire (modifie ici selon ton test)
            File file = new File("src/main/resources/clients.xml");


            // Récupère l'extension

            String extension = getFileExtension(file);

            // Utilise la fabrique pour obtenir le bon lecteur
            ClientDataReader reader = FileReaderFactory.getReader(extension);

            // Lecture des clients
            List<Client> clients = reader.readClients(file);

            // Affiche les clients
            System.out.println("Liste des clients lus :");
            for (Client client : clients) {
                System.out.println(client);
            }

            // Calcul des moyennes avec le service
            SalaryStatisticsService service = new SalaryStatisticsService();
            Map<String, Double> moyennes = service.calculerMoyenneParProfession(clients);

            // Affiche les moyennes
            System.out.println("\nMoyenne des salaires par profession :");
            for (var entry : moyennes.entrySet()) {
                System.out.printf("%s : %.2f K€%n", entry.getKey(), entry.getValue());
            }

        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot > 0 && lastDot < name.length() - 1) {
            return name.substring(lastDot + 1);
        }
        throw new IllegalArgumentException("Fichier sans extension : " + name);
    }

    }
