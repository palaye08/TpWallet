package com.dakardrop.fulfillment.domain;

import com.dakardrop.sales.domain.StatutCommande;

import java.util.Objects;

/**
 * Value Object représentant une transition d'état de commande.
 * Immuable — associe un statut source à un statut cible.
 */
public final class Transition {

    private final StatutCommande de;
    private final StatutCommande vers;

    public Transition(StatutCommande de, StatutCommande vers) {
        if (de == null || vers == null) {
            throw new IllegalArgumentException("Les statuts de transition ne peuvent pas être null");
        }
        this.de = de;
        this.vers = vers;
    }

    public StatutCommande getDe() {
        return de;
    }

    public StatutCommande getVers() {
        return vers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return de == that.de && vers == that.vers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(de, vers);
    }

    @Override
    public String toString() {
        return de + " → " + vers;
    }
}
