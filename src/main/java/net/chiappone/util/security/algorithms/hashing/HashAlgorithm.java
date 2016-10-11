package net.chiappone.util.security.algorithms.hashing;

/**
 * Interface which all Hash algorithms must implement.
 *
 * @author Kurtis Chiappone
 */
public interface HashAlgorithm<E> {

    public E hash( E data );

}
