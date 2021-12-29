package com.mytest.datastructures.sort;

/**
 * @author : zhanghj
 */
public class QuickSort {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[18000000];
        for (int i = 0; i < 18000000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
//        System.out.println(Arrays.toString(arr));
        long startTime=System.currentTimeMillis();
        quickSorts(arr);
        long endTime=System.currentTimeMillis();
        System.out.println("排序耗时   " +(endTime-startTime));
//        System.out.println(Arrays.toString(arr));
    }

   public static void quickSort(int[] arr, int left, int right){
        //选择基准数，基数即为第一个坑
       if(left<right){
           int temp = arr[right];
           int l = left;
           int r = right;
           while(l<r){
               //从左向右遍历寻找大数放在右坑
               while( l<r &&arr[l]<temp){
                   l++;
               }
               if(l<r){
                   arr[r] = arr[l];
                   r--;
               }
               //从右往左遍历寻小数放左坑
               while(l<r&&arr[r]>temp){
                   r--;
               }
               if(l<r){
                   arr[l] = arr[r];
                   l++;
               }
           }
           arr[l] = temp;
           //向左递归
           quickSort(arr,left,l-1);
           //向右递归
           quickSort(arr,l+1,right);
        }
   }
   public static void quickSorts(int[] arr){
       quickSort(arr,0, arr.length-1);
   }
}
