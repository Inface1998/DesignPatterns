package com.msb.singleton;

/**
 * 饿汉式
 * 类加载到内存后就实例化一个单例，JVM保证线程安全（jvm保证每一个类到内存只有一次加载）
 * 简单实用，推荐使用
 * 唯一缺点：不管用到与否，类加载时就完成的实例化
 * Class.forName("")
 * @author : zhanghj
 */
public class Mgr01 {
    public static final Mgr01 INSTANCE = new Mgr01();
    private Mgr01(){};
    public static Mgr01 getInstance(){return INSTANCE;}
    public void m(){
        System.out.println("m");
    }
    public static void main(String[] args){
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 ==  m2 );
    }
}
