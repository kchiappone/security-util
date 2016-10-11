package net.chiappone.util.security.algorithms.encryption;

/**
 * Interface which all encryption algorithms must implement.
 */
public interface EncryptionAlgorithm<E> {

    /**
     * @param encrypted
     * @param key
     * @return
     */
    public E decrypt( E encrypted, byte[] key );

    /**
     * @param data
     * @param key
     * @return
     */
    public E encrypt( E data, byte[] key );

}
