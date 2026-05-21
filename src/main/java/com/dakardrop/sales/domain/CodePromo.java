package com.dakardrop.sales.domain;

import java.util.Objects;

/**
 * Value Object représentant un code promotionnel.
 * Immuable.
 */
public final class CodePromo {

    private final String code;
    private final TypeReduction type;
    private final double valeur;

    public CodePromo(String code, TypeReduction type, double valeur) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Le code promo ne peut pas être null ou vide");
        }
        if (type == null) {
            throw new IllegalArgumentException("Le type de réduction ne peut pas être null");
        }
        this.code = code;
        this.type = type;
        this.valeur = valeur;
    }

    public String getCode() {
        return code;
    }

    public TypeReduction getType() {
        return type;
    }

    public double getValeur() {
        return valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodePromo codePromo = (CodePromo) o;
        return Double.compare(codePromo.valeur, valeur) == 0 &&
                Objects.equals(code, codePromo.code) &&
                type == codePromo.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, type, valeur);
    }

    @Override
    public String toString() {
        return "CodePromo{" + code + ", " + type + ", valeur=" + valeur + "}";
    }
}
