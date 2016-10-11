package net.chiappone.util.security.exceptions;

/**
 * @author Kurtis Chiappone
 */
public class MaskException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MaskException() {

    }

    public MaskException( String message ) {

        super( message );

    }

    public MaskException( Throwable cause ) {

        super( cause );

    }

    public MaskException( String message, Throwable cause ) {

        super( message, cause );

    }

}
