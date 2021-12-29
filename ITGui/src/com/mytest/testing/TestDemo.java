package com.mytest.testing;

import org.junit.Test;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : zhanghj
 */

public class TestDemo {
    @Test
    public void test01(){
        long startTime=System.currentTimeMillis();
        System.out.println();
        long endTime=System.currentTimeMillis();
    }
    @Test
    public void test02(){
        String day = "Today is Monday";    //原始字符串
        System.out.println("substring(0)结果："+day.substring(0,10));
    }
    @Test
    public void test03(){
        String str = Integer.toBinaryString(1);
        System.out.println(str);
    }
    @Test
    public void test04(){
        Set<String> set = new HashSet<String>();
        set.add("111111");
        set.add("222222");
        System.out.println(set);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\JavaCode\\DesignPatterns\\ITGui\\src\\com\\mytest\\testing\\ReadObject.txt"));
            oos.writeObject(set);
            set.clear();
            System.out.println(set);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\JavaCode\\DesignPatterns\\ITGui\\src\\com\\mytest\\testing\\ReadObject.txt"));
            set = (Set<String>) ois.readObject();
            System.out.println(set);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
