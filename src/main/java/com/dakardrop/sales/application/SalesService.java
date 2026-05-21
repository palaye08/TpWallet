package com.dakardrop.sales.application;

import com.dakardrop.inventory.domain.Product;
import com.dakardrop.sales.domain.*;

/**
 * Classe abstraite définissant le contrat du service Sales.
 * Ne contient aucune logique métier — uniquement les signatures abstraites.
 */
public abstract class SalesService {

    /**
     * Crée un nouveau panier vide.
     */
    public abstract Panier creerPanier();

    /**
     * Ajoute un produit au panier avec la quantité spécifiée.
     */
    public abstract void ajouterAuPanier(Panier p, Product prod, int qte);

    /**
     * Retire un produit du panier par son SKU.
     */
    public abstract void retirerDuPanier(Panier p, String sku);

    /**
     * Applique un code promotionnel au panier.
     */
    public abstract void appliquerCodePromo(Panier p, String code);

    /**
     * Valide le panier et crée une commande.
     */
    public abstract Commande validerCommande(Panier p, Adresse a, ZoneLivraison z);

    /**
     * Calcule le total d'un panier incluant les frais de livraison.
     */
    public abstract long calculerTotal(Panier p, ZoneLivraison z);
}
