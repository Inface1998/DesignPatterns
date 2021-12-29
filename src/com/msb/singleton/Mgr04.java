package com.msb.singleton;

/**
 * 懒汉式
 * 虽然达到了按需初始化的目的，但带来了线程的不安全问题
 * 同一个类的不同对象的hash码是不同的
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;
    private Mgr04(){}

    public static synchronized Mgr04 getInstance(){
        if (INSTANCE == null){

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();

        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            new Thread(()->
//                System.out.println(Mgr03.getInstance().hashCode());
//            ).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Mgr04.getInstance().hashCode());
                }
            }).start();

        }
    }
}
