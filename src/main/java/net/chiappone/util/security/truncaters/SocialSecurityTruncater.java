package net.chiappone.util.security.truncaters;

/**
 * Truncates all but the last four chars in a social security number.
 *
 * @author Kurtis Chiappone
 */
public class SocialSecurityTruncater implements Truncater<String> {

    public String truncate( String data ) {

        return new StringTruncater( data.length() - 4 ).truncate( data );

    }

}
