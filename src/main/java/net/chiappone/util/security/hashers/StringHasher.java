package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;
import org.apache.commons.codec.binary.Hex;

/**
 * Returns a Hex encoded hashed String, using {@link ByteHasher} as a delegate.
 */
public class StringHasher implements Hasher<String> {

    /**
     * @param algorithm
     * @param data
     * @return
     */
    public String hash( Algorithm algorithm, String data ) {

        return new String( Hex.encodeHex( new ByteHasher().hash( algorithm, data.getBytes() ) ) );

    }

}
