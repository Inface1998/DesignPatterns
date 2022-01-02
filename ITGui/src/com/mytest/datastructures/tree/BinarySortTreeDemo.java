package com.mytest.datastructures.tree;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * @author : zhanghj
 */
public class BinarySortTreeDemo {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,0,-1,6,8};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
        binarySortTree.delNode(-1);
        System.out.println("删除后");
        System.out.println("root=" + binarySortTree.getRoot());
        binarySortTree.infixOrder();
    }
}
//创建二叉排序树
class BinarySortTree{
    private Node root;
    public int getRoot() {
        return root.value;
    }
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

    /**
     * 删除结点的思路
     * 1.判断是不是叶子结点，如果是则直接删除即可
     * 2.判断是不是根结点，如果是，寻找左子树最大值替换，否则直接root = root.right
     * 3.此时则为非叶子结点的非根结点，判断左子树最大值（没有直接置换成target.right），记录最大值结点父节点右指向指向最大值左结点，
     *      置换target的parent结点指向为target的左子树最大值
     *      置换该值的左右结点为target左右结点
     */
    public void delNode(int value){
        if (root == null){
            return;
        }else{
            Node targetNode =root.search(value);
            //判断删除结点是否存在，不存在直接return
            if (targetNode == null){
                return;
            }else{
                //第一种情况：判断是不是叶子结点，如果是则直接删除即可
                //1. 删除结点为叶子结点时
                Node parentNode = root.searchParent(value);
                if (targetNode.left == null && targetNode.right == null){
                    //找到该结点的parent结点，直接置空
                    if (parentNode == null){
                        root = targetNode;
                    }else{
                        if(parentNode.left.value == targetNode.value){
                            parentNode.left = null;
                        }else{
                            parentNode.right = null;
                        }
                    }
                }else if(targetNode == root){//第二种情况：判断是不是根结点，如果是，寻找左子树最大值替换，否则直接root = root.right
                    Node lfm = root.left.searchMax();
                    if(lfm == null){
                        root = root.right;
                    }else{
                        Node lfmParent = root.searchParent(lfm.value);
                        lfmParent.right = lfm.left;
                        lfm.left = parentNode.left;
                        lfm.right = parentNode.right;
                    }
                }else{//第三种情况：此时则为非叶子结点的非根结点
                    // 如果target是parent的左子结点
                    if(parentNode.left.value == value){
                        //证明是左子结点，此时需要判断子树的最大值
                        Node max = targetNode.searchMax();
                        if(max.value == value){
                            parentNode.left = targetNode.left;
                        }else {
                            //找到max结点的父结点
                            Node mParent = targetNode.searchParent(max.value);
                            mParent.right = max.left;
                            max.left = targetNode.left;
                            max.right = targetNode.right;
                            parentNode.left = max;
                        }
                    }else{//如果target是parent的右子节点
                        Node min = targetNode.searchMin();
                        if(min.value == value){
                            parentNode.right = targetNode.right;
                        }else{
                            //找到min结点的父结点
                            Node mParent = targetNode.searchParent(min.value);
                            mParent.left = min.right;
                            min.left = targetNode.left;
                            min.right = targetNode.right;
                            parentNode.right = min;
                        }
                    }
                }
            }
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
    public Node search(int value){
        if(value == this.value){
            return this;
        }else if(value < this.value){
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }
    public Node searchParent(int value){
        if((this.left != null && this.left.value == value) ||
        (this.right != null && this.right.value == value)){
            return this;
        }else{
            if(value<this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }
    public Node searchMax(){
        Node ts = this;
        while(ts.right != null){
            ts = ts.right;
        }
        return ts;
    }
    public Node searchMin(){
        Node ts = this;
        while(ts.left != null){
            ts = ts.left;
        }
        return ts;
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
}
