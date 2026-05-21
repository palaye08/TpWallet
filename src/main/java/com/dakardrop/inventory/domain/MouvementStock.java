package com.dakardrop.inventory.domain;

import java.util.Objects;

/**
 * Value Object représentant un mouvement de stock (entrée ou sortie).
 * Immuable.
 */
public final class MouvementStock {

    /**
     * Type de mouvement de stock.
     */
    public enum TypeMouvement {
        ENTREE,
        SORTIE
    }

    private final TypeMouvement type;
    private final int quantite;

    public MouvementStock(TypeMouvement type, int quantite) {
        if (type == null) {
            throw new IllegalArgumentException("Le type de mouvement ne peut pas être null");
        }
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité du mouvement doit être positive, reçu : " + quantite);
        }
        this.type = type;
        this.quantite = quantite;
    }

    public TypeMouvement getType() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MouvementStock that = (MouvementStock) o;
        return quantite == that.quantite && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, quantite);
    }

    @Override
    public String toString() {
        return "MouvementStock{" + type + ", quantite=" + quantite + "}";
    }
}
