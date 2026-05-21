package com.dakardrop.sales.domain;

import com.dakardrop.inventory.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Entité représentant un panier d'achat.
 * Contient les lignes (produit → quantité) et un code promo optionnel.
 */
public class Panier {

    private final Map<Product, Integer> lignes;
    private Optional<CodePromo> promo;

    public Panier() {
        this.lignes = new HashMap<>();
        this.promo = Optional.empty();
    }

    public Map<Product, Integer> getLignes() {
        return lignes;
    }

    public Optional<CodePromo> getPromo() {
        return promo;
    }

    public void setPromo(CodePromo promo) {
        this.promo = Optional.ofNullable(promo);
    }

    /**
     * Ajoute un produit au panier avec la quantité spécifiée.
     */
    public void ajouterProduit(Product produit, int quantite) {
        lignes.merge(produit, quantite, Integer::sum);
    }

    /**
     * Retire un produit du panier par son SKU.
     */
    public void retirerProduit(String sku) {
        lignes.entrySet().removeIf(entry -> entry.getKey().getSku().getValeur().equals(sku));
    }

    /**
     * Vérifie si le panier est vide.
     */
    public boolean estVide() {
        return lignes.isEmpty();
    }

    @Override
    public String toString() {
        return "Panier{lignes=" + lignes.size() + " produit(s), promo=" + promo + "}";
    }
}
