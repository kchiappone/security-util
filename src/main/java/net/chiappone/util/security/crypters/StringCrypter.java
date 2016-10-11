package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.KeyHolder;
import net.chiappone.util.security.exceptions.CryptException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

/**
 * Encrypts/decrypts strings.
 * <p>
 * Note that before encryption/decryption, Strings are encoded/decoded to/from
 * Hex.
 */
public class StringCrypter implements Crypter<String> {

    /**
     * @param encrypted
     * @param key
     * @return
     */
    public String decrypt( String encrypted, KeyHolder key ) {

        try {

            byte[] encryptedHex = Hex.decodeHex( encrypted.toCharArray() );
            byte[] decrypted = new ByteCrypter().decrypt( encryptedHex, key );
            return new String( decrypted, "UTF-8" );

        } catch ( Exception e ) {

            throw new CryptException( e );

        }

    }

    /**
     * @param data
     * @param key
     * @return
     */
    public String encrypt( String data, KeyHolder key ) {

        try {

            return new String( Hex.encodeHex( new ByteCrypter().encrypt( data.getBytes( "UTF-8" ), key ) ) );

        } catch ( UnsupportedEncodingException e ) {

            throw new CryptException( e );

        }

    }
}
