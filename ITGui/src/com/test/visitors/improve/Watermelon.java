package com.test.visitors.improve;

/**
 * @author : zhanghj
 */
public class Watermelon extends Food{
    @Override
    public String name() {
        return "lobster";
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.chooseFood(this);
    }
}
