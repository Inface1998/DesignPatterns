package com.mytest.datastructures.graph.dfs;

import com.mytest.datastructures.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : zhanghj
 * 1) 访问初始结点v，并标记结点v已经访问
 * 2) 查找结点v的第一个邻结点w
 * 3) 若w存在，则继续执行4，如果w不存在，则回到第一步，将从v的下一个结点继续
 * 4) 若w未被访问，则对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）
 * 5) 查找结点v的w邻接结点的下一个邻接结点，转到步骤3
 */
public class DepthSearch {
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
    //得到第一个邻接点的下标w

    /**
     * 如果存在返回下标，如果不存在返回-1
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2){
        for (int i = v2 + 1; i < vertexList.size() ; i++) {
            if(edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    private void dfs(boolean[] isVisited, int i){
        //首先我们访问该结点,输出
        System.out.println(getValueByIndex(i)+"->");
        //将结点设置为已访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while(w != -1){
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }
    //重载dfs
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        //遍历所有结点,进行dfs回溯
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
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
}
