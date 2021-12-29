package com.test.statepattern;

/**
 * @author : zhanghj
 */
public class User implements IUser, ISwitchState {
    public State state = State.NORMAL;
    @Override
    public void purchasePlus() {
        state = State.PLUS;
    }

    @Override
    public void expire() {
        state = State.NORMAL;
    }

    @Override
    public void mockInterview() {
        if(state == State.PLUS){
            System.out.println("start mockInterview");
        }else{
            System.out.println("mockInterview belongs to plus");
        }
    }
}
