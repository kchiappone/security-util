package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.algorithms.KeyHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * @author Kurtis Chiappone
 * @date 10/10/2016
 */
public class StringCrypterTest {

    private static final Logger logger = LoggerFactory.getLogger( StringCrypterTest.class );

    @org.junit.Test public void encrypt() throws Exception {

        final KeyHolder key = new KeyHolder( Algorithm.AES128 );
        final String data = "1234-5678-9012-3456-7890";

        StringCrypter crypter = new StringCrypter();
        String encrypted = crypter.encrypt( data, key );
        String decrypted = crypter.decrypt( encrypted, key );

        logger.info( "Original: {}, Encrypted: {}, Decrypted: {}", data, encrypted, decrypted );
        assertTrue( data.equals( decrypted ) );

    }

}