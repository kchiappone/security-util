package net.chiappone.util.security.algorithms;

/**
 * Enum which defines the types of algorithms used for encryption and hashing.
 *
 * @author Kurtis Chiappone
 */
public enum Algorithm {

    AES128( "AES-128", "AES", 128 ), AES192( "AES-192", "AES", 192 ), AES256( "AES-256", "AES", 256 ), DESEDE( "DESede",
                    "DESede", -1 ), MD5( "MD5", "MD5", -1 ), SHA1( "SHA-1", "SHA-1", 160 ), SHA256( "SHA-256",
                    "SHA-256", 256 ), SHA384( "SHA-384", "SHA-384", 384 ), SHA512( "SHA-512", "SHA-512", 512 );

    private String value = null;
    private String instanceName = null;
    private int bits = 0;

    Algorithm( String value, String instanceName, int bits ) {

        this.value = value;
        this.instanceName = instanceName;
        this.bits = 0;

    }

    public String getValue() {

        return value;

    }

    public String getInstanceName() {

        return instanceName;

    }

    public int getBits() {

        return bits;

    }

}
