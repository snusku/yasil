package io.getynge.yasil.backend.src;

/**
 *
 * @param <T> The type of data to be sent to the corresponding receiver
 */
interface ISender<T> {
    void send(T data);
}
