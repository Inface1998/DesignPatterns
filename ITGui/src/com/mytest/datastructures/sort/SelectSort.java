package com.mytest.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : zhanghj
 */
public class SelectSort {
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int)(Math.random()*8000);
        }
        Date d1 = new Date();
        System.out.println(d1);
        SimpleDateFormat sp1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1s = sp1.format(d1);
        System.out.println("排序前的时间是    " +d1s);
        selectSort(arr);

        Date d2 = new Date();
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d2s = sp2.format(d2);
        System.out.println("排序后的时间是    " +d2s);
//        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                    arr[j] = arr[i]^arr[j];
                }
            }
        }
    }


}
