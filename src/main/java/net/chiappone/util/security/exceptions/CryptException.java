package net.chiappone.util.security.exceptions;

public class CryptException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CryptException() {

        super();

    }

    /**
     * @param message
     */
    public CryptException( String message ) {

        super( message );

    }

    /**
     * @param cause
     */
    public CryptException( Throwable cause ) {

        super( cause );

    }

    /**
     * @param message
     * @param cause
     */
    public CryptException( String message, Throwable cause ) {

        super( message, cause );

    }

}
