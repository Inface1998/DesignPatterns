package com.test.visitors.improve;

public class Kevin implements IVisitor {

    @Override
    public void chooseFood(Lobster lobster) {
        System.out.println("Kevin doesn't like " + lobster.name());
    }

    @Override
    public void chooseFood(Watermelon watermelon) {
        System.out.println("Kevin doesn't like " + watermelon.name());
    }

    @Override
    public void chooseFood(Steak steak) {
        System.out.println("Kevin gets a " + steak.name());
    }

    @Override
    public void chooseFood(Banana banana) {
        System.out.println("Kevin gets a " + banana.name());
    }
}