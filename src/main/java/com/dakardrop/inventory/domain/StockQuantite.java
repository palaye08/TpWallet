package com.dakardrop.inventory.domain;

import java.util.Objects;

/**
 * Value Object représentant une quantité en stock.
 * Immuable — la quantité doit être >= 0, lève une exception si < 0.
 */
public final class StockQuantite {

    private final int quantite;

    public StockQuantite(int quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("La quantité en stock ne peut pas être négative, reçu : " + quantite);
        }
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    /**
     * Retourne un nouveau StockQuantite avec la quantité ajoutée.
     */
    public StockQuantite ajouter(int qte) {
        return new StockQuantite(this.quantite + qte);
    }

    /**
     * Retourne un nouveau StockQuantite avec la quantité retirée.
     * Lève IllegalArgumentException si le résultat serait négatif.
     */
    public StockQuantite retirer(int qte) {
        return new StockQuantite(this.quantite - qte);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockQuantite that = (StockQuantite) o;
        return quantite == that.quantite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantite);
    }

    @Override
    public String toString() {
        return "StockQuantite{" + quantite + "}";
    }
}
