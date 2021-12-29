package com.test.Interpreter;

import java.util.Stack;

/**
 * @author : zhanghj
 */
public class Calculator {
    int calculate(String expression){
        Stack<Expression> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char word = expression.charAt(i);
            switch (word){
                case '加':
                    stack.push(new Add(stack.pop(),new Number(expression.charAt(++i))));
                    break;
                case '减':
                    stack.push(new Sub(stack.pop(), new Number(expression.charAt(++i))));
                    break;
                default:
                    stack.push(new Number(word));
                    break;
            }
        }
        return stack.pop().intercept();
    }
}
