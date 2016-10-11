package net.chiappone.util.security.maskers;

/**
 * Masks specific chars in a String.
 */
public class CharMasker implements Masker<String> {

    private char charToMask;
    private char mask = '*';

    public CharMasker() {

    }

    /**
     * @param charToMask
     */
    public CharMasker( char charToMask ) {

        this.charToMask = charToMask;

    }

    /**
     * @param mask
     * @param charToMask
     */
    public CharMasker( char mask, char charToMask ) {

        this.mask = mask;
        this.charToMask = charToMask;

    }

    /**
     * @return the charToMask
     */
    public final char getCharToMask() {

        return charToMask;
    }

    /**
     * @param charToMask the charToMask to set
     */
    public final void setCharToMask( char charToMask ) {

        this.charToMask = charToMask;
    }

    /**
     * @return the mask
     */
    public final char getMask() {

        return mask;
    }

    /**
     * @param mask the mask to set
     */
    public final void setMask( char mask ) {

        this.mask = mask;
    }

    /**
     * @param data
     * @return
     */
    public String mask( String data ) {

        return data.replaceAll( Character.toString( getCharToMask() ), Character.toString( getMask() ) );

    }

}
