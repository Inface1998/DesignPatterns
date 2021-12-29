package com.test.visitors.improve;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        Restaurant restaurant = new Restaurant();
        IVisitor Aurora = new Aurora();
        IVisitor Kevin = new Kevin();
        restaurant.welcome(Aurora);
        restaurant.welcome(Kevin);
    }
}