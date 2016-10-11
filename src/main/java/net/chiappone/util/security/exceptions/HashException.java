package net.chiappone.util.security.exceptions;

public class HashException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HashException() {

        super();

    }

    /**
     * @param message
     * @param cause
     */
    public HashException( String message, Throwable cause ) {

        super( message, cause );

    }

    /**
     * @param message
     */
    public HashException( String message ) {

        super( message );

    }

    /**
     * @param cause
     */
    public HashException( Throwable cause ) {

        super( cause );

    }

}
