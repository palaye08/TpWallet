package com.dakardrop.inventory.domain;

import java.util.Objects;

/**
 * Value Object représentant un SKU (Stock Keeping Unit).
 * Immuable — validation non-null et non-vide dans le constructeur.
 * equals/hashCode ignorent la casse.
 */
public final class SKU {

    private final String valeur;

    public SKU(String valeur) {
        if (valeur == null || valeur.isBlank()) {
            throw new IllegalArgumentException("SKU invalide");
        }
        this.valeur = valeur;
    }

    public String getValeur() {
        return valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SKU sku = (SKU) o;
        return valeur.equalsIgnoreCase(sku.valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur.toLowerCase());
    }

    @Override
    public String toString() {
        return valeur;
    }
}
