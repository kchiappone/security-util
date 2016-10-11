package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.algorithms.hashing.HashAlgorithm;
import net.chiappone.util.security.exceptions.AlgorithmException;

import java.util.List;

/**
 * Abstract class which implements the {@link Hasher} interface. All hashers
 * should extend this class in order to take advantage of easier algorithm
 * support checks.
 *
 * @author Kurtis Chiappone
 */
public abstract class AbstractHasher<E> implements Hasher<E> {

    public E hash( Algorithm algorithm, E data ) {

        if ( !isAlgorithmSupported( algorithm ) ) {

            throw new AlgorithmException( AlgorithmException.getMessageFor( algorithm, getSupportedAlgorithms() ) );

        }

        HashAlgorithm<E> hasher = getAlgorithmInstance( algorithm );

        if ( hasher != null ) {

            return hasher.hash( data );

        }

        return null;

    }

    public abstract HashAlgorithm<E> getAlgorithmInstance( Algorithm algorithm );

    public abstract List<Algorithm> getSupportedAlgorithms();

    public final boolean isAlgorithmSupported( Algorithm algorithm ) {

        return getSupportedAlgorithms().contains( algorithm );

    }

}
