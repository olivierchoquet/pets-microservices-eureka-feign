🦸‍♀️ SuperPets Microservices Demo 2 🐾

Bienvenue dans la démo des microservices "SuperPets" ! 
Cette application est un exemple simple de l'utilisation 
de Spring Boot et Spring Cloud Gateway pour construire 
une architecture de microservices. 
Elle vous permet de gérer des animaux de compagnie dotés 
de super-pouvoirs et de leur assigner des missions épiques.

🏗️ Architecture

Cette démo est composée de trois microservices indépendants 
et d'une API Gateway :
    
    pet-service : Gère les informations sur les animaux de compagnie (nom, espèce, super-pouvoir, niveau de puissance).

    mission-service : Gère les informations sur les missions à accomplir (nom, description, difficulté, animaux assignés).

    Un Eureka Server pour la découverte de services. Les deux microservices enregistrés automatiquement auprès du serveur.
    Communication possible entre les services via Eureka.


Chaque service (pet-service et mission-service) utilise une base de données H2 Database en mémoire, 
ce qui la rend parfaite pour une démo rapide sans configuration de base de données externe

🚀 Démarrage Rapide
    
    1. Cloner le dépôt
    2. Lancer les 3 services

pet-service tourne sur http://localhost:8081
mission-service tourne sur http://localhost:8082
pet-gateway tourne sur http://localhost:8080

🧪 Tester l'Application

    1. Ajouter quelques données 
Envoyer une requête POST (avec Postman par ex.) sur http://localhost:8080/pets avec ces données :

{
"name": "Capitaine Patte de Fer",
"species": "Chien",
"superpower": "Vision laser",
"powerLevel": 95
}


Envoyer une requête POST (avec Postman par ex.) sur http://localhost:8080/missions avec ces données :

{
"name": "Sauver la ville des Rongeurs Géants",
"description": "Une menace rongeuse plane sur la ville, les Super-Animaux sont appelés à l'action !",
"difficulty": "Hard",
"assignedPetIds": "1,2"
}

    2. Tester le résultat sur http://localhost:8080/pets et missions


Filtres

    1. Lancer la DB Redis
        docker run --name my-redis -p 6379:6379 -d redis/redis-stack-server:latest
    2. Tester le Request Rate Limiter
        for i in $(seq 1 30); do curl -s -o /dev/null -w "%{http_code}\n" http://localhost:8080/missions; done
