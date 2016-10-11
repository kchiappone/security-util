package net.chiappone.util.security.hashers;

import net.chiappone.util.security.algorithms.Algorithm;

/**
 * Interface which all Hashers must implement.
 *
 * @author Kurtis Chiappone
 */
public interface Hasher<E> {

    public E hash( Algorithm algorithm, E data );

}
