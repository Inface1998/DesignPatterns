package com.msb.strategy;

import java.util.Arrays;

/**
 * @author : zhanghj
 */
public class Main {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
//        int[] a = {9,2,3,5,7,1,4};
        Cat[] a = {new Cat(1,2),new Cat(5,5), new Cat(1,1)};
//        Dog[] a = {new Dog(3), new Dog(5),new Dog(1)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(a,new CatWeightComparator());
        System.out.println(Arrays.toString(a));
    }
}
