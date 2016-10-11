package net.chiappone.util.security.algorithms;

import net.chiappone.util.security.exceptions.CryptException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Kurtis Chiappone
 */
public class KeyHolder {

    private Algorithm algorithm = null;
    private byte[] keyBytes = null;

    /**
     * @param algorithm
     */
    public KeyHolder( Algorithm algorithm ) {

        this.algorithm = algorithm;
        this.keyBytes = generateKey( algorithm );

    }

    /**
     * @param type
     * @return
     */
    public static byte[] generateKey( Algorithm type ) {

        int bits = 0;
        String instance = "";

        switch ( type ) {

            case AES128:
            case AES192:
            case AES256:
                bits = type.getBits();
                instance = type.getInstanceName();
                break;
            default:
                type.getInstanceName();
                break;

        }

        KeyGenerator keyGen = null;

        try {

            keyGen = KeyGenerator.getInstance( instance );

            if ( bits > 0 ) {

                keyGen.init( bits );

            }

        } catch ( NoSuchAlgorithmException e ) {

            throw new CryptException( e );

        }

        SecretKey key = keyGen.generateKey();
        return key.getEncoded();

    }

    /**
     * @return the algorithm
     */
    public Algorithm getAlgorithm() {

        return algorithm;
    }

    /**
     * @param algorithm the algorithm to set
     */
    public void setAlgorithm( Algorithm algorithm ) {

        this.algorithm = algorithm;
        setKeyBytes( generateKey( algorithm ) );
    }

    /**
     * @return the keyBytes
     */
    public byte[] getKeyBytes() {

        return keyBytes;
    }

    /**
     * @param keyBytes the keyBytes to set
     */
    public void setKeyBytes( byte[] keyBytes ) {

        this.keyBytes = keyBytes;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override public String toString() {

        return "Key [algorithm=" + algorithm + ", keyBytes=" + Arrays.toString( keyBytes ) + "]";

    }

}
