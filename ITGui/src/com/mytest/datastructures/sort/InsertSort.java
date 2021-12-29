package com.mytest.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : zhanghj
 */
public class InsertSort {
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[180000];
        for (int i = 0; i < 180000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
//        System.out.println(Arrays.toString(arr));
        Date d1 = new Date();
        System.out.println(d1);
        SimpleDateFormat sp1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1s = sp1.format(d1);
        System.out.println("排序前的时间是    " +d1s);
        insertSort2(arr);

        Date d2 = new Date();
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d2s = sp2.format(d2);
        System.out.println("排序后的时间是    " +d2s);
//        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j > 0; j--) {
                if(arr[j]<arr[j-1]){
                    arr[j]=arr[j]^arr[j-1];
                    arr[j-1]=arr[j]^arr[j-1];
                    arr[j]=arr[j]^arr[j-1];
                }else break;
            }
        }
    }
    //移位法
    public static void insertSort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            int temp = arr[i];
            if(temp < arr[index-1]){
                while(index-1 >= 0 && temp <arr[index -1]){
                    arr[index] = arr[index-1];
                    index -= 1;
                }
                arr[index] = temp;
            }
        }
    }
}
