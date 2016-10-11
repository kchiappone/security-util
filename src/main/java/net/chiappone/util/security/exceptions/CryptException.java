package net.chiappone.util.security.exceptions;

/**
 * @author Kurtis Chiappone
 */
public class CryptException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CryptException() {

        super();

    }

    public CryptException( String message ) {

        super( message );

    }

    public CryptException( Throwable cause ) {

        super( cause );

    }

    public CryptException( String message, Throwable cause ) {

        super( message, cause );

    }

}
