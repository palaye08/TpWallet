package com.dakardrop.inventory.domain;

import java.util.Objects;

/**
 * Value Object représentant un SKU (Stock Keeping Unit).
 * Immuable — validation non-null et non-vide dans le constructeur.
 */
public final class SKU {

    private final String valeur;

    public SKU(String valeur) {
        if (valeur == null || valeur.isBlank()) {
            throw new IllegalArgumentException("Le SKU ne peut pas être null ou vide");
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
        return Objects.equals(valeur, sku.valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur);
    }

    @Override
    public String toString() {
        return "SKU{" + valeur + "}";
    }
}
