package com.dakardrop.sales.domain;

import com.dakardrop.inventory.domain.Prix;

import java.util.Collections;
import java.util.List;

/**
 * Entité représentant une commande validée.
 * Immuable après validation — tous les champs sont final.
 */
public class Commande {

    private final String id;
    private final List<LigneCommande> lignes;
    private StatutCommande statut;
    private final Prix total;
    private final Adresse adresseLivraison;

    public Commande(String id, List<LigneCommande> lignes, StatutCommande statut, Prix total, Adresse adresseLivraison) {
        this.id = id;
        this.lignes = Collections.unmodifiableList(lignes);
        this.statut = statut;
        this.total = total;
        this.adresseLivraison = adresseLivraison;
    }

    public String getId() {
        return id;
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public Prix getTotal() {
        return total;
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id='" + id + '\'' +
                ", lignes=" + lignes.size() +
                ", statut=" + statut +
                ", total=" + total +
                ", adresse=" + adresseLivraison +
                '}';
    }
}
