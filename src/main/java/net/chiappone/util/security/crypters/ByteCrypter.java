package net.chiappone.util.security.crypters;

import net.chiappone.util.security.algorithms.Algorithm;
import net.chiappone.util.security.algorithms.encryption.AES;
import net.chiappone.util.security.algorithms.encryption.DESede;
import net.chiappone.util.security.algorithms.encryption.EncryptionAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Encrypts/decrypts bytes. Currently supported algorithms include:
 * <ol>
 * <li>AES-128</li>
 * <li>AES-192</li>
 * <li>AES-256</li>
 * <li>DESede</li>
 * </ol>
 *
 * @author Kurtis Chiappone
 */
public class ByteCrypter extends AbstractCrypter<byte[]> {

    private List<Algorithm> algorithms = null;

    @Override public EncryptionAlgorithm<byte[]> getAlgorithmInstance( Algorithm algorithm ) {

        switch ( algorithm ) {

            case AES128:
                return new AES( Algorithm.AES128 );
            case AES192:
                return new AES( Algorithm.AES192 );
            case AES256:
                return new AES( Algorithm.AES256 );
            case DESEDE:
                return new DESede();
            default:
                break;

        }

        return null;

    }

    @Override public List<Algorithm> getSupportedAlgorithms() {

        if ( algorithms == null ) {

            algorithms = new ArrayList<Algorithm>();
            algorithms.add( Algorithm.AES128 );
            algorithms.add( Algorithm.AES192 );
            algorithms.add( Algorithm.AES256 );
            algorithms.add( Algorithm.DESEDE );

        }

        return algorithms;

    }

}
