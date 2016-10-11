package net.chiappone.util.security.maskers;

/**
 * Masks specific chars in a String.
 *
 * @author Kurtis Chiappone
 */
public class CharMasker implements Masker<String> {

    private char charToMask;
    private char mask = '*';

    public CharMasker() {

    }

    public CharMasker( char charToMask ) {

        this.charToMask = charToMask;

    }

    public CharMasker( char mask, char charToMask ) {

        this.mask = mask;
        this.charToMask = charToMask;

    }

    public final char getCharToMask() {

        return charToMask;
    }

    public final void setCharToMask( char charToMask ) {

        this.charToMask = charToMask;
    }

    public final char getMask() {

        return mask;
    }

    public final void setMask( char mask ) {

        this.mask = mask;
    }

    public String mask( String data ) {

        return data.replaceAll( Character.toString( getCharToMask() ), Character.toString( getMask() ) );

    }

}
