package net.chiappone.util.security.truncaters;

/**
 * Truncates a String using the specified <code>start</code> and
 * <code>end</code> index. This class uses {@link String#substring(int)} and
 * {@link String#substring(int, int)}. <br><br>
 * Note that String positions start at index zero and end at index
 * <code>length() - 1</code>.
 *
 * @author Kurtis Chiappone
 */
public class StringTruncater implements Truncater<String> {

    private int endIndex = -1;
    private int startIndex = -1;

    public StringTruncater() {

    }

    public StringTruncater( int startIndex ) {

        this.startIndex = startIndex;

    }

    public StringTruncater( int startIndex, int endIndex ) {

        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }

    public final int getEndIndex() {

        return endIndex;
    }

    public final void setEndIndex( int index ) {

        this.endIndex = index;
    }

    public final int getStartIndex() {

        return startIndex;
    }

    public final void setStartIndex( int index ) {

        this.startIndex = index;
    }

    public final int getTruncateLength() {

        return endIndex;
    }

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
