package io.getynge.yasil.backend.src;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by spark on 1/29/2017.
 */
public class Bridge extends ABridge<String, String>{
    @Override
    public void connect(InputStream in, OutputStream out) throws IOException {
        
    }

    @Override
    public void start(boolean interactive) throws IllegalStateException {

    }
}
