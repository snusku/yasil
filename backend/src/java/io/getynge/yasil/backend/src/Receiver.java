package io.getynge.yasil.backend.src;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by spark on 1/29/2017.
 */
class Receiver<T> implements IReceiver<T>{
    BooleanSupplier hasNext;
    Supplier<T> next;

    @Override
    public boolean hasNext() {
        return hasNext.getAsBoolean();
    }

    @Override
    public T next() {
        return next.get();
    }

    Receiver(BooleanSupplier a, Supplier<T> b){

    }
}
