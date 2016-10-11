package net.chiappone.util.security.algorithms.hashing;

import net.chiappone.util.security.algorithms.Algorithm;

/**
 * Abstract class which implements {@link HashAlgorithm}. All algorithms that
 * have separate sub-algorithms (e.g. SHA can be SHA-1, SHA-256, SHA-384,
 * SHA-512) should extend this class rather than directly implement
 * {@link HashAlgorithm}.
 *
 * @author Kurtis Chiappone
 */
public abstract class AbstractHashAlgorithm<E> implements HashAlgorithm<E> {

    private Algorithm algorithm = null;

    public AbstractHashAlgorithm( Algorithm algorithm ) {

        this.algorithm = algorithm;

    }

    public Algorithm getAlgorithm() {

        return algorithm;

    }

}
