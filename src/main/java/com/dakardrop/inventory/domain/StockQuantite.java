package com.dakardrop.inventory.domain;

import com.dakardrop.shared.StockInsuffisantException;

import java.util.Objects;

/**
 * Value Object représentant une quantité en stock.
 * Immuable — la quantité doit être >= 0, lève StockInsuffisantException si < 0.
 */
public final class StockQuantite {

    private final int quantite;

    public StockQuantite(int quantite) {
        if (quantite < 0) {
            throw new StockInsuffisantException("Stock négatif interdit : " + quantite);
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
     * Lève StockInsuffisantException si le résultat serait négatif.
     */
    public StockQuantite retirer(int qte) {
        return new StockQuantite(this.quantite - qte);
    }

    /**
     * Vérifie si la quantité est en dessous d'un seuil donné.
     *
     * @param seuil le seuil critique
     * @return true si la quantité est strictement inférieure au seuil
     */
    public boolean estSousSeuil(int seuil) {
        return this.quantite < seuil;
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
