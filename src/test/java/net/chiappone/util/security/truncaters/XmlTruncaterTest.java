package net.chiappone.util.security.truncaters;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 */
public class XmlTruncaterTest {

    private static final Logger logger = LoggerFactory.getLogger( XmlTruncaterTest.class );

    @Test public void truncate() throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><customers><customer><ssn>123-45-6789</ssn></customer>"
                        + "<customer><ssn>987-65-4321</ssn></customer></customers>";
        logger.info( "Original XML: {}", xml );

        String truncated = new XmlTruncater().truncate( new SocialSecurityTruncater(), xml, "ssn" );
        logger.info( "Truncated XML: {}", xml );

        assertFalse( xml.equals( truncated ) );

    }

}