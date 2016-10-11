package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.algorithms.KeyHolder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * @author Kurtis Chiappone
 */
public class XmlCrypterTest {

    private static final Logger logger = LoggerFactory.getLogger( XmlCrypterTest.class );

    @Test public void encrypt() throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><customers><customer><ssn>123-45-6789</ssn></customer>"
                        + "<customer><ssn>987-65-4321</ssn></customer></customers>";
        logger.info( "Original XML: {}", xml );

        KeyHolder key = new KeyHolder( Algorithm.AES128 );
        XmlCrypter crypter = new XmlCrypter();
        String encrypted = crypter.encrypt( xml, key, "ssn" );
        logger.info( "Encrypted XML: {}", encrypted );

        String decrypted = crypter.decrypt( encrypted, key, "ssn" );
        logger.info( "Decrypted XML: {}", decrypted );

        assertTrue( xml.equals( decrypted ) );

    }

}