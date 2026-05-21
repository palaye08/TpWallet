package com.dakardrop.shared;

/**
 * Exception de base pour toutes les erreurs métier de DakarDrop.
 */
public class DakarDropException extends RuntimeException {

    public DakarDropException(String message) {
        super(message);
    }

    public DakarDropException(String message, Throwable cause) {
        super(message, cause);
    }
}
