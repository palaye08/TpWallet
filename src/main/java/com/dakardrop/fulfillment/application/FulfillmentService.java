package com.dakardrop.fulfillment.application;

import com.dakardrop.fulfillment.domain.Livraison;
import com.dakardrop.sales.domain.Commande;
import com.dakardrop.sales.domain.StatutCommande;
import com.dakardrop.sales.domain.ZoneLivraison;
import com.dakardrop.shared.TransitionInvalideException;

import java.util.List;
import java.util.Set;

/**
 * Classe abstraite définissant le contrat du service Fulfillment.
 * Contient les signatures abstraites et une méthode concrète protégée
 * pour valider les transitions d'état.
 */
public abstract class FulfillmentService {

    /**
     * Transitions valides de la machine d'états.
     * EN_PREPARATION → EN_ROUTE
     * EN_ROUTE → LIVREE_ET_PAYEE ou ANNULEE
     */
    private static final Set<String> TRANSITIONS_VALIDES = Set.of(
            StatutCommande.EN_PREPARATION + "->" + StatutCommande.EN_ROUTE,
            StatutCommande.EN_ROUTE + "->" + StatutCommande.LIVREE_ET_PAYEE,
            StatutCommande.EN_ROUTE + "->" + StatutCommande.ANNULEE
    );

    /**
     * Assigne un livreur à une commande pour une zone donnée.
     */
    public abstract Livraison assignerLivreur(Commande c, String nomLivreur, ZoneLivraison z);

    /**
     * Passe une livraison en statut EN_ROUTE.
     */
    public abstract void passerEnRoute(Livraison l);

    /**
     * Confirme la livraison (statut LIVREE_ET_PAYEE).
     */
    public abstract void confirmerLivraison(Livraison l);

    /**
     * Annule une livraison (statut ANNULEE) et recrédite le stock.
     */
    public abstract void annulerLivraison(Livraison l);

    /**
     * Retourne la liste des livraisons en cours (statut EN_PREPARATION ou EN_ROUTE).
     */
    public abstract List<Livraison> getLivraisonsEnCours();

    /**
     * Valide qu'une transition d'état est autorisée par la machine d'états.
     * Lève TransitionInvalideException si la transition est invalide.
     *
     * Transitions valides :
     *   EN_PREPARATION → EN_ROUTE uniquement
     *   EN_ROUTE → LIVREE_ET_PAYEE ou ANNULEE uniquement
     *   Toute autre transition lève IllegalStateException
     *
     * @param actuel  le statut actuel
     * @param suivant le statut cible
     */
    protected void validerTransition(StatutCommande actuel, StatutCommande suivant) {
        String cle = actuel + "->" + suivant;
        if (!TRANSITIONS_VALIDES.contains(cle)) {
            throw new TransitionInvalideException(
                    "Transition invalide : " + actuel + " → " + suivant
            );
        }
    }
}
