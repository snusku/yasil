package io.getynge.yasil.backend.src;

/**
 * Created by spark on 1/29/2017.
 */
class SenderReceiverPair<T> extends ASenderReceiverPair<T>{



    SenderReceiverPair(ISender<T> a, IReceiver<T> b){
        this.receiver = b;
        this.sender = a;
    }
}
