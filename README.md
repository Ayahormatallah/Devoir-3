Cette application a pour objectif de gérer l'état civil des citoyens de notre province. Elle permet de manipuler des entités telles que Homme, Femme, et Mariage à travers une interface générique IDao. Elle intègre une couche de persistance utilisant Hibernate pour la gestion de la base de données MySQL et une couche service pour implémenter les règles métier et fournir des fonctionnalités avancées.

Structure du Projet
Le projet est structuré en plusieurs packages pour mieux organiser les différentes couches de l'application :

ma.projet.beans : Contient les classes entités avec les annotations pour la persistance des données.
ma.projet.config : Contient le fichier de configuration Hibernate.
ma.projet.dao : Définit l'interface générique IDao pour les opérations CRUD.
ma.projet.service : Contient les services qui implémentent l'interface IDao et les méthodes métier spécifiques.
ma.projet.util : Contient des utilitaires, notamment la classe HibernateUtil pour la gestion de la session Hibernate.
Fonctionnalités
Couche de persistance (6 points)
Développement des classes entités dans le package ma.projet.beans, en utilisant les annotations vues en classe, telles que @Entity, @Table, @Id, etc. (3 points).
Création du fichier de configuration Hibernate hibernate.cfg.xml dans le package ma.projet.config pour la configuration de la base de données MySQL (1 point).
Création de la classe HibernateUtil dans le package ma.projet.util pour gérer les sessions Hibernate (1 point).
Génération de la base de données sous MySQL à partir des entités (1 point).
