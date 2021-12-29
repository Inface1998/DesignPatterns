package com.mytest.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : zhanghj
 */
public class BubbleSort {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[80];
        for (int i = 0; i < 80; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date d1 = new Date();
        System.out.println(d1);
        SimpleDateFormat sp1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1s = sp1.format(d1);
        System.out.println("排序前的时间是    " +d1s);
        bubbleSort(arr);

        Date d2 = new Date();
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d2s = sp2.format(d2);
        System.out.println("排序后的时间是    " +d2s);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j+1]^arr[j];
                    arr[j+1] = arr[j+1]^arr[j];
                    arr[j] = arr[j+1]^arr[j];
                }
            }
        }
    }
}
