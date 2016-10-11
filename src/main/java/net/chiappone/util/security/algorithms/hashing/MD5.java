package net.chiappone.util.security.algorithms.hashing;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.exceptions.HashException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Implements the MD5 hash algorithm.
 *
 * @author Kurtis Chiappone
 */
public class MD5 implements HashAlgorithm<byte[]> {

    public byte[] hash( byte[] data ) {

        MessageDigest md = null;

        try {

            md = MessageDigest.getInstance( Algorithm.MD5.getInstanceName() );

        } catch ( NoSuchAlgorithmException e ) {

            throw new HashException( e );

        }

        return md.digest( data );

    }

}
