package com.test.observer;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client {
    @Test
    public void test(){
        CriminalObservable zhangSan = new CriminalObservable();
        PoliceObserver p1 = new PoliceObserver();
        PoliceObserver p2 = new PoliceObserver();
        PoliceObserver p3 = new PoliceObserver();
        zhangSan.addObserver(p1);
        zhangSan.addObserver(p2);
        zhangSan.addObserver(p3);
        zhangSan.crime("doing bad");
    }
}
