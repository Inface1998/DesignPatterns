package com.mytest.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : zhanghj
 */
public class Graph {
    private ArrayList<String> vertexList; //储存顶点集合
    private int[][] edges; //储存图对应的邻结矩阵
    private int numOfEdges; //表示边的数目
    //定义给数组boolean[],记录某个结点是否被访问
    private boolean[] isVisited;

    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        int n = 5;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        for (String s : Vertexs) {
            graph.insertVertex(s);
        }
        //添加边
        //A_B A_C B_C B_D B_E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示一把邻接矩阵
        graph.showGraph();
    }

    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    //==========图中常用的方法==========
    //1.返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //2.显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //3.得到边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //4.返回结点i对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //5.返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //添加边

    /**
     * @param v1     表示第一个顶点对应的下标
     * @param v2     表示第二个顶点对应的下标
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
