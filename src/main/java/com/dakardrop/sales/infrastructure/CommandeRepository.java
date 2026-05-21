package com.dakardrop.sales.infrastructure;

import com.dakardrop.sales.domain.Commande;

import java.util.List;
import java.util.Optional;

/**
 * Interface de repository pour les commandes.
 */
public interface CommandeRepository {

    /**
     * Sauvegarde une commande.
     */
    void save(Commande commande);

    /**
     * Recherche une commande par son identifiant.
     */
    Optional<Commande> findById(String id);

    /**
     * Retourne toutes les commandes.
     */
    List<Commande> findAll();
}
