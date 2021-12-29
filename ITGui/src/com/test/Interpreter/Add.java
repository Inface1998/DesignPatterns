package com.test.Interpreter;

/**
 * @author : zhanghj
 */
public class Add extends Operator{

    Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int intercept() {
        return left.intercept()+right.intercept();
    }
}
