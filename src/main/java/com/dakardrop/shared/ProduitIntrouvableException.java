package com.dakardrop.shared;

/**
 * Levée lorsqu'un produit recherché est introuvable.
 */
public class ProduitIntrouvableException extends DakarDropException {

    public ProduitIntrouvableException(String message) {
        super(message);
    }

    public ProduitIntrouvableException(String message, Throwable cause) {
        super(message, cause);
    }
}
