package com.test.visitors.org;

/**
 * @author : zhanghj
 */
public class Aurora implements IVisitor{
    @Override
    public void chooseLobster(String lobster) {
        System.out.println("Aurora gets a"+ lobster);
    }

    @Override
    public void chooseWatermelon(String watermelon) {
        System.out.println("Aurora gets a"+ watermelon);
    }

    @Override
    public void chooseSteak(String steak) {
        System.out.println("Aurora doesn't like "+ steak);
    }

    @Override
    public void chooseBanana(String banana) {
        System.out.println("Aurora doesn't like "+ banana);
    }
}
