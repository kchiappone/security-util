package net.chiappone.util.security.maskers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 * @date 10/11/2016
 */
public class PasswordMaskerTest {

    private static final Logger logger = LoggerFactory.getLogger( PasswordMaskerTest.class );

    @Test public void mask() throws Exception {

        String password = "superSecurePassword";
        String masked = new PasswordMasker().mask( password );
        logger.info( "Password: {}, Masked: {}", password, masked );
        assertFalse( password.equals( masked ) );

    }

}