package com.mytest.datastructures.tree.huffmancode;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author : zhanghj
 */
public class HuffmanCode {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        /*String str = "i like like like java do you like a java";
        byte[] contentBytes = str.getBytes();
        System.out.println(contentBytes.length);
        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是： "+Arrays.toString(huffmanCodesBytes)+"\nlength: "+huffmanCodesBytes.length);
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println("原来的字符串="+new String(sourceBytes));*/
        //测试压缩文件
        String srcFile = "E:\\JavaCode\\DesignPatterns\\ITGui\\src\\com\\mytest\\datastructures\\tree\\huffmancode\\8.2.png";
        String dstFile = "E:\\JavaCode\\DesignPatterns\\ITGui\\src\\com\\mytest\\datastructures\\tree\\huffmancode\\8.2.zip";
        zipFile(srcFile,dstFile);
    }
    @Test
    public void testUnZip(){
        String zipFile = "E:\\JavaCode\\DesignPatterns\\ITGui\\src\\com\\mytest\\datastructures\\tree\\huffmancode\\8.2.zip";
        String dstFile = "E:\\JavaCode\\DesignPatterns\\ITGui\\src\\com\\mytest\\datastructures\\tree\\huffmancode\\2.png";
        unZipFile(zipFile,dstFile);
        System.out.println("successful unzip");
    }
    public static void unZipFile(String zipFile,String dstFile){
        //定义文件的输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        FileOutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            System.out.println(Arrays.toString(huffmanBytes));
            //读取赫夫曼编码表
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            System.out.println(huffmanCodes);
            //解码
            byte[] bytes = decode(huffmanCodes,huffmanBytes);
            //将bytes数组写入到目标文件
            os = new FileOutputStream(dstFile);
            //写入数据到文件
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //编写方法压缩文件
    public static void zipFile(String srcFile, String dstFile){
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建输入流
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            //创建一个byte数组
            byte[] b  = new byte[is.available()];
            //读取文件
            is.read(b);
            //获取到文件对应的赫夫曼编码
            byte[] huf = huffmanZip(b);
            //创建文件的输出流，存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectiveOutPutStream
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huf);
            //这里 以对象流的方式写入赫夫曼编码，把赫夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());;
            }
        }
    }
    //编写压缩数据解码方法
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length -1);
            stringBuilder.append(byteToBitString(!flag,b));
        }
        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码进行调换
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }
        //创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for(int  i = 0; i < stringBuilder.length(); ) {
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while(flag) {
                //1010100010111...
                //递增的取出 key 1
                String key = stringBuilder.substring(i, i+count);//i 不动，让count移动，指定匹配到一个字符
                b = map.get(key);
                if(b == null) {//说明没有匹配到
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到 count
        }
        //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
        //把list 中的数据放入到byte[] 并返回
        byte b[] = new byte[list.size()];
        for(int i = 0;i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }
    //完成数据的解压
    //思路：1.将huffmanCodeBytes[-88,-65,56,-65,....]转成赫夫曼编码对应的二进制字符串
    //     2.二进制字符串转换成"i like like like java ..."
    public static String byteToBitString(boolean flag,byte b){
        int temp = b;
        if(flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length()-8);
        }else{
            return str;
        }
    }
    public static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes 创建赫夫曼树
        Node huffmanTreeRoot = createTree(nodes);
        //生成赫夫曼编码
        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码进行压缩
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
        return huffmanCodeBytes;
    }
    //文件压缩
    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder sb1 = new StringBuilder();
        for (byte aByte : bytes) {
            sb1.append(huffmanCodes.get(aByte));
        }
        System.out.println("测试 stringBuilder~~~=" + sb1.toString());
        //将字符串转为byte数组
        int len = (sb1.length()+7)/8;
        //创建存储压缩后的byte数组
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < sb1.length(); i += 8) {
            String strByte;
            if(i+8 > sb1.length()){//不够8位
                strByte = sb1.substring(i);
                System.out.println(strByte);
            }else {
                strByte = sb1.substring(i,i+8);
            }
            //将strByte转换成一个byte放入by数组中
            by[index++] = (byte)Integer.parseInt(strByte,2);
        }
        return by;
    }
    //生成赫夫曼树对应的编码
    //思路；
    //1.将编码表放入Map<Byte,String>形式
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2.生成时需要拼接路径，定义一个stringBuilder 存储某个叶子结点的路径
    static StringBuilder sb = new StringBuilder();
    private static Map<Byte,String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root.left,"0",sb);
        getCodes(root.right,"1",sb);
        return huffmanCodes;
    }
    private static void getCodes(Node node,String code, StringBuilder sb){
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.left,"0",sb2);
                getCodes(node.right,"1",sb2);
            }else{
                huffmanCodes.put(node.data,sb2.toString());
            }
        }
    }

    /**
     *
     * @param bytes 接受字节数组
     * @return 返回的就是List形式
     */
    private static List<Node> getNodes(byte[] bytes){
        //1.创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();
        //遍历bytes，统计每个byte出现的次数-》map[key,value]
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            }else{
                counts.put(b,count+1);
            }
        }
        //把每个键值对转化成一个Node对象，并加入到nodes集合中
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    private static Node createTree(List<Node> nodes){
        while(nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建二叉树，它的根节点没有data，只有权值
            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //将已经处理的结点从nodes集合中删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树，加入到nodes
            nodes.add(parent);
        }
        //返回结点
        return nodes.get(0);
    }
}

//创建Node,存放数据和权值
class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;
    public Node(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +'}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //update myfile
    //update myfile
}
