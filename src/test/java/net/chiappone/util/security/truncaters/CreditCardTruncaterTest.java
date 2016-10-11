package net.chiappone.util.security.truncaters;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 * @date 10/11/2016
 */
public class CreditCardTruncaterTest {

    private static final Logger logger = LoggerFactory.getLogger( CreditCardTruncaterTest.class );

    @Test public void truncate() throws Exception {

        String creditCard = "1234-5678-9012-3456-7890";
        String truncated = new CreditCardTruncater().truncate( creditCard );
        logger.info( "Credit Card: {}, Truncated: {}", creditCard, truncated );
        assertFalse( creditCard.equals( truncated ) );

    }

}