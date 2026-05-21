package com.dakardrop.inventory.application;

import com.dakardrop.inventory.domain.Product;
import com.dakardrop.inventory.infrastructure.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation concrète du service Inventory.
 * Utilise un ProductRepository pour la persistance.
 */
public class InventoryServiceImpl extends InventoryService {

    private final ProductRepository productRepository;

    public InventoryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product creerProduit(String id, String sku, String nom, String description, long prixXOF, int stockInitial) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void ajouterStock(String sku, int qte) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void retirerStock(String sku, int qte) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<Product> getProduitsSousSeuilCritique(int seuil) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Optional<Product> rechercherParSKU(String sku) {
        throw new UnsupportedOperationException("TODO");
    }
}
