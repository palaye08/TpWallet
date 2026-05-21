package com.dakardrop.sales.infrastructure;

import com.dakardrop.sales.domain.Commande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implémentation en mémoire du CommandeRepository avec HashMap.
 */
public class InMemoryCommandeRepository implements CommandeRepository {

    private final Map<String, Commande> store = new HashMap<>();

    @Override
    public void save(Commande commande) {
        store.put(commande.getId(), commande);
    }

    @Override
    public Optional<Commande> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Commande> findAll() {
        return new ArrayList<>(store.values());
    }
}
