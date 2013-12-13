DROP DATABASE IF EXISTS `DAC`;

CREATE DATABASE `DAC`;
USE `DAC`;


DROP TABLE IF EXISTS `loue`;
DROP TABLE IF EXISTS `achete`;
DROP TABLE IF EXISTS `acheteService`;
DROP TABLE IF EXISTS `service`;
DROP TABLE IF EXISTS `possedeStockAchat`;
DROP TABLE IF EXISTS `possedeStockLocation`;
DROP TABLE IF EXISTS `produitALouer`;
DROP TABLE IF EXISTS `produitAAcheter`;
DROP TABLE IF EXISTS `dimension`;
DROP TABLE IF EXISTS `commente`;
DROP TABLE IF EXISTS `produit`;
DROP TABLE IF EXISTS `categorieProduit`;
DROP TABLE IF EXISTS `client`;

DROP TABLE IF EXISTS `carteFidelite`;



CREATE TABLE `carteFidelite` (
	`num_carte` INT(16) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`points` INTEGER UNSIGNED NOT NULL DEFAULT '0'
);



CREATE TABLE `client` (
	`idClient` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`nom` VARCHAR(30) NOT NULL,
	`prenom` VARCHAR(30) NOT NULL,
	`adresse` VARCHAR(200) NOT NULL,
	`telephone` NUMERIC(10,0) NOT NULL,
	`mail` VARCHAR(50) NOT NULL UNIQUE,
	`mdp` VARCHAR(20) NOT NULL,
	`date_naissance` DATE NOT NULL,
	`date_creation` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`num_carte` INT(16) UNSIGNED NOT NULL,
	FOREIGN KEY(`num_carte`) REFERENCES `carteFidelite`(`num_carte`) ON DELETE CASCADE
);



CREATE TABLE `categorieProduit` (
	`idCategorie` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`nom` VARCHAR(30) NOT NULL,
	`saison` enum('été','hiver') NOT NULL
);




CREATE TABLE `produit` (
	`idProduit` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `nom` VARCHAR(50) NOT NULL,
	`description` TEXT,
	`prix` DECIMAL(11,2) UNSIGNED NOT NULL,
	`promotion` INTEGER UNSIGNED,
	`idCategorie` INTEGER UNSIGNED NOT NULL,
	FOREIGN KEY(`idCategorie`) REFERENCES `categorieProduit`(`idCategorie`) ON DELETE CASCADE
);



CREATE TABLE `commente` (
	`idProduit` INTEGER UNSIGNED NOT NULL,
	`idClient` INTEGER UNSIGNED NOT NULL,
        `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`texte` TEXT NOT NULL,
	PRIMARY KEY (idProduit, idClient),
	FOREIGN KEY(`idProduit`) REFERENCES `produit`(`idProduit`) ON DELETE CASCADE,
	FOREIGN KEY(`idClient`) REFERENCES `client`(`idClient`) ON DELETE CASCADE
);




CREATE TABLE `produitAAcheter` (
	`idProduit` INTEGER UNSIGNED NOT NULL PRIMARY KEY,
	`photo` VARCHAR(100),
	FOREIGN KEY(`idProduit`) REFERENCES `produit`(`idProduit`) ON DELETE CASCADE
);



CREATE TABLE `produitALouer` (
	`idProduit` INTEGER UNSIGNED NOT NULL PRIMARY KEY,
	`photo` VARCHAR(100),
	FOREIGN KEY(`idProduit`) REFERENCES `produit`(`idProduit`) ON DELETE CASCADE
);



CREATE TABLE `dimension` (
	`idDimension` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`label` enum('pointure','taille', 'longueur', 'largeur', 'poids') NOT NULL,
	`valeur` VARCHAR(20) NOT NULL
);




CREATE TABLE `possedeStockAchat` (
	`idProduit` INTEGER UNSIGNED NOT NULL,
	`idDimension` INTEGER UNSIGNED NOT NULL,
	`stock` INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY(`idProduit`, `idDimension`),
	FOREIGN KEY(`idProduit`) REFERENCES `produitAAcheter`(`idProduit`) ON DELETE CASCADE,
	FOREIGN KEY(`idDimension`) REFERENCES `dimension`(`idDimension`) ON DELETE CASCADE
);



CREATE TABLE `possedeStockLocation` (
	`idProduit` INTEGER UNSIGNED NOT NULL,
	`idDimension` INTEGER UNSIGNED NOT NULL,
	`stock` INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY(`idProduit`, `idDimension`),
	FOREIGN KEY(`idProduit`) REFERENCES `produitALouer`(`idProduit`) ON DELETE CASCADE,
	FOREIGN KEY(`idDimension`) REFERENCES `dimension`(`idDimension`) ON DELETE CASCADE
);


CREATE TABLE `service` (
	`idProduit` INTEGER UNSIGNED NOT NULL PRIMARY KEY,
	`time_description` TEXT,
	FOREIGN KEY(`idProduit`) REFERENCES `produit`(`idProduit`) ON DELETE CASCADE
);




CREATE TABLE `acheteService` (
	`idProduit` INTEGER UNSIGNED NOT NULL,
	`idClient` INTEGER UNSIGNED NOT NULL,
	`date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`quantite` INTEGER UNSIGNED NOT NULL,
	`prix` DECIMAL(11,2) UNSIGNED NOT NULL,
	`points` INTEGER UNSIGNED,
	`dateService` DATE NOT NULL,
	PRIMARY KEY (idProduit, idClient),
	FOREIGN KEY(`idProduit`) REFERENCES `service`(`idProduit`) ON DELETE CASCADE,
	FOREIGN KEY(`idClient`) REFERENCES `client`(`idClient`) ON DELETE CASCADE
);




CREATE TABLE `achete` (
	`idProduit` INTEGER UNSIGNED NOT NULL,
	`idClient` INTEGER UNSIGNED NOT NULL,
	`date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`quantite` INTEGER UNSIGNED NOT NULL,
	`prix` DECIMAL(11,2) UNSIGNED NOT NULL,
	`points` INTEGER UNSIGNED,
	`note` DECIMAL(2,1) UNSIGNED,
	`typeLivraison` enum('magasin','domicile') NOT NULL,
	`suiviCommande` enum('panier', 'en préparation', 'terminée') NOT NULL,
	PRIMARY KEY (idProduit, idClient),
	FOREIGN KEY(`idProduit`) REFERENCES `produitAAcheter`(`idProduit`) ON DELETE CASCADE,
	FOREIGN KEY(`idClient`) REFERENCES `client`(`idClient`) ON DELETE CASCADE
);


CREATE TABLE `loue` (
	`idProduit` INTEGER UNSIGNED NOT NULL,
	`idClient` INTEGER UNSIGNED NOT NULL,
	`date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`quantite` INTEGER UNSIGNED NOT NULL,
	`prix` DECIMAL(11,2) UNSIGNED NOT NULL,
	`points` INTEGER UNSIGNED,
	`etat` enum('panier', 'en attente', 'en location', 'terminée') NOT NULL,
	`dateDebut` DATE NOT NULL,
	`dateFin` DATE NOT NULL,	
	PRIMARY KEY (idProduit, idClient),
	FOREIGN KEY(`idProduit`) REFERENCES `produitALouer`(`idProduit`) ON DELETE CASCADE,
	FOREIGN KEY(`idClient`) REFERENCES `client`(`idClient`) ON DELETE CASCADE
);

