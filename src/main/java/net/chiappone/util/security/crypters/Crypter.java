package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.KeyHolder;

/**
 * Interface which all crypters must implement.
 *
 * @author Kurtis Chiappone
 */
public interface Crypter<E> {

    public E decrypt( E encrypted, KeyHolder key );

    public E encrypt( E data, KeyHolder key );

}
