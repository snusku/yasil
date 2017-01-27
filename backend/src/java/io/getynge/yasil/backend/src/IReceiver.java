package io.getynge.yasil.backend.src;

/**
 * Represents the receiving end of a one-way connection
 * There should NEVER be an instance of IReceiver that does not have a corresponding sender
 * This should act as a data receiving relay from a connected SenderReceiverPair, and ideally would be an anonymous class
 * created specifically for a particular SenderReceiverPair implementation.
 * That having been said, an extension of ASenderReceiverPair should NEVER implement this interface.
 * An implementation of IReceiver should have support for generics
 * @param <T> The type to be received from the sender
 * @see ISender
 * @see ASenderReceiverPair
 */
interface IReceiver<T> extends Iterable<T>{}
