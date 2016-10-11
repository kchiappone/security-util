package net.chiappone.util.security.algorithms.encryption;

import net.chiappone.util.security.algorithms.Algorithm;

/**
 * Abstract class that implements {@link EncryptionAlgorithm}. All encryption
 * algorithm classes should extend this class.
 */
public abstract class AbstractEncryptionAlgorithm<E> implements EncryptionAlgorithm<E> {

    private Algorithm algorithm = null;

    /**
     * @param algorithm
     */
    public AbstractEncryptionAlgorithm( Algorithm algorithm ) {

        this.algorithm = algorithm;

    }

    /**
     * @return the algorithm
     */
    public final Algorithm getAlgorithm() {

        return algorithm;
    }

}
