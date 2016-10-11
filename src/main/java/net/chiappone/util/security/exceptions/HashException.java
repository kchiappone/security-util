package net.chiappone.util.security.exceptions;

/**
 * @author Kurtis Chiappone
 */
public class HashException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HashException() {

        super();

    }

    public HashException( String message, Throwable cause ) {

        super( message, cause );

    }

    public HashException( String message ) {

        super( message );

    }

    public HashException( Throwable cause ) {

        super( cause );

    }

}
