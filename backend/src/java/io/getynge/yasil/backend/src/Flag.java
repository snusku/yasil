package io.getynge.yasil.backend.src;

/**
 * Created by spark on 1/29/2017.
 */
public class Flag implements IFlag {
    private boolean willJump = false;
    private boolean willCall = false;
    private boolean willClose = false;
    private boolean willRestart = false;

    @Override
    public IFlag willJump() {
        willJump = true;
        return this;
    }

    @Override
    public IFlag willCall() {
        willCall = true;
        return this;
    }

    @Override
    public IFlag willClose() {
        willClose = true;
        return this;
    }

    @Override
    public IFlag willRestart() {
        willRestart = true;
        return this;
    }

    @Override
    public boolean getWillJump() {
        return willJump;
    }

    @Override
    public boolean getWillCall() {
        return willCall;
    }

    @Override
    public boolean getWillClose() {
        return willClose;
    }

    @Override
    public boolean getWillRestart() {
        return willRestart;
    }
}
