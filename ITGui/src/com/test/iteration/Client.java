package com.test.iteration;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client {
    @Test
    public void test(){
        MyList list = new MyList();
        //获取迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
