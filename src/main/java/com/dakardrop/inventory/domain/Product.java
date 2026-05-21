package com.dakardrop.inventory.domain;

/**
 * Entité principale du module Inventory.
 * Représente un produit du catalogue avec son SKU, nom, description, prix et stock.
 */
public class Product {

    private final String id;
    private final SKU sku;
    private String nom;
    private String description;
    private Prix prix;
    private StockQuantite stock;

    public Product(String id, SKU sku, String nom, String description, Prix prix, StockQuantite stock) {
        this.id = id;
        this.sku = sku;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public StockQuantite getStock() {
        return stock;
    }

    public void setStock(StockQuantite stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", sku=" + sku +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", stock=" + stock +
                '}';
    }
}
