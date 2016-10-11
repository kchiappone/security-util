package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.algorithms.hashing.HashAlgorithm;
import net.chiappone.util.security.algorithms.hashing.MD5;
import net.chiappone.util.security.algorithms.hashing.SHA;

import java.util.ArrayList;
import java.util.List;

/**
 * Hashes bytes. Currently supported algorithms include:
 * <ol>
 * <li>MD5</li>
 * <li>SHA-1</li>
 * <li>SHA-256</li>
 * <li>SHA-384</li>
 * <li>SHA-512</li>
 * </ol>
 *
 * @author Kurtis Chiappone
 */
public class ByteHasher extends AbstractHasher<byte[]> {

    private List<Algorithm> algorithms = null;

    @Override public HashAlgorithm<byte[]> getAlgorithmInstance( Algorithm algorithm ) {

        switch ( algorithm ) {

            case MD5:
                return new MD5();
            case SHA1:
                return new SHA( Algorithm.SHA1 );
            case SHA256:
                return new SHA( Algorithm.SHA256 );
            case SHA384:
                return new SHA( Algorithm.SHA384 );
            case SHA512:
                return new SHA( Algorithm.SHA512 );
            default:
                break;
        }

        return null;

    }

    @Override public List<Algorithm> getSupportedAlgorithms() {

        if ( algorithms == null ) {

            algorithms = new ArrayList<Algorithm>();
            algorithms.add( Algorithm.MD5 );
            algorithms.add( Algorithm.SHA1 );
            algorithms.add( Algorithm.SHA256 );
            algorithms.add( Algorithm.SHA384 );
            algorithms.add( Algorithm.SHA512 );

        }

        return algorithms;

    }

}
