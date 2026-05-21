package com.dakardrop.shared;

/**
 * Levée lorsqu'on tente de valider une commande vide (panier sans lignes).
 */
public class CommandeVideException extends DakarDropException {

    public CommandeVideException(String message) {
        super(message);
    }

    public CommandeVideException(String message, Throwable cause) {
        super(message, cause);
    }
}
