package net.chiappone.util.security.truncaters;

/**
 * Interface which all Truncaters must implement.
 */
public interface Truncater<E> {

    /**
     * @param data
     * @return
     */
    public E truncate( E data );

}
