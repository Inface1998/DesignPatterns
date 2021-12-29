package com.mytest.datastructures.recursion;

/**
 * @author : zhanghj
 */
public class Queue8 {
    int max = 8;
    int[] arr = new int[max];
    static int count = 0;
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
    }
    //放置皇后
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(judge(n)){
                //recursion
                check(n+1);
            }
        }
    }
    //检查皇后的冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] -arr[i])){
                return false;
            }
        }
        return true;
    }
    //将皇后位置全部打印
    private void print(){
        count++;
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
