package com.test.observer;

/**
 * @author : zhanghj
 */
public class PoliceObserver implements Observer{

    @Override
    public void update(String event) {
        System.out.println("police got message: crime is "+event);
    }
}
