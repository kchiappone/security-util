package net.chiappone.util.security.maskers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 * @date 10/11/2016
 */
public class XmlMaskerTest {

    private static final Logger logger = LoggerFactory.getLogger( XmlMaskerTest.class );

    @Test public void mask() throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><customers><customer><ssn>123-45-6789</ssn></customer>"
                        + "<customer><ssn>987-65-4321</ssn></customer></customers>";
        logger.info( "Original XML: {}", xml );

        String masked = new XmlMasker().mask( new SocialSecurityMasker(), xml, "ssn" );
        logger.info( "Masked XML: {}", masked );

        assertFalse( xml.equals( masked ) );

    }

}