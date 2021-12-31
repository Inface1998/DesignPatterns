package com.mytest.datastructures.tree;

/**
 * @author : zhanghj
 */
public class BinarySortTreeDemo {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
    }
}
//创建二叉排序树
class BinarySortTree{
    private Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }else{
            System.out.println("can not iteration");
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value = value;
    }
    //添加结点的方法
    //递归的形式添加结点，需要满足二叉排序树的要求
    public void add(Node node){
        if(node == null){
            return;
        }
        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{//大于时
            if(this.right == null){
                this.right = node;
            }else{
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    //
}
