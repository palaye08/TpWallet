package com.dakardrop.fulfillment.domain;

import com.dakardrop.sales.domain.Commande;
import com.dakardrop.sales.domain.StatutCommande;
import com.dakardrop.sales.domain.ZoneLivraison;

/**
 * Entité représentant une livraison.
 * Associe une commande à un livreur, un statut et une zone de livraison.
 */
public class Livraison {

    private final String id;
    private final Commande commande;
    private final String nomLivreur;
    private StatutCommande statut;
    private final ZoneLivraison zone;

    public Livraison(String id, Commande commande, String nomLivreur, StatutCommande statut, ZoneLivraison zone) {
        this.id = id;
        this.commande = commande;
        this.nomLivreur = nomLivreur;
        this.statut = statut;
        this.zone = zone;
    }

    public String getId() {
        return id;
    }

    public Commande getCommande() {
        return commande;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public ZoneLivraison getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "id='" + id + '\'' +
                ", commande=" + commande.getId() +
                ", livreur='" + nomLivreur + '\'' +
                ", statut=" + statut +
                ", zone=" + zone +
                '}';
    }
}
