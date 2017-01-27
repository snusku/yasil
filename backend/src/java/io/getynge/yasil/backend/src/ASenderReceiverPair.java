package io.getynge.yasil.backend.src;

/**
 * Created by spark on 1/26/2017.
 */
abstract class ASenderReceiverPair<T, U> {
    ISender<T> sender;
    IReceiver<U> receiver;
}
