# DakarDrop — Backend Système de Gestion COD

## Description

DakarDrop est un système backend de gestion **Cash On Delivery (COD)** conçu pour le e-commerce sénégalais. Le projet est structuré selon les principes du **Domain-Driven Design (DDD)** et exploite les fonctionnalités modernes de Java 17 : Value Objects immuables, `Optional`, Streams, composition et héritage avec classes abstraites.

## Arborescence des packages

```
src/main/java/com/dakardrop/
├── Main.java
├── shared/
│   ├── DakarDropException.java
│   ├── StockInsuffisantException.java
│   ├── TransitionInvalideException.java
│   ├── CommandeVideException.java
│   └── ProduitIntrouvableException.java
├── inventory/
│   ├── domain/
│   │   ├── Product.java
│   │   ├── SKU.java
│   │   ├── Prix.java
│   │   ├── StockQuantite.java
│   │   └── MouvementStock.java
│   ├── application/
│   │   ├── InventoryService.java
│   │   └── InventoryServiceImpl.java
│   └── infrastructure/
│       ├── ProductRepository.java
│       └── InMemoryProductRepository.java
├── sales/
│   ├── domain/
│   │   ├── Panier.java
│   │   ├── Commande.java
│   │   ├── LigneCommande.java
│   │   ├── CodePromo.java
│   │   ├── TypeReduction.java
│   │   ├── StatutCommande.java
│   │   ├── Adresse.java
│   │   └── ZoneLivraison.java
│   ├── application/
│   │   ├── SalesService.java
│   │   └── SalesServiceImpl.java
│   └── infrastructure/
│       ├── CommandeRepository.java
│       └── InMemoryCommandeRepository.java
└── fulfillment/
    ├── domain/
    │   ├── Livraison.java
    │   └── Transition.java
    ├── application/
    │   ├── FulfillmentService.java
    │   └── FulfillmentServiceImpl.java
    └── infrastructure/
        ├── LivraisonRepository.java
        └── InMemoryLivraisonRepository.java
```

## Prérequis

- **Java 17** (JDK 17+)
- **Maven 3.8+**

## Installation & Build

```bash
# Cloner le projet
git init
git add .
git commit -m "init: architecture DDD DakarDrop"
git branch -M main

# Compiler le projet
mvn clean compile

# Lancer les tests
mvn clean test
```

## Architecture

Le projet suit une architecture **DDD (Domain-Driven Design)** avec 3 modules autonomes :

| Module         | Responsabilité                          |
|----------------|----------------------------------------|
| `inventory`    | Catalogue produits & gestion des stocks |
| `sales`        | Panier, commandes & promotions          |
| `fulfillment`  | Logistique, livraison & Cash On Delivery|

Chaque module est découpé en 3 couches :
- **domain/** — Entités, Value Objects, règles métier
- **application/** — Services applicatifs (classes abstraites + implémentations)
- **infrastructure/** — Repositories (implémentations en mémoire)
