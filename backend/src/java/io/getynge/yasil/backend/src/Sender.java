package io.getynge.yasil.backend.src;

import java.util.function.Consumer;

/**
 * Created by spark on 1/29/2017.
 */
class Sender<T> implements ISender<T> {
    private Consumer<T> relay;

    @Override
    public void send(T data) {
        relay.accept(data);
    }

    public Sender(Consumer<T> r){
        relay = r;
    }
}
