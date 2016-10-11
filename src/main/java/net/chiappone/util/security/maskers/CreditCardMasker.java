package net.chiappone.util.security.maskers;

/**
 * Masks all but the last four digits of a credit card number and ignores
 * non-digit chars (e.g. delimiters such as <code>-</code>). The mask is an
 * <code>x</code> char.
 *
 * @author Kurtis Chiappone
 */
public class CreditCardMasker implements Masker<String> {

    public String mask( String data ) {

        StringDigitMasker delegate = new StringDigitMasker( 0, data.length() - 5 );
        delegate.setMask( 'x' );
        return delegate.mask( data );

    }

}
