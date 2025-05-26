package org.example.modele;

public class Client {


        private String nom;
        private String prenom;
        private int age;
        private String profession;
        private double salaire;

        public Client(String nom, String prenom, int age, String profession, double salaire) {
            this.nom = nom;
            this.prenom = prenom;
            this.age = age;
            this.profession = profession;
            this.salaire = salaire;
        }

        public String getProfession() {
            return profession;
        }

        public double getSalaire() {
            return salaire;
        }

    @Override
    public String toString() {
        return String.format("%s %s, %d ans, %s, %.2f K€",
                prenom, nom, age, profession, salaire);
    }

}
