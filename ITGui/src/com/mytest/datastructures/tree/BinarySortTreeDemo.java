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

    /**
     * 删除结点的思路
     * 1.删除结点为叶子结点时：直接删除
     * 2.删除结点为非叶子结点时：判断左子树最大值所在位置
     * 2.1 左子树最大值所在位置为叶子结点时：a.叶子结点父结点原对应叶子的指向设置null
     *                                 b.使得删除结点的父结点指向叶子结点
     *                                 c.叶子结点左右指向指向原删除结点左右指向
     * 2.2 左子树最大值所在位置为非叶子结点时：a.判断其左子结点是否为空
     *                                  b.左结点为空删除结点父节点指向删除结点左子结点即可
     *                                  c.左子树最大值左结点不为空则用左子树最小值指向需要删除结点
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
                //1. 删除结点为叶子结点时
                if (targetNode.left == null && targetNode.right == null){
                    //找到该结点的parent结点，直接置空
                    Node parentNode = root.searchParent(value);
                    if (parentNode == null){
                        targetNode = null;
                    }else{
                        if(parentNode.left.value == targetNode.value){
                            parentNode.left = null;
                        }else{
                            parentNode.right = null;
                        }
                    }
                }else{
                    Node lfm = targetNode.searchLeftMax();
                    if(lfm != null){
                        //找到左子树最大值，判断其是否为叶子结点
                        //如果是非叶子结点又需要判断其左结点是否存在值
                        if(lfm.left != null || lfm.right != null){

                        }
                    }else{//此时找右子树最小值

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
    public Node searchLeftMax(){
        Node tl = this.left;
        while(tl.right != null){
            tl = tl.right;
        }
        return tl;
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
