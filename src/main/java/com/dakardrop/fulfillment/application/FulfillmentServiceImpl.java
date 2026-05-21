package com.dakardrop.fulfillment.application;

import com.dakardrop.fulfillment.domain.Livraison;
import com.dakardrop.inventory.application.InventoryService;
import com.dakardrop.sales.domain.Commande;
import com.dakardrop.sales.domain.ZoneLivraison;

import java.util.List;

/**
 * Implémentation concrète du service Fulfillment.
 * Collabore avec InventoryService par COMPOSITION pour recréditer le stock en cas d'annulation.
 */
public class FulfillmentServiceImpl extends FulfillmentService {

    private final InventoryService inventoryService;

    public FulfillmentServiceImpl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public Livraison assignerLivreur(Commande c, String nomLivreur, ZoneLivraison z) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void passerEnRoute(Livraison l) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void confirmerLivraison(Livraison l) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void annulerLivraison(Livraison l) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<Livraison> getLivraisonsEnCours() {
        throw new UnsupportedOperationException("TODO");
    }
}
