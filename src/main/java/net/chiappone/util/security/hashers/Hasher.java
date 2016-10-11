package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;

/**
 * Interface which all Hashers must implement.
 */
public interface Hasher<E> {

    /**
     * @param algorithm
     * @param data
     * @return
     */
    public E hash( Algorithm algorithm, E data );

}
