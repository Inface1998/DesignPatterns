package com.mytest.testing;

import org.junit.Test;

import java.util.Random;

/**
 * @Auther: zhaoss
 * @Date: 2022/1/1 - 01 - 01 - 22:25
 */
public class AvlTreeDemo {
    @Test
    public void test() {
        AVLTree avlTree = new AVLTree();
        Random myRandom = new Random();
        int[] uniqueArr = new int[116];
        for(int i=0; i < 116; i++) {
            int randomNum = myRandom.nextInt(440) + 1;
            while(existed(randomNum, uniqueArr, i)){
                randomNum = myRandom.nextInt(440) + 1;
            }
            uniqueArr[i] = randomNum;
        }
        for(int i=0; i < uniqueArr.length; i++) {
            avlTree.add(new Node(uniqueArr[i]));
        }
        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot().value);//8
        avlTree.infixOrder();
    }
    public static boolean existed(int num, int[] luckNums, int index) {
        for(int i=0; i<index; i++) {
            if(num == luckNums[i]) {
                return true;
            }
            //这个地方还可以增加一些处理，用来筛选不想要参加抽座位的同学学号
        }
        return false;
    }
}

class AVLTree {
    private Node root;

    //定义getRoot方法
    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("can not iteration");
        }
    }

    /**
     * 删除结点的思路
     * 1.判断是不是叶子结点，如果是则直接删除即可
     * 2.判断是不是根结点，如果是，寻找左子树最大值替换，否则直接root = root.right
     * 3.此时则为非叶子结点的非根结点，判断左子树最大值（没有直接置换成target.right），记录最大值结点父节点右指向指向最大值左结点，
     * 置换target的parent结点指向为target的左子树最大值
     * 置换该值的左右结点为target左右结点
     */
    public void delNode(int value) {
        Node targetNode = root.search(value);
        //判断删除结点是否存在，不存在直接return
        if (targetNode == null) {
            return;
        } else {
            //第一种情况：判断是不是叶子结点，如果是则直接删除即可
            //1. 删除结点为叶子结点时
            Node parentNode = root.searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                //找到该结点的parent结点，直接置空
                if (parentNode == null) {
                    root = targetNode;
                } else {
                    if (parentNode.left.value == targetNode.value) {
                        parentNode.left = null;
                    } else {
                        parentNode.right = null;
                    }
                }
            } else if (targetNode == root) {//第二种情况：判断是不是根结点，如果是，寻找左子树最大值替换，否则直接root = root.right
                Node lfm = root.left.searchMax();
                if (lfm == null) {
                    root = root.right;
                } else {
                    Node lfmParent = root.searchParent(lfm.value);
                    lfmParent.right = lfm.left;
                    lfm.left = parentNode.left;
                    lfm.right = parentNode.right;
                }
            } else {//第三种情况：此时则为非叶子结点的非根结点
                // 如果target是parent的左子结点
                if (parentNode.left.value == value) {
                    //证明是左子结点，此时需要判断子树的最大值
                    Node max = targetNode.searchMax();
                    if (max.value == value) {
                        parentNode.left = targetNode.left;
                    } else {
                        //找到max结点的父结点
                        Node mParent = targetNode.searchParent(max.value);
                        mParent.right = max.left;
                        max.left = targetNode.left;
                        max.right = targetNode.right;
                        parentNode.left = max;
                    }
                } else {//如果target是parent的右子节点
                    Node min = targetNode.searchMin();
                    if (min.value == value) {
                        parentNode.right = targetNode.right;
                    } else {
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

class Node {
    int value;
    Node left;
    Node right;

    //返回左子树高度
    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }
    public int height(){
        return Math.max(left == null ? 0:left.height(),right == null ? 0: right.height())+1;
    }
    public void leftRotate(){
        /**
         * --左旋转思路：1.新建一个节点赋值为原来根节点值
         *           2.将新节点的左指向原来根节点的左指向
         *          3.将新结点的右指向指向根右结点的左结点
         *          4.将根节点值赋予成根节点右节点
         *          4.将根节点左指向赋成新结点
         *          5.将根节点右指向赋成原来右节点右节点
         */
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        left = newNode;
        right = right.right;
    }
    public void leftRotate1(){
        /**
         * 左旋转思路：1.新建一个节点赋值为原来根节点值
         *           2.将新节点的左指向原来根节点的左指向
         *          3.找到原来右子树的最小值,
         *          将最小结点的左结点指向新节点
         *          4.将根节点值赋予成根节点右节点
         *          5.将根节点右指向赋成原来右节点右节点
         */
        Node newNode = new Node(value);
        newNode.left = left;
        //找到原root结点right子树的最小左结点
        Node minNode = minNode(right);
        minNode.left = newNode;
        //替换新结点数值，将新结点左右指向原root.right左右
        value = right.value;
        left = right.left;
        right = right.right;
    }
    public void rightRotate1(){
        Node newNode = new Node(value);
        newNode.right = right;
        Node maxNode = maxNode(left);
        maxNode.right = newNode;
        value = left.value;
        right = left.right;
        left = left.left;

    }
    public void rightRotate(){
        /**
         * --右旋转思路：1.新建一个节点赋值为原来根节点值
         *           2.将新节点的右指向原来根节点的右指向
         *          3.将新结点的左指向指向根左结点的右结点
         *          4.将根节点值赋予成根节点左节点
         *          5.将根节点右指向赋成新结点
         *          6.将根节点左指向赋成原来左节点左节点
         */
        Node newNode = new Node(value);
        newNode.right= right;
        newNode.left = left.right;
        value = left.value;
        right = newNode;
        left = left.left;

    }
    public Node minNode(Node node){
        Node min = node;
        if (min.left == null){
            return min;
        }else{
            return minNode(min.left);
        }
    }
    public Node maxNode(Node node){
        Node max = node;
        if (max.right == null){
            return max;
        }else{
            return maxNode(max.right);
        }
    }
    public Node(int value) {
        this.value = value;
    }

    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public Node searchMax() {
        Node ts = this;
        while (ts.right != null) {
            ts = ts.right;
        }
        return ts;
    }

    public Node searchMin() {
        Node ts = this;
        while (ts.left != null) {
            ts = ts.left;
        }
        return ts;
    }

    //添加结点的方法
    //递归的形式添加结点，需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {//大于时
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }
        while (leftHeight() - rightHeight() > 1){
            rightRotate1();
        }
        while (rightHeight() - leftHeight() > 1){
            leftRotate1();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
