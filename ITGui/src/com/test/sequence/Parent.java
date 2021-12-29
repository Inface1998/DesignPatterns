package com.test.sequence;

public class Parent {
    public int parentNum=0;
    public static int staticParentNum=0;
    
    {
        System.out.println("Parent---执行非静态代码块了1！");
    }
    
    {
        System.out.println("Parent---执行非静态代码块了2！");
    }
    
    static{
        System.out.println("Parent---执行静态代码块了1！");
    }
    
    static{
        System.out.println("Parent---执行静态代码块了2！");
    }

    public Parent(){
        System.out.println("Parent---无参构造函数！");
    }
    public Parent(int parentNum){
        this.parentNum=parentNum;
        System.out.println("Parent---有参构造函数！");
        
    }

    public void ParentMethod(int parentNum){
        this.parentNum=parentNum;
        System.out.println("Parent---非静态方法/parentNum="+parentNum);
    }
    
    public static void staticParentMethod(int staticParentNum){
        Parent.staticParentNum=staticParentNum;
        System.out.println("Parent---静态方法/staticParentNum="+staticParentNum);
    }
    
}
