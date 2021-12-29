package com.msb.singleton;

/**
 * 不仅解决线程同步，还可以防止反序列化
 */
public enum Mgr08 {
    INSTANCE;
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            new Thread(()->
//                System.out.println(Mgr03.getInstance().hashCode());
//            ).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Mgr08.INSTANCE.hashCode());
                }
            }).start();

        }
    }
}
