package net.chiappone.util.security.maskers;

/**
 * Masks the entire password with the default mask char.
 *
 * @author Kurtis Chiappone
 */
public class PasswordMasker implements Masker<String> {

    public String mask( String data ) {

        return new StringMasker().mask( data );

    }

}
