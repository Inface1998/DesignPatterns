package com.test.visitors.org;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client {
    @Test
    public void test(){
        Restaurant restaurant = new Restaurant();
        IVisitor Aurora = new Aurora();
        restaurant.welcome(Aurora);
    }
}
