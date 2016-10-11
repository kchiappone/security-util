package net.chiappone.util.security.algorithms.encryption;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.exceptions.CryptException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;

/**
 * Implements AES-128, AES-192, and AES-256 bit encryption and decryption. Note that by default, the JRE only supports
 * AES-128 bit encryption and special JARs are required for AES-192 and AES-256 bit encryption.
 *
 * @author Kurtis Chiappone
 */
public class AES extends AbstractEncryptionAlgorithm<byte[]> {

    public AES( Algorithm algorithm ) {

        super( algorithm );

    }

    public byte[] decrypt( byte[] encrypted, byte[] key ) {

        SecretKeySpec keySpec = new SecretKeySpec( key, getAlgorithm().getInstanceName() );
        Cipher cipher = null;
        byte[] decrypted = null;

        try {

            cipher = Cipher.getInstance( getAlgorithm().getInstanceName() );
            cipher.init( Cipher.DECRYPT_MODE, keySpec );
            decrypted = cipher.doFinal( encrypted );

        } catch ( Exception e ) {

            throw new CryptException( e );

        }

        return decrypted;

    }

    public byte[] encrypt( byte[] data, byte[] key ) {

        SecretKeySpec keySpec = new SecretKeySpec( key, getAlgorithm().getInstanceName() );
        Cipher cipher = null;
        byte[] encrypted = null;

        try {

            cipher = Cipher.getInstance( getAlgorithm().getInstanceName() );
            cipher.init( Cipher.ENCRYPT_MODE, keySpec );
            encrypted = cipher.doFinal( data );

        } catch ( InvalidKeyException e ) {

            throw new CryptException( "This algorithm (" + getAlgorithm()
                            + ") may not be available without the proper JAR files.", e );

        } catch ( Exception e ) {

            throw new CryptException( e );

        }

        return encrypted;

    }

}
