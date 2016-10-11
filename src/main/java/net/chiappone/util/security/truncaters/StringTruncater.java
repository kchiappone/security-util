package net.chiappone.util.security.truncaters;

/**
 * Truncates a String using the specified <code>start</code> and
 * <code>end</code> index. This class uses {@link String#substring(int)} and
 * {@link String#substring(int, int)}. <br/>
 * <br />
 * <p>
 * Note that String positions start at index zero and end at index
 * <code>length() - 1</code>.
 */
public class StringTruncater implements Truncater<String> {

    private int endIndex = -1;
    private int startIndex = -1;

    public StringTruncater() {

    }

    /**
     * @param startIndex
     */
    public StringTruncater( int startIndex ) {

        this.startIndex = startIndex;

    }

    /**
     * @param startIndex
     * @param endIndex
     */
    public StringTruncater( int startIndex, int endIndex ) {

        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }

    /**
     * @return the endIndex
     */
    public final int getEndIndex() {

        return endIndex;
    }

    /**
     * @param index the truncateLength to set
     */
    public final void setEndIndex( int index ) {

        this.endIndex = index;
    }

    /**
     * @return the startIndex
     */
    public final int getStartIndex() {

        return startIndex;
    }

    /**
     * @param index the startIndex to set
     */
    public final void setStartIndex( int index ) {

        this.startIndex = index;
    }

    /**
     * @return the truncateLength
     */
    public final int getTruncateLength() {

        return endIndex;
    }

    /**
     * @param data
     * @return
     */
    public String truncate( String data ) {

        String str;

        // User didn't specify an end index

        if ( getEndIndex() == -1 ) {

            str = data.substring( getStartIndex() );

        } else {

            str = data.substring( getStartIndex(), getEndIndex() );

        }

        return str;

    }

}
