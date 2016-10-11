package net.chiappone.util.security.maskers;

/**
 * Masks digit chars within a String as determined by
 * {@link Character#isDigit(char)}.
 */
public class StringDigitMasker extends StringMasker {

    /**
     * @param mask
     * @param startIndex
     * @param endIndex
     */
    public StringDigitMasker( char mask, int startIndex, int endIndex ) {

        super( mask, startIndex, endIndex );

    }

    /**
     * @param startIndex
     */
    public StringDigitMasker( int startIndex ) {

        super( startIndex );

    }

    /**
     * @param startIndex
     * @param endIndex
     */
    public StringDigitMasker( int startIndex, int endIndex ) {

        super( startIndex, endIndex );

    }

    /**
     * @param data
     * @return
     */
    @Override public String mask( String data ) {

        // User did not specify an end index
        // So let's go to the end of the data

        if ( getEndIndex() == -1 ) {

            setEndIndex( data.length() );

        }

        StringBuilder buffer = new StringBuilder();
        int index = 0;

        for ( char c : data.toCharArray() ) {

            if ( index >= getStartIndex() && index <= getEndIndex() ) {

                // Only mask digits

                if ( Character.isDigit( c ) ) {

                    buffer.append( getMask() );

                } else {

                    buffer.append( c );

                }

            } else {

                buffer.append( c );

            }

            index++;

        }

        return buffer.toString();

    }

}
