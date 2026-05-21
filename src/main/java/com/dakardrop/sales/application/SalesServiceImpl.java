package com.dakardrop.sales.application;

import com.dakardrop.inventory.application.InventoryService;
import com.dakardrop.inventory.domain.Product;
import com.dakardrop.sales.domain.*;

/**
 * Implémentation concrète du service Sales.
 * Collabore avec InventoryService par COMPOSITION.
 */
public class SalesServiceImpl extends SalesService {

    private final InventoryService inventoryService;

    public SalesServiceImpl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public Panier creerPanier() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void ajouterAuPanier(Panier p, Product prod, int qte) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void retirerDuPanier(Panier p, String sku) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void appliquerCodePromo(Panier p, String code) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Commande validerCommande(Panier p, Adresse a, ZoneLivraison z) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public long calculerTotal(Panier p, ZoneLivraison z) {
        throw new UnsupportedOperationException("TODO");
    }
}
