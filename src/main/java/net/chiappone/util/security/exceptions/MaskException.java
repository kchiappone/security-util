package net.chiappone.util.security.exceptions;

public class MaskException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MaskException() {

    }

    /**
     * @param message
     */
    public MaskException( String message ) {

        super( message );

    }

    /**
     * @param cause
     */
    public MaskException( Throwable cause ) {

        super( cause );

    }

    /**
     * @param message
     * @param cause
     */
    public MaskException( String message, Throwable cause ) {

        super( message, cause );

    }

}
