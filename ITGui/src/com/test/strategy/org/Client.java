package com.test.strategy.org;

import org.junit.Test;

import java.util.Arrays;

public class Client {
    @Test
    public void test() {
        int[] arr = new int[]{6, 1, 2, 3, 5, 4};
        Sort sort = new Sort(new BubbleSort());
        // 这里可以选择不同的策略完成排序
        sort.setSort(new InsertSort());
//        sort.setSort(new SelectionSort());
        sort.sort(arr);
        // 输出 [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(arr));
    }
}