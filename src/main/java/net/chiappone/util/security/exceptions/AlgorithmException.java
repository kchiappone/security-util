package net.chiappone.util.security.exceptions;

import net.chiappone.util.security.algorithms.Algorithm;

import java.util.List;

public class AlgorithmException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlgorithmException() {

        super();

    }

    /**
     * @param message
     */
    public AlgorithmException( String message ) {

        super( message );

    }

    /**
     * @param message
     * @param cause
     */
    public AlgorithmException( String message, Throwable cause ) {

        super( message, cause );

    }

    /**
     * @param cause
     */
    public AlgorithmException( Throwable cause ) {

        super( cause );

    }

    /**
     * Generates a String used to inform the user that the algorithm specified
     * is not supported by the crypter and provides a list of supported
     * algorithms.
     *
     * @param unsupported
     * @param supportedAlgorithms
     * @return
     */
    public static String getMessageFor( Algorithm unsupported, List<Algorithm> supportedAlgorithms ) {

        String msg = "This algorithm is unsupported (" + unsupported + ").";
        msg += "\nSupported algorithms: ";

        boolean first = true;

        for ( Algorithm algorithm : supportedAlgorithms ) {

            if ( first ) {

                msg += algorithm;
                first = false;

            } else {

                msg += ", " + algorithm;

            }

        }

        return msg;

    }

}
