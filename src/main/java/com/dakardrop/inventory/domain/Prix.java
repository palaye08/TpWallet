package com.dakardrop.inventory.domain;

import java.util.Objects;

/**
 * Value Object représentant un prix en Francs CFA (XOF).
 * Immuable — le montant doit être strictement positif.
 */
public final class Prix {

    private final long montantXOF;

    public Prix(long montantXOF) {
        if (montantXOF <= 0) {
            throw new IllegalArgumentException("Prix doit être > 0");
        }
        this.montantXOF = montantXOF;
    }

    public long getMontantXOF() {
        return montantXOF;
    }

    /**
     * Applique une réduction en pourcentage et retourne un nouveau Prix.
     *
     * @param pourcentage le pourcentage de réduction (ex: 15.0 pour 15%)
     * @return un nouveau Prix avec la réduction appliquée
     */
    public Prix appliquerReduction(double pourcentage) {
        long nouveauMontant = (long) (montantXOF * (1 - pourcentage / 100));
        return new Prix(Math.max(nouveauMontant, 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prix prix = (Prix) o;
        return montantXOF == prix.montantXOF;
    }

    @Override
    public int hashCode() {
        return Objects.hash(montantXOF);
    }

    @Override
    public String toString() {
        return montantXOF + " XOF";
    }
}
