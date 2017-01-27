package io.getynge.yasil.backend.src;

/**
 *
 * @param <T>
 * @param <U>
 * @param <W>
 * @param <V>
 */
abstract class AParser<T, U, W, V> {
    ISender<T> sendSourceToExecutor;
    ISender<U> sendIDToExecutor;
    IReceiver<W> getLocationFromExecutor;
    IReceiver<V> getNameFromExecutor;

    public abstract void start();
}
