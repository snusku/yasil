package io.getynge.yasil.backend.src;

/**
 * This class manages the storage of source code to be run by the executor, this will also handle the translation of
 * source code to a format suitable for the executor, if deemed necessary.
 * This class will receive source code from the bridge, in realtime if interactive or all at once if not.
 * If the program is not in interactive mode, this class should be the only one on the thread storing any source code
 * @param <SourceType> The type of source code, should match the type received by AExecutor
 * @param <IDType> The type of IDs, should match the type received by AExecutor
 * @param <LocationType> The type of locations, should match the type sent by AExecutor
 * @param <NameType> The type of names, should match the type sent by AExecutor
 * @param <RawSourceType> The type of the source sent by ABridge, may match SourceType (but doesn't have to)
 * @see AExecutor
 * @see ASenderReceiverPair
 */
abstract class AParser<SourceType, IDType, LocationType, NameType, RawSourceType>{
    ISender<SourceType> sendSourceToExecutor;
    ISender<IDType> sendIDToExecutor;
    IReceiver<LocationType> getLocationFromExecutor;
    IReceiver<NameType> getNameFromExecutor;
    IReceiver<RawSourceType> getSourceFromBridge;

    abstract void start(boolean interactive);
    abstract void stop();
}
