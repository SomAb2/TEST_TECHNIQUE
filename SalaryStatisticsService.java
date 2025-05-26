package org.example.services;

import org.example.modele.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalaryStatisticsService {
    public Map<String, Double> calculerMoyenneParProfession(List<Client> clients) {
        Map<String, List<Double>> salairesParProfession = new HashMap<>();

        for (Client client : clients) {
            salairesParProfession
                    .computeIfAbsent(client.getProfession(), k -> new ArrayList<>())
                    .add(client.getSalaire());
        }

        Map<String, Double> moyennes = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : salairesParProfession.entrySet()) {
            List<Double> salaires = entry.getValue();
            double somme = salaires.stream().mapToDouble(Double::doubleValue).sum();
            moyennes.put(entry.getKey(), somme / salaires.size());
        }

        return moyennes;
    }
}
