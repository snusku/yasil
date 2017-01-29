package io.getynge.yasil.backend.src;

/**
 * IStateManager manages all YASIL program state.  IStateManager will have both the call stack and the main stack
 * IStateManager will also determine which line of code should be executed next.
 * This information will be relayed to the AExecutor extension, which will then relay the location to AParser to be sent.
 * IStateManager only has logic regarding program state, and should not itself execute any instructions.
 * @param <LocationType> The type of data to be stored in the call stack
 * @param <ResultType> The type of data to be stored in the main stack
 * @see AExecutor
 */
interface IStateManager<LocationType, ResultType> {

    /**
     * Used to raise one or many flags, built through an implementation of IFlag
     * @param toRaise a series of one or more flags, in a single class
     * @see IFlag
     */
    void raiseFlag(IFlag toRaise);

    /**
     * Will either get the location of the next command OR pop a location off the top of the call stack, depending
     * on which flags were raised.
     * This may also have the side effect of pushing the current location onto the call stack, if the willCall flag was
     * raised.
     * Note that this will not pop a location off the top of the callstack unless willJump has been raised
     * willCall DOES NOT INITIATE A JUMP, ONLY LOCATION CACHING
     * @return the next location to be executed by the AExecutor instance
     */
    LocationType getLoc();

    ResultType popFromMain();

    void pushToMain(ResultType toPush);

    void pushLoc(LocationType toAdd);
}
