package com.test.reponsibility.master;

/**
 * @author : zhanghj
 */
public abstract class Programmer {
    protected Programmer next;

    void setNext(Programmer next) {
        this.next = next;
    }
    abstract void handle(Bug bug);
}
