package net.chiappone.util.security.maskers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 */
public class SocialSecurityMaskerTest {

    private static final Logger logger = LoggerFactory.getLogger( SocialSecurityMaskerTest.class );

    @Test public void mask() throws Exception {

        String ssn = "123-45-6789";
        String masked = new SocialSecurityMasker().mask( ssn );
        logger.info( "SSN: {}, Masked: {}", ssn, masked );
        assertFalse( ssn.equals( masked ) );

    }

}