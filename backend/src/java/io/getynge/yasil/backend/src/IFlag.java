package io.getynge.yasil.backend.src;

/**
 * A system for representing flags to be raised for the state manager
 * This allows easy management of things like jumping and calling
 * IFlag uses the builder design principle, where IFlag can be configured by using methods that return itself.
 * See the below example:
 * <pre>
 *     {@code
 *     IFlag example = somethingThatCreatesAnIFlag();
 *     iStateManagerInstance.raiseFlag(example.willJump().willCall());
 *     }
 * </pre>
 * In the above example, two flags are raised at the same time, willJump and willCall, which indicates that the
 * stateManager should prepare to cache the current location in source code, and then jump to another location.
 * @see IStateManager
 */
interface IFlag {
    /**
     * Denotes that the IStateManager should prepare for a jump.
     * If this flag is raised, IStateManager should pop a location off the call stack upon calling getLoc();
     * THIS SHOULD NOT EVER RESULT IN THE CURRENT LOCATION BEING STORED, UNLESS WILLCALL WAS ALSO CALLED
     * @return this
     */
    IFlag willJump();

    /**
     * Denotes that the IStateManager should store the current location
     * willCall DOES NOT RESULT IN A JUMP, IF YOU WANT TO CALL A FUNCTION RAISE THIS AND WILLJUMP.
     * @return this
     */
    IFlag willCall();

    /**
     * @return this
     */
    IFlag willClose();

    /**
     * @return this
     */
    IFlag willRestart();

    boolean getWillJump();
    boolean getWillCall();
    boolean getWillClose();
    boolean getWillRestart();
}
