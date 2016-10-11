package net.chiappone.util.security.maskers;

/**
 * Interface which all Maskers must implement.
 *
 * @author Kurtis Chiappone
 */
public interface Masker<E> {

    public E mask( E data );

}
