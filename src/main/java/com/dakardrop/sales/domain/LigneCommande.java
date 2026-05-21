package com.dakardrop.sales.domain;

import com.dakardrop.inventory.domain.Prix;
import com.dakardrop.inventory.domain.Product;

import java.util.Objects;

/**
 * Value Object représentant une ligne de commande.
 * Immuable — associe un produit à une quantité et un prix unitaire.
 */
public final class LigneCommande {

    private final Product produit;
    private final int quantite;
    private final Prix prixUnitaire;

    public LigneCommande(Product produit, int quantite, Prix prixUnitaire) {
        if (produit == null) {
            throw new IllegalArgumentException("Le produit ne peut pas être null");
        }
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité doit être positive");
        }
        if (prixUnitaire == null) {
            throw new IllegalArgumentException("Le prix unitaire ne peut pas être null");
        }
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public Product getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public Prix getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * Calcule le sous-total de cette ligne (prix unitaire × quantité).
     */
    public long getSousTotal() {
        return prixUnitaire.getMontantXOF() * quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommande that = (LigneCommande) o;
        return quantite == that.quantite &&
                Objects.equals(produit, that.produit) &&
                Objects.equals(prixUnitaire, that.prixUnitaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produit, quantite, prixUnitaire);
    }

    @Override
    public String toString() {
        return "LigneCommande{" + produit.getNom() + " x" + quantite + " @ " + prixUnitaire + "}";
    }
}
