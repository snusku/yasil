package io.getynge.yasil.backend.src;

/**
 * A class that handles the execution of source code for the YASIL backend.
 * This class DOES NOT STORE ANY SOURCE CODE
 * This class DOES NOT STORE ANY PROGRAM STATE
 * THIS CLASS ONLY EXECUTES INSTRUCTIONS AND SENDS RESULTS, IT DOES NO STORAGE OR LOCATION MANAGEMENT
 * The location memory, call stack, and main stack are all managed by an accompanying IStateManager
 * The storage of source code, and potential translation is handled by AParser
 * The implementation of AExecutor should not have any support for generics
 * @param <LocationType> data type of locations, this data type should match the type received by the parser
 * @param <NameType> data type of function names, this data type should match the type received by the parser
 * @param <OutputType> data type of output, this should match the type received by the bridge
 * @param <SourceType> data type of source code, this should match the type sent by the parser
 * @param <IDType> data type of IDs, this should match the type sent by the parser
 * @param <ResultType> data type of results (not output), this should match the type sent to IStateManager
 * @see ASenderReceiverPair
 * @see AParser
 * @see IStateManager
 */
abstract class AExecutor<LocationType, NameType, OutputType, SourceType, IDType, ResultType> {
    ISender<LocationType> sendLocationToParser;
    ISender<NameType> sendNameToParser;
    ISender<OutputType> sendOutputToBridge;
    IReceiver<SourceType> getSourceFromParser;
    IReceiver<IDType> getIDFromParser;
    IStateManager<LocationType, ResultType> stateManager;

    abstract void start();
}
