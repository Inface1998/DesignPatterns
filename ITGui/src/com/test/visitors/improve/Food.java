package com.test.visitors.improve;

/**
 * @author : zhanghj
 */
public abstract class Food {
    public abstract String name();
    public abstract void accept(IVisitor visitor);
}
