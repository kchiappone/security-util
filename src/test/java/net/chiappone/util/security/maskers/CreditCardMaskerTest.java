package net.chiappone.util.security.maskers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 */
public class CreditCardMaskerTest {

    private static final Logger logger = LoggerFactory.getLogger( CreditCardMaskerTest.class );

    @Test public void mask() throws Exception {

        String creditCard = "1234-5678-9012-3456-7890";
        String masked = new CreditCardMasker().mask( creditCard );
        logger.info( "Credit Card: {}, Masked: {}", creditCard, masked );
        assertFalse( creditCard.equals( masked ) );

    }

}