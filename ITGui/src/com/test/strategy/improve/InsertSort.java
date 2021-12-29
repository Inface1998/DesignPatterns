package com.test.strategy.improve;



/**
 * @author : zhanghj
 */
public class InsertSort implements ISort {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentNumber = arr[i];
            int j = i -1;
            while(j>=0 && currentNumber < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currentNumber;
        }
    }
}
