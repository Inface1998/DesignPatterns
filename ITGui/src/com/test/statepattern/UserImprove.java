package com.test.statepattern;

/**
 * @author : zhanghj
 */
public class UserImprove implements IUser,ISwitchState{
    IUser state = new Normal();

    @Override
    public void purchasePlus() {
        state = new Plus();
    }

    @Override
    public void expire() {
        state = new Normal();
    }

    @Override
    public void mockInterview() {
        state.mockInterview();
    }
}
