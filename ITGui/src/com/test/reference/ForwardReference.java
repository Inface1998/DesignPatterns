package com.test.reference;

/**
 * @author : zhanghj
 */
public class ForwardReference {
    int method(){
        return n;//此时即为向前引用，声明变量还未出现时就引用了该变量；
    }
    int m = method();
    int n = 1;
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        System.out.println(new ForwardReference().method());//结果为1
        System.out.println(new ForwardReference().m);//结果为0
    }
}
