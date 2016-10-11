package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.algorithms.KeyHolder;
import net.chiappone.util.security.algorithms.encryption.EncryptionAlgorithm;
import net.chiappone.util.security.exceptions.AlgorithmException;

import java.util.List;

/**
 * Abstract class which implements the {@link Crypter} interface. All crypters
 * should extend this class in order to take advantage of easier algorithm
 * support checks.
 */
public abstract class AbstractCrypter<E> implements Crypter<E> {

    /**
     * @param encrypted
     * @param key
     * @return
     */
    public E decrypt( E encrypted, KeyHolder key ) {

        if ( !isAlgorithmSupported( key.getAlgorithm() ) ) {

            throw new AlgorithmException(
                            AlgorithmException.getMessageFor( key.getAlgorithm(), getSupportedAlgorithms() ) );

        }

        EncryptionAlgorithm<E> crypter = getAlgorithmInstance( key.getAlgorithm() );

        if ( crypter != null ) {

            return crypter.decrypt( encrypted, key.getKeyBytes() );

        }

        return null;

    }

    /**
     * @param data
     * @param key
     * @return
     */
    public E encrypt( E data, KeyHolder key ) {

        if ( !isAlgorithmSupported( key.getAlgorithm() ) ) {

            throw new AlgorithmException(
                            AlgorithmException.getMessageFor( key.getAlgorithm(), getSupportedAlgorithms() ) );

        }

        EncryptionAlgorithm<E> crypter = getAlgorithmInstance( key.getAlgorithm() );

        if ( crypter != null ) {

            return crypter.encrypt( data, key.getKeyBytes() );

        }

        return null;

    }

    /**
     * @param algorithm
     * @return
     */
    public abstract EncryptionAlgorithm<E> getAlgorithmInstance( Algorithm algorithm );

    /**
     * @return
     */
    public abstract List<Algorithm> getSupportedAlgorithms();

    /**
     * @param algorithm
     * @return
     */
    public final boolean isAlgorithmSupported( Algorithm algorithm ) {

        return getSupportedAlgorithms().contains( algorithm );

    }

}
