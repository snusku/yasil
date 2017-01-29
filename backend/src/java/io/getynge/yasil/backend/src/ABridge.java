package io.getynge.yasil.backend.src;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This bridge acts as the communication layer between the frontend and the backend.
 * This should be the only public class in the package, save for any factory classes that solely produce this class.
 * This class will relay source code from the frontend to the parser, and will relay output from the executor to the
 * frontend.  This class should not store any form of program state, and should only store source code until it is
 * sent to the parser.
 * @param <RawSourceType> Type of the source code that is sent to the parser
 * @param <OutputType> Type of the output that is received from the executor
 * @see AParser
 * @see AExecutor
 * @see ASenderReceiverPair
 */
public abstract class ABridge<RawSourceType, OutputType> {
    AParser<?, ?, ?, ?, RawSourceType> parser;
    AExecutor<?, ?, OutputType, ?, ?, ?> executor;
    ISender<RawSourceType> sendSourceToParser;
    IReceiver<OutputType> receiveOutputFromExecutor;

    /**
     * Prepares to send source from the input stream to the parser, and prepares to receive results from
     * the executor.  Note that no instantiation should be done here, that should be done in the constructor.
     * @param in the input stream we are receiving source code from
     * @param out the output stream results should be printed to
     * @throws IOException thrown if either stream is closed or corrupted
     */
    public abstract void connect(InputStream in, OutputStream out) throws IOException;

    /**
     * Starts the process of sending source code and running the program.
     * This also calls start on the executor and the parser.  Neither should do anything until their
     * start methods are called.
     * @param interactive set to true if the code is to be executed as it is read
     * @throws IllegalStateException thrown if there is no connected InputStream or OutputStream (or if either closed)
     */
    public abstract void start(boolean interactive) throws IllegalStateException;
}
