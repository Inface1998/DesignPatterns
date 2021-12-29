package com.test.sequence;

public class Child extends Parent{

    public int childNum=0;
    public static int staticChildNum=0;
    
    {
        System.out.println("Child---执行非静态代码块了1！");
    }
    
    {
        System.out.println("Child---执行非静态代码块了2！");
    }
    
    static{
        System.out.println("Child---执行静态代码块了1！");
    }
    
    static{
        System.out.println("Child---执行静态代码块了2！");
    }

    public Child(){
        super();
        System.out.println("Child---无参构造函数！");
    }
    
    public Child(int childNum){
        super(childNum);
        System.out.println("Child---有参构造函数！");
    }
    
    public void childMethod(int childNum){
        this.childNum=childNum;
        System.out.println("Child--非静态方法/childNum="+childNum);
    }
    
    public static void staticChildMethod(int staticChildNum){
        Child.staticChildNum=staticChildNum;
        System.out.println("Child---静态方法/staticChildNum="+staticChildNum);
    }

    
}
