package com.test.reponsibility.rookie;

/**
 * @author : zhanghj
 */
public class Programmer {
    public String type;
    public  Programmer(String type){
        this.type =type;
    }
    public void solve(Bug bug){
        System.out.println(type.concat("程序员解决了一个难度为").concat(String.valueOf(bug.value)).concat("的bug"));
    }
}

