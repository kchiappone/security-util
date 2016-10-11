package net.chiappone.util.security.algorithms.hashing;

/**
 * Interface which all Hash algorithms must implement.
 */
public interface HashAlgorithm<E> {

    /**
     * @param data
     * @return
     */
    public E hash( E data );

}
