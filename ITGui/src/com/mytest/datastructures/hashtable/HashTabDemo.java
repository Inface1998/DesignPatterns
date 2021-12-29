package com.mytest.datastructures.hashtable;

import java.util.Scanner;

/**
 * @author : zhanghj
 */
public class HashTabDemo {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 查找雇员");
            System.out.println("exit");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("input your id for search");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case"delete":
                    System.out.println("input your id for delete");
                    id = scanner.nextInt();
                    hashTab.deleteById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        super();
        this.id = id;
        this.name = name;
    }
}
//创建HashTab 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedLists;
    private int size;//表示共有多少条
    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化empLinkedLists
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        //根据员工的id得到该员工应当添加到哪
        int empLinkedListN = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedLists[empLinkedListN].add(emp);
    }
    //遍历所有的链表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }
    //编写一个散列函数
    public int hashFun(int id ){
        return id % size;
    }
    public void findEmpById(int id){
        //使用散列函数确定到哪条链表中查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNo].findEmpById(id);
        if(emp != null){
            System.out.println("在第"+(empLinkedListNo+1)+"条中找到");
        }else{
            System.out.println("not find ");
        }
    }
    public void deleteById(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedLists[empLinkedListNo].deleteEmp(id);
    }
}


//创建一个EmpLinkedList，表示链表
class EmpLinkedList{
    //头指针，执行第一个Emp
    private Emp head;
    //1.添加方法
    public void add(Emp emp){
        if(head == null){//如果等于空就直接添加
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.next == null){//如果不等于空，就移动直到到最后
                break;
            }
            curEmp = curEmp.next;
        }
        //加入要添加的emp
        curEmp.next = emp;
    }
    //2.遍历方法
    public void list(int no){
        if(head == null){
            System.out.println("第"+no+"链表为空");
            return;
        }
        System.out.print("第"+no+"链表为: ");
        Emp curEmp = head;
        while(true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;//后移，遍历
        }
        System.out.println();
    }
    //3. 根据id查找雇员
    //如果找到就返回，没有就是null
    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("链表为空");
        }
        //辅助指针
        Emp p1 = head;
        while(true){
            if(p1.id == id){
                break;
            }
            if(p1.next == null){
                p1 = null;
                break;
            }
            p1 = p1.next;
        }
        return p1;
    }
    //4. 根据id删除雇员
    public void deleteEmp(int id){
        if(head == null){
            System.out.println("无此节点");
        }
        //辅助指针
        Emp p1 = head;
        Emp p2 = head;
        if (head.id == id){
            head = p1.next;
        }else if(p1.next == null){
            System.out.println("无此id");
        }else{
            while(true){
                p1 = p1.next;
                if(p1.id == id){
                    p2.next = p1.next;
                    break;
                }
                p2 = p2.next;
            }
        }

    }
}
