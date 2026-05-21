package com.dakardrop.sales.domain;

/**
 * Enum représentant les zones de livraison avec leurs frais associés en XOF.
 */
public enum ZoneLivraison {

    DAKAR_PLATEAU(1500),
    MEDINA(2000),
    PARCELLES(2500),
    RUFISQUE(3000),
    THIES(5000);

    private final long fraisXOF;

    ZoneLivraison(long fraisXOF) {
        this.fraisXOF = fraisXOF;
    }

    /**
     * Retourne les frais de livraison en Francs CFA (XOF).
     */
    public long getFraisXOF() {
        return fraisXOF;
    }
}
