package net.chiappone.util.security.algorithms.hashing;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.exceptions.HashException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Implements the SHA hash algorithm.
 *
 * @author Kurtis Chiappone
 */
public class SHA extends AbstractHashAlgorithm<byte[]> {

    public SHA( Algorithm algorithm ) {

        super( algorithm );

    }

    public byte[] hash( byte[] data ) {

        MessageDigest md = null;

        try {

            md = MessageDigest.getInstance( getAlgorithm().getInstanceName() );

        } catch ( NoSuchAlgorithmException e ) {

            throw new HashException( e );

        }

        return md.digest( data );

    }

}
