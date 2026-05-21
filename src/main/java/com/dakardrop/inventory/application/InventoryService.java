package com.dakardrop.inventory.application;

import com.dakardrop.inventory.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Classe abstraite définissant le contrat du service Inventory.
 * Ne contient aucune logique métier — uniquement les signatures abstraites.
 */
public abstract class InventoryService {

    /**
     * Crée un nouveau produit dans le catalogue.
     */
    public abstract Product creerProduit(String id, String sku, String nom, String description, long prixXOF, int stockInitial);

    /**
     * Ajoute du stock pour le produit identifié par son SKU.
     */
    public abstract void ajouterStock(String sku, int qte);

    /**
     * Retire du stock pour le produit identifié par son SKU.
     * Lève StockInsuffisantException si le stock est insuffisant.
     */
    public abstract void retirerStock(String sku, int qte);

    /**
     * Retourne la liste des produits dont le stock est en dessous du seuil critique.
     */
    public abstract List<Product> getProduitsSousSeuilCritique(int seuil);

    /**
     * Recherche un produit par son SKU.
     */
    public abstract Optional<Product> rechercherParSKU(String sku);
}
