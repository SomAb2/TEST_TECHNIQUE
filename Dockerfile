# Étape 1 : image de base avec Java
FROM openjdk:17-jdk-slim

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie du JAR généré dans le conteneur
COPY java -jar target/client-statistics-1.0-SNAPSHOT-jar-with-dependencies.jar


# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]
