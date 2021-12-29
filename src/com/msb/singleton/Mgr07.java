package com.msb.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部内时不会加载内部类，只有调用getINSTANCE时才会加载
 */
public class Mgr07 {
    private Mgr07(){
    }

    private static class Mgr07Holder{
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
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
                    System.out.println(Mgr07.getInstance().hashCode());
                }
            }).start();

        }
    }
}
