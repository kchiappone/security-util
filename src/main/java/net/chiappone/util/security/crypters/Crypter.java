package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.KeyHolder;

/**
 * Interface which all crypters must implement.
 */
public interface Crypter<E> {

    /**
     * @param encrypted
     * @param key
     * @return
     */
    public E decrypt( E encrypted, KeyHolder key );

    /**
     * @param data
     * @param key
     * @return
     */
    public E encrypt( E data, KeyHolder key );

}
