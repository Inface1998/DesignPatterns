package com.mytest.datastructures.sort;

/**
 * @author : zhanghj
 */
public class SellSort {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[18000000];
        for (int i = 0; i < 18000000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
//        System.out.println(Arrays.toString(arr));
        long startTime=System.currentTimeMillis();
        shellSort2(arr);
        long endTime=System.currentTimeMillis();
        System.out.println("排序耗时   " +(endTime-startTime));

    }
    public static void shellSort(int[] arr) {
        //first sort
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j + gap] < arr[j]) {
                        arr[j + gap] = arr[j] ^ arr[j + gap];
                        arr[j] = arr[j] ^ arr[j + gap];
                        arr[j + gap] = arr[j] ^ arr[j + gap];
                    }
                }
            }
        }

    }
    public static void shellSort2(int[] arr){
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                int index = i;
                int temp = arr[index];
                if(temp < arr[index-gap]){
                    while(index-gap >=0 && temp < arr[index-gap]){
                        arr[index] = arr[index-gap];
                        index -= gap;
                    }
                    arr[index] = temp;
                }
            }
        }
    }
}
