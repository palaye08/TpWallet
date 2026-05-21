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
            throw new IllegalArgumentException("Le prix doit être strictement positif, reçu : " + montantXOF);
        }
        this.montantXOF = montantXOF;
    }

    public long getMontantXOF() {
        return montantXOF;
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
