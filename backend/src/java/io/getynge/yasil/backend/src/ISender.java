package io.getynge.yasil.backend.src;

/**
 * Represents the sending end of a one-way connection
 * There should NEVER be an instance of an ISender that does not have a corresponding IReceiver
 * This should act as a data sending relay to a connected SenderReceiverPair, and ideally would be an anonymous class
 * created specifically for a particular SenderReceiverPair implementation.
 * That having been said, an extension of ASenderReceiverPair should NEVER implement this interface.
 * An implementation of ISender should have support for generics
 * @param <T> The type of data to be sent to the corresponding receiver
 * @see IReceiver
 * @see ASenderReceiverPair
 */
interface ISender<T> {
    void send(T data);
}
