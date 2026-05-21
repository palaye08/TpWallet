package com.dakardrop.inventory.infrastructure;

import com.dakardrop.inventory.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implémentation en mémoire du ProductRepository avec HashMap.
 */
public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> store = new HashMap<>();

    @Override
    public void save(Product product) {
        store.put(product.getSku().getValeur(), product);
    }

    @Override
    public Optional<Product> findBySKU(String sku) {
        return Optional.ofNullable(store.get(sku));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }
}
