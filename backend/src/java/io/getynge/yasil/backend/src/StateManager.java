package io.getynge.yasil.backend.src;

import java.util.Stack;

/**
 * Created by spark on 1/29/2017.
 */
class StateManager implements IStateManager<Integer, Long> {
    private Stack<Integer> callStack = new Stack<>();
    private Stack<Long> mainStack = new Stack<>();
    private int location = 0;
    private boolean willJump = false;
    private boolean willCall = false;

    @Override
    public void raiseFlag(IFlag toRaise) {
        willJump = toRaise.getWillJump();
        willCall = toRaise.getWillCall();
        if(toRaise.getWillRestart()){
            callStack = new Stack<>();
            mainStack = new Stack<>();
            location = 0;
        }
    }

    @Override
    public Integer getLoc() {
        if(willJump){
            int tmploc = callStack.pop();
            if(willCall) callStack.push(location);
            location = tmploc;
        }
        return location;
    }

    @Override
    public Long popFromMain() {
        return mainStack.pop();
    }

    @Override
    public void pushToMain(Long toPush) {
        mainStack.push(toPush);
    }

    @Override
    public void pushLoc(Integer toAdd) {
        callStack.push(toAdd);
    }
}
