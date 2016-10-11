package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;

/**
 * @author Kurtis Chiappone
 */
public class StringHasherTest {

    private static final String data = "1234-5678-9012-3456-7890";
    private static final Logger logger = LoggerFactory.getLogger( StringHasherTest.class );

    @Test public void hashMD5() throws Exception {

        String hashed = new StringHasher().hash( Algorithm.MD5, data );
        logger.info( "Original: {}, MD5 Hashed: {}", data, hashed );
        assertFalse( data.equals( hashed ) );

    }

    @Test public void hashSHA1() throws Exception {

        String hashed = new StringHasher().hash( Algorithm.SHA1, data );
        logger.info( "Original: {}, SHA-1 Hashed: {}", data, hashed );
        assertFalse( data.equals( hashed ) );

    }

    @Test public void hashSHA256() throws Exception {

        String hashed = new StringHasher().hash( Algorithm.SHA256, data );
        logger.info( "Original: {}, SHA-256 Hashed: {}", data, hashed );
        assertFalse( data.equals( hashed ) );

    }

    @Test public void hashSHA384() throws Exception {

        String hashed = new StringHasher().hash( Algorithm.SHA384, data );
        logger.info( "Original: {}, SHA-384 Hashed: {}", data, hashed );
        assertFalse( data.equals( hashed ) );

    }

    @Test public void hashSHA512() throws Exception {

        String hashed = new StringHasher().hash( Algorithm.SHA512, data );
        logger.info( "Original: {}, SHA-512 Hashed: {}", data, hashed );
        assertFalse( data.equals( hashed ) );

    }

}