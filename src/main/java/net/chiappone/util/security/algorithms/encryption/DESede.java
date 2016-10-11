package net.chiappone.util.security.algorithms.encryption;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.exceptions.CryptException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Implements DESede encryption and decryption.
 */
public class DESede implements EncryptionAlgorithm<byte[]> {

    private static final String INSTANCE_NAME = Algorithm.DESEDE.getInstanceName();

    /*
     * (non-Javadoc)
     *
     * @see
     * EncryptionAlgorithm#decrypt
     * (java.lang.Object, byte[])
     */
    public byte[] decrypt( byte[] encrypted, byte[] key ) {

        SecretKeySpec keySpec = new SecretKeySpec( key, INSTANCE_NAME );
        Cipher cipher = null;
        byte[] decrypted = null;

        try {

            cipher = Cipher.getInstance( INSTANCE_NAME );
            cipher.init( Cipher.DECRYPT_MODE, keySpec );
            decrypted = cipher.doFinal( encrypted );

        } catch ( Exception e ) {

            throw new CryptException( e );

        }

        return decrypted;

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * EncryptionAlgorithm#encrypt
     * (java.lang.Object, byte[])
     */
    public byte[] encrypt( byte[] data, byte[] key ) {

        SecretKeySpec keySpec = new SecretKeySpec( key, INSTANCE_NAME );
        Cipher cipher = null;
        byte[] encrypted = null;

        try {

            cipher = Cipher.getInstance( INSTANCE_NAME );
            cipher.init( Cipher.ENCRYPT_MODE, keySpec );
            encrypted = cipher.doFinal( data );

        } catch ( Exception e ) {

            throw new CryptException( e );

        }

        return encrypted;

    }

}
