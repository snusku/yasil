package io.getynge.yasil.backend.src;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by spark on 1/29/2017.
 */
class SenderReceiverPair<T> extends ASenderReceiverPair<T>{
    Queue<T> buffer = new SynchronousQueue<T>(true);

    void onSend(T arg){
        buffer.add(arg);
    }

    T onReceive(){
        return buffer.element();
    }

    boolean onHasNext(){
        return !buffer.isEmpty();
    }

    SenderReceiverPair(ISender<T> a, IReceiver<T> b){
        this.receiver = b;
        this.sender = a;
    }
}
