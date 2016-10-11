package net.chiappone.util.security.truncaters;

/**
 * Truncates all but the last four chars in a credit card number.
 *
 * @author Kurtis Chiappone
 */
public class CreditCardTruncater implements Truncater<String> {

    public String truncate( String data ) {

        return new StringTruncater( data.length() - 4 ).truncate( data );

    }

}
