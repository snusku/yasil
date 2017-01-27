package io.getynge.yasil.backend.src;

/**
 *
 * @param <T> data type of locations, this data type should match the type received by the parser
 * @param <U> data type of function names, this data type should match the type received by the parser
 * @param <V> data type of output, this should match the type received by the bridge
 * @param <W> data type of source code, this should match the type sent by the parser
 * @param <X> data type of IDs, this should match the type sent by the parser
 * @see ASenderReceiverPair
 * @see AParser
 */
abstract class AExecutor<T, U, V, W, X> {
    ISender<T> sendLocationToParser;
    ISender<U> sendNameToParser;
    ISender<V> sendOutputToBridge;
    IReceiver<W> getSourceFromParser;
    IReceiver<X> getIDFromParser;
}
