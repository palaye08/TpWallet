package com.dakardrop.sales.domain;

import java.util.Objects;

/**
 * Value Object représentant une adresse de livraison.
 * Immuable — tous les champs sont obligatoires.
 */
public final class Adresse {

    private final String rue;
    private final String commune;
    private final String ville;

    public Adresse(String rue, String commune, String ville) {
        if (rue == null || rue.isBlank()) {
            throw new IllegalArgumentException("La rue est obligatoire");
        }
        if (commune == null || commune.isBlank()) {
            throw new IllegalArgumentException("La commune est obligatoire");
        }
        if (ville == null || ville.isBlank()) {
            throw new IllegalArgumentException("La ville est obligatoire");
        }
        this.rue = rue;
        this.commune = commune;
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public String getCommune() {
        return commune;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(rue, adresse.rue) &&
                Objects.equals(commune, adresse.commune) &&
                Objects.equals(ville, adresse.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rue, commune, ville);
    }

    @Override
    public String toString() {
        return rue + ", " + commune + ", " + ville;
    }
}
