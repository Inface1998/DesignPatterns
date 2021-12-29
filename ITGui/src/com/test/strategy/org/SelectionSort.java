package com.test.strategy.org;

/**
 * @author : zhanghj
 */
public class SelectionSort implements ISort{
    @Override
    public void sort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            arr[i] = arr[i]^arr[minIndex];
            arr[minIndex] = arr[i]^arr[minIndex];
            arr[i] = arr[i]^arr[minIndex];
        }
    }
}
