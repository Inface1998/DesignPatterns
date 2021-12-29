package com.iostream;

import org.junit.Test;

import java.io.File;
/**
 * @author : msb-zhaoss
 */
public class StreamDemo {
    //这是一个main方法，是程序的入口：
     @Test
    public void test01() {
        //将目录封装为File类的对象：
        File f = new File("D:\\a");
        f.mkdirs();
        System.out.println("文件是否可读："+f.canRead());
        System.out.println("文件是否可写："+f.canWrite());
        System.out.println("文件的名字："+f.getName());
        System.out.println("上级目录："+f.getParent());
        System.out.println("是否是一个目录："+f.isDirectory());
        System.out.println("是否是一个文件："+f.isFile());
        System.out.println("是否隐藏："+f.isHidden());
        System.out.println("文件的大小："+f.length());
        System.out.println("是否存在："+f.exists());
        System.out.println("绝对路径："+f.getAbsolutePath());
        System.out.println("相对路径："+f.getPath());
        System.out.println("toString:"+f.toString());
        //跟目录相关的方法：
        File f2 = new File("D:\\a\\b\\c");
        //创建目录：
        //f2.mkdir();//创建单层目录
        //f2.mkdirs();//创建多层目录
        //删除：如果是删除目录的话，只会删除一层，并且前提：这层目录是空的，里面没有内容，如果内容就不会被删除
//        f2.delete();
        //查看：
//        String[] list = f2.list();//文件夹下目录/文件对应的名字的数组
//        for(String s:list){
//            System.out.println(s);
//        }
//        System.out.println("=========================");
//        File[] files = f.listFiles();//作用更加广泛
//        for(File file:files){
//            System.out.println(file.getName()+","+file.getAbsolutePath());
//        }
    }
}
