package net.chiappone.util.security.maskers;

/**
 * Masks a String using the specified <code>start</code> and <code>end</code>
 * index. If the <code>end</code> is unspecified, the String will be masked by
 * <code>start</code> to <code>length() - 1</code>. If the <code>start</code>
 * and <code>end</code> are both unspecified, the entire length of the String
 * will be masked. The default mask is a '<code>*</code>' char. <br><br>
 * Note that String positions start at index zero and end at index
 * <code>length() - 1</code>.
 *
 * @author Kurtis Chiappone
 */
public class StringMasker implements Masker<String> {

    private int endIndex = -1;
    private char mask = '*';
    private int startIndex = -1;

    public StringMasker() {

    }

    public StringMasker( char mask, int startIndex, int endIndex ) {

        this.mask = mask;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public StringMasker( int startIndex ) {

        this.startIndex = startIndex;

    }

    public StringMasker( int startIndex, int endIndex ) {

        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public final int getEndIndex() {

        return endIndex;
    }

    public final void setEndIndex( int endIndex ) {

        this.endIndex = endIndex;
    }

    public final char getMask() {

        return mask;
    }

    public final void setMask( char mask ) {

        this.mask = mask;
    }

    public final int getStartIndex() {

        return startIndex;
    }

    public final void setStartIndex( int startIndex ) {

        this.startIndex = startIndex;
    }

    public String mask( String data ) {

        // User did not specify a start index
        // So start from the beginning

        if ( getStartIndex() == -1 ) {

            setStartIndex( 0 );

        }

        // User did not specify an end index
        // So go the entire length

        if ( getEndIndex() == -1 ) {

            setEndIndex( data.length() - 1 );

        }

        StringBuilder buffer = new StringBuilder();
        int index = 0;

        for ( char c : data.toCharArray() ) {

            if ( index >= getStartIndex() && index <= getEndIndex() ) {

                buffer.append( getMask() );

            } else {

                buffer.append( c );

            }

            index++;

        }

        return buffer.toString();

    }

}
