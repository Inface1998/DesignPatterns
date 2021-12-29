package com.test.strategy.org;

/**
 * @author : zhanghj
 */
public class Sort implements ISort {
    private ISort sort;
    Sort(ISort sort){
        this.sort = sort;
    }
    @Override
    public void sort(int[] arr) {
        sort.sort(arr);
    }
    public void setSort(ISort sort){
        this.sort = sort;
    }
}
