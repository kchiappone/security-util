package net.chiappone.util.security.truncaters;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 * @date 10/11/2016
 */
public class SocialSecurityTruncaterTest {

    private static final Logger logger = LoggerFactory.getLogger( SocialSecurityTruncaterTest.class );

    @Test public void truncate() throws Exception {

        String creditCard = "123-45-6789";
        String truncated = new SocialSecurityTruncater().truncate( creditCard );
        logger.info( "SSN: {}, Truncated: {}", creditCard, truncated );
        assertFalse( creditCard.equals( truncated ) );

    }

}