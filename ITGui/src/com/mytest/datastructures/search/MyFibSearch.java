package com.mytest.datastructures.search;

/**
 * @author : zhanghj
 */
public class MyFibSearch {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = i;
        }
        System.out.println(FibSearch(arr, 0, arr.length - 1, 38));
    }

    /*
    * 思路： 1.首先判断目标值边界，在左或右端点上就直接输出索引，在小于左端点或大于右端点即为越界输出-1
     *      2.分别设置左节点（0.318倍的步长）和右节点（0.682倍的步长）
*           3.循环的边界条件a.
*               -接着判断左节点和右节点是否相等，如果相等证明：要么是右端点和左端点相差为1，要么是相差为3！！！！
*           ps：此判断属于特殊处理是解题的关键点，相差为3时需要移动右节点以保证能判断此区间内的全部值（端点已在第一部判断）
*               相差为1时其实属于判断两个端点，属于重复判断（无伤大雅），如果没有值满足则必然target不存在了
*             循环的边界条件b.
*              -落在左节点和右节点上的幸运儿，此时满足程序结束直接输出
*           4.循环的设置
*             a.如果小值都大于目标值，则所求值在小值左边
*             b.如果大值都小于target,则在大值右边
*             c.不在小值左边也不在大值右边就是在中间了
    *
    * */

    public static int FibSearch(int[] arr, int left, int right, int target) {
        System.out.println("hello");
        if (left < right) {
            //1.首先上来就判断一次目标值边界
            //记录左右值
            int l = left;
            int r = right;
            //左右值满足直接返回
            if (arr[l] == target) {
                return l;
            }
            if (arr[r] == target) {
                return r;
            }
            //左右值超出直接错误
            if(target< arr[l]||target>arr[r]){
                return -1;
            }
            //2.分别设置左节点和右节点
            int pivot1 = (int) ((r - l) * 0.618) + left;
            int pivot2 = (int) ((r - l) * 0.382) + left;
            //3.循环的边界条件
            if(pivot1 == pivot2){
                pivot1++;
                if(arr[pivot1]!= target && arr[pivot2]!= target){
                    return -1;
                }
            }
            if (arr[pivot1] == target) {
                return pivot1;
            }
            if (arr[pivot2] == target) {
                return pivot2;
            }
            //4.循环的设置
            //如果小值都大于目标值，则所求值在小值左边
            if (arr[pivot2] > target) {
                return FibSearch(arr, l, pivot2, target);
            } else if (arr[pivot1] < target) {//如果大值都小于target,则在大值右边
                return FibSearch(arr, pivot1, r, target);
            }else {//不在小值左边也不在大值右边就是在中间了
                return FibSearch(arr, pivot2, pivot1, target);
            }
        }else {
            return -1;
        }
    }
}

