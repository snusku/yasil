package io.getynge.yasil.backend.src;

/**
 * Represents a single one-way connection
 * This one way connection may be between two classes, over a network, or managed in just about any other way
 * Data is relayed to the connected classes via a sender and receiver.
 * An actual implementation of SenderReceiverPair SHOULD have support for generics
 * Ideally, an implementation of ASenderReceiverPair should have some means of handling backpressure, though this would
 * not be necessary in a single threaded system.
 * @param <T> The datatype being sent between classes
 */
abstract class ASenderReceiverPair<T> {
    ISender<T> sender;
    IReceiver<T> receiver;
}
