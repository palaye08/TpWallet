package com.dakardrop.fulfillment.infrastructure;

import com.dakardrop.fulfillment.domain.Livraison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implémentation en mémoire du LivraisonRepository avec HashMap.
 */
public class InMemoryLivraisonRepository implements LivraisonRepository {

    private final Map<String, Livraison> store = new HashMap<>();

    @Override
    public void save(Livraison livraison) {
        store.put(livraison.getId(), livraison);
    }

    @Override
    public Optional<Livraison> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Livraison> findAll() {
        return new ArrayList<>(store.values());
    }
}
