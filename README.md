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
    Communication possible entre les services via Eureka et Feign


Chaque service (pet-service et mission-service) utilise une base de données H2 Database en mémoire, 
ce qui la rend parfaite pour une démo rapide sans configuration de base de données externe

🚀 Démarrage Rapide
    
TODO 


