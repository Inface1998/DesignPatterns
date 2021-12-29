package com.test.observer;

/**
 * @author : zhanghj
 */
public class CriminalObservable extends Observable{
    public void crime(String event){
        System.out.println("Criminal is "+event);
        notifyObservers(event);
    }
}
