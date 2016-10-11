package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 */
public class XmlHasherTest {

    private static final Logger logger = LoggerFactory.getLogger( XmlHasherTest.class );

    @Test public void hash() throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><customers><customer><ssn>123-45-6789</ssn></customer>"
                        + "<customer><ssn>987-65-4321</ssn></customer></customers>";
        logger.info( "Original XML: {}", xml );

        String hashed = new XmlHasher().hash( Algorithm.SHA256, xml, "ssn" );
        logger.info( "Hashed XML: {}", hashed );

        assertFalse( xml.equals( hashed ) );

    }

}