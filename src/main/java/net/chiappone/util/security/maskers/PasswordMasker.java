package net.chiappone.util.security.maskers;

/**
 * Masks the entire password with the default mask char.
 */
public class PasswordMasker implements Masker<String> {

    /**
     * @param data
     * @return
     */
    public String mask( String data ) {

        return new StringMasker().mask( data );

    }

}
