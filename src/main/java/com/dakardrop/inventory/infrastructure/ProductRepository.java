package com.dakardrop.inventory.infrastructure;

import com.dakardrop.inventory.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface de repository pour les produits.
 */
public interface ProductRepository {

    /**
     * Sauvegarde un produit.
     */
    void save(Product product);

    /**
     * Recherche un produit par son SKU.
     */
    Optional<Product> findBySKU(String sku);

    /**
     * Retourne tous les produits.
     */
    List<Product> findAll();
}
