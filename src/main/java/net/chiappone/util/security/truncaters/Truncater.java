package net.chiappone.util.security.truncaters;

/**
 * Interface which all Truncaters must implement.
 *
 * @author Kurtis Chiappone
 */
public interface Truncater<E> {

    public E truncate( E data );

}
