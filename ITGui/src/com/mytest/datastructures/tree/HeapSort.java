package com.mytest.datastructures.tree;

/**
 * @author : zhanghj
 * 思路：利用大顶堆
 *    1.判断非叶子节点
 */
public class HeapSort {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        int[] arr = new int[18000000];
        for (int i = 0; i < 18000000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
//        System.out.println("数组=" + Arrays.toString(arr));
        long startTime=System.currentTimeMillis();
        heapSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println("排序耗时   " +(endTime-startTime));
    }
    public static void heapSort(int arr[]){
        int temp = 0;
        System.out.println("heap sort!!!");
        //1.从下到上锁定大顶
        for (int i = arr.length/2 -1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //2.找到大顶后交换数组首位
        for (int j = arr.length-1; j >0 ; j--) {
            arr[j] = arr[0]^arr[j];
            arr[0] = arr[0]^arr[j];
            arr[j] = arr[0]^arr[j];
            adjustHeap(arr,0,j);
        }
//        System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     *
     * @param arr 待调整数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length    表示待调整长度
     */
    public static void adjustHeap(int arr[], int i, int length){
        int temp = arr[i];
        //判断子树中是否有大于判断结点的结点
        for (int j = i*2 +1; j <length ; j = i*2 +1) {
            if(j+1 < length && arr[j] < arr[j+1] ){
                j++;
            }
            if(arr[j] > temp){
                arr[i] = arr[j];
                i = j;//循环比较
            }else{
                break;
            }
        }
        arr[i] = temp;
    }
}
