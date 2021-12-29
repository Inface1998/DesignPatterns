package com.mytest.datastructures.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : zhanghj
 */
public class HuffmanTree {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else {
            System.out.println("是空树，不能遍历~~");
        }
    }
    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while(nodes.size() > 1){
            //排序 从小到大
            Collections.sort(nodes);
            System.out.println("node = "+ nodes);
            //取出节点权值最小的两颗二叉树
            //(1)取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //(2)取出权值第二小的结点（二叉树）
            Node rightNode = nodes.get(1);
            //(3)构建一颗新的二叉树
            Node parent = new Node(leftNode.value+ rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);
            System.out.println("第一次处理后"+nodes);
        }
        return nodes.get(0);
    }
}
//创建结点类
class Node implements Comparable<Node> {
    int value;//结点权值
    Node left;//指向左结点
    Node right;
    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node.value=" + value ;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
