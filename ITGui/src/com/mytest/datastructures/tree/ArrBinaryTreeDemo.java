package com.mytest.datastructures.tree;

/**
 * @author : zhanghj
 */
public class ArrBinaryTreeDemo {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree{
    private int[] arr;//存储数据结点的数组
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int index){
        //如果数组为空，或者arr.length =0
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，无法遍历");
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if((index*2 +1)<arr.length){
            preOrder(2*index +1);
        }
        //向右递归遍历
        if((index*2 +2)<arr.length){
            preOrder(2*index +2);
        }
    }

}
