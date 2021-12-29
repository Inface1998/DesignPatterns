package com.mytest.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : zhanghj
 */
public class MergeSort {
    public static void main(String[] args) {
        //创建数组
//        int[] arr1 = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
//        System.out.println(Arrays.toString(arr));
        Date d1 = new Date();
        System.out.println(d1);
        SimpleDateFormat sp1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1s = sp1.format(d1);
        System.out.println("排序前的时间是    " +d1s);
        mergeSorting(arr);

        Date d2 = new Date();
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d2s = sp2.format(d2);
        System.out.println("排序后的时间是    " +d2s);
//        System.out.println(Arrays.toString(arr));
    }
    //先处理合并
    public static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int t = 0; //指向临时数组
        //将左右两边数据填到temp数组
        //有一边处理完时停止
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        //左边有剩余
        while(i <= mid){
            temp[t++] = arr[i++];
        }
        //右边有剩余
        while(j <= right){
            temp[t++] = arr[j++];
        }
        //temp数组拷贝到arr中
        for (int k = 0; k < temp.length; k++) {
            arr[k+left] = temp[k];
        }
    }
    public static void mergeSort(int[] arr,int left,int right){
        int mid = (left+right)/2;
        if(left < right){
           mergeSort(arr,left,mid);
           mergeSort(arr,mid+1,right);
           merge(arr,left,mid,right);
        }
    }
    public static void mergeSorting(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }
}
