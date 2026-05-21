package com.dakardrop.shared;

/**
 * Levée lorsqu'une transition d'état de commande est invalide.
 */
public class TransitionInvalideException extends DakarDropException {

    public TransitionInvalideException(String message) {
        super(message);
    }

    public TransitionInvalideException(String message, Throwable cause) {
        super(message, cause);
    }
}
