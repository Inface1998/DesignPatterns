package com.mytest.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : zhanghj
 */
public class RadixSort {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
//        int arr[]={53,3,542,748,14,214};
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date d1 = new Date();
        SimpleDateFormat sp1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1s = sp1.format(d1);
        System.out.println("排序前的时间是    " +d1s);
        radixSort(arr);

        Date d2 = new Date();
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d2s = sp2.format(d2);
        System.out.println("排序后的时间是    " +d2s);
    }
    public static void radixSort(int[] arr){
        //找到最大位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength =(max+"").length();
        
        //为了放置数据溢出，只能定义大数（空间来换时间）
        int[][] bucket = new int[10][arr.length];
        //记录桶内元素个数
        int[] p = new int[10];
        for (int x = 0, nn = 1; x < maxLength; x++,nn *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] /nn % 10;
                bucket[digit][p[digit]] = arr[i];
                p[digit]++; //个数加一
            }
            int index = 0;
            for (int n = 0; n < 10; n++) {
                if(p[n] != 0){
                    for (int l =0; l < p[n]; l++) {
                        arr[index++] = bucket[n][l];
                    }
                }
                p[n] = 0;
            }
            //此轮完毕指针place为零

//            System.out.printf("第%d轮"+Arrays.toString(arr),x);
        }
    }
}
