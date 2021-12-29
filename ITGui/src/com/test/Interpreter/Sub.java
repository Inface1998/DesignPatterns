package com.test.Interpreter;

/**
 * @author : zhanghj
 */
public class Sub extends Operator{

    Sub(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int intercept() {
        return left.intercept()- right.intercept();
    }
}
