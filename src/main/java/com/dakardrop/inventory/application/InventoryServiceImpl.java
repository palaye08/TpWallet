package com.dakardrop.inventory.application;

import com.dakardrop.inventory.domain.Product;
import com.dakardrop.inventory.infrastructure.ProductRepository;
import com.dakardrop.shared.ProduitIntrouvableException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implémentation concrète du service Inventory.
 * Utilise un ProductRepository (composition) pour la persistance.
 */
public class InventoryServiceImpl extends InventoryService {

    private final ProductRepository productRepository;

    public InventoryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product creerProduit(String id, String sku, String nom, String description, long prixXOF, int stockInitial) {
        // Vérifie que le SKU n'existe pas déjà
        productRepository.findBySKU(sku).ifPresent(existing -> {
            throw new IllegalArgumentException("Un produit avec le SKU '" + sku + "' existe déjà");
        });

        Product product = new Product(sku, nom, description, prixXOF, stockInitial);
        productRepository.save(product);
        return product;
    }

    @Override
    public void ajouterStock(String sku, int qte) {
        Product product = productRepository.findBySKU(sku)
                .orElseThrow(() -> new ProduitIntrouvableException("Produit introuvable avec le SKU : " + sku));
        product.ajouterStock(qte);
    }

    @Override
    public void retirerStock(String sku, int qte) {
        Product product = productRepository.findBySKU(sku)
                .orElseThrow(() -> new ProduitIntrouvableException("Produit introuvable avec le SKU : " + sku));
        // StockInsuffisantException propagée naturellement depuis StockQuantite.retirer()
        product.retirerStock(qte);
    }

    @Override
    public List<Product> getProduitsSousSeuilCritique(int seuil) {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getStock().estSousSeuil(seuil))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> rechercherParSKU(String sku) {
        return productRepository.findBySKU(sku);
    }
}
