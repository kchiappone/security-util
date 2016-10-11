package net.chiappone.util.security.algorithms.encryption;

/**
 * Interface which all encryption algorithms must implement.
 *
 * @author Kurtis Chiappone
 */
public interface EncryptionAlgorithm<E> {

    public E decrypt( E encrypted, byte[] key );

    public E encrypt( E data, byte[] key );

}
