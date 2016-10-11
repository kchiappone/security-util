package net.chiappone.util.security.maskers;

/**
 * Interface which all Maskers must implement.
 */
public interface Masker<E> {

    /**
     * @param data
     * @return
     */
    public E mask( E data );

}
