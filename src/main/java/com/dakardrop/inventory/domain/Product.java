package com.dakardrop.inventory.domain;

import java.util.Objects;
import java.util.UUID;

/**
 * Entité principale du module Inventory.
 * Représente un produit du catalogue avec son SKU, nom, description, prix et stock.
 * equals/hashCode basés sur le SKU uniquement.
 */
public class Product {

    private final String id;
    private final SKU sku;
    private final String nom;
    private final String description;
    private final Prix prixUnitaire;
    private StockQuantite stock;

    /**
     * Constructeur principal — l'ID est généré automatiquement (UUID).
     */
    public Product(String sku, String nom, String description, long prixXOF, int stockInitial) {
        this.id = UUID.randomUUID().toString();
        this.sku = new SKU(sku);
        this.nom = nom;
        this.description = description;
        this.prixUnitaire = new Prix(prixXOF);
        this.stock = new StockQuantite(stockInitial);
    }

    public String getId() {
        return id;
    }

    public SKU getSku() {
        return sku;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Prix getPrixUnitaire() {
        return prixUnitaire;
    }

    public StockQuantite getStock() {
        return stock;
    }

    /**
     * Ajoute du stock au produit.
     *
     * @param qte la quantité à ajouter
     */
    public void ajouterStock(int qte) {
        this.stock = this.stock.ajouter(qte);
    }

    /**
     * Retire du stock au produit.
     * Lève StockInsuffisantException si le stock est insuffisant.
     *
     * @param qte la quantité à retirer
     */
    public void retirerStock(int qte) {
        this.stock = this.stock.retirer(qte);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", sku=" + sku +
                ", nom='" + nom + '\'' +
                ", prix=" + prixUnitaire +
                ", stock=" + stock +
                '}';
    }
}
