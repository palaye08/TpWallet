package com.dakardrop.fulfillment.infrastructure;

import com.dakardrop.fulfillment.domain.Livraison;

import java.util.List;
import java.util.Optional;

/**
 * Interface de repository pour les livraisons.
 */
public interface LivraisonRepository {

    /**
     * Sauvegarde une livraison.
     */
    void save(Livraison livraison);

    /**
     * Recherche une livraison par son identifiant.
     */
    Optional<Livraison> findById(String id);

    /**
     * Retourne toutes les livraisons.
     */
    List<Livraison> findAll();
}
