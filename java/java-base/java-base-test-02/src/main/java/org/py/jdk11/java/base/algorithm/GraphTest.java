package org.py.jdk11.java.base.algorithm;

import java.util.LinkedList;

@SuppressWarnings("All")
public class GraphTest {
    //
    class Graph { // 无向图

        // 广度优先算法
        boolean found = false; // 全局变量或者类成员变量
        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        //        // 广度优先算法
//        public void bfs(int s, int t) {
//            if (s == t) return;
//            // 节点被访问过
//            boolean[] visited = new boolean[v];
//            visited[s]=true;
//            // 访问过得节点，但是相邻节点未访问
//            Queue<Integer> queue = new LinkedList<>();
//            queue.add(s);
//            // 记录搜索路径，类似map
//            int[] prev = new int[v];
//            // 初始化所有节点为-1, 记录访问该节点的前置节点是什么
//            for (int i = 0; i < v; ++i) {
//                prev[i] = -1;
//            }
//            // 遍历为访问过得节点
//            while (queue.size() != 0) {
//                int w = queue.poll();
//                // 弹出一个未访问的节点，遍历该节点的所有相邻节点
//                for (int i = 0; i < adj[w].size(); ++i) {
//                    int q = adj[w].get(i);
//                    //如果节点未访问过，访问过则跳过
//                    if (!visited[q]) {
//                        // 会记录未访问到前所有的
//                        prev[q] = w;
//                        if (q == t) {
//                            print(prev, s, t);
//                            return;
//                        }
//                        visited[q] = true;
//                        queue.add(q);
//                    }
//                }
//            }
//        }
//
        // 那个节点访问到t -> ………… > s节点
        private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
            if (prev[t] != -1 && t != s) {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");
        }

        public void dfs(int s, int t) {
            found = false;
            // 节点是否访问过
            boolean[] visited = new boolean[v];
            // 可以访问的前置节点
            int[] prev = new int[v];
            // 初始化
            for (int i = 0; i < v; ++i) {
                prev[i] = -1;
            }
            recurDfs(s, t, visited, prev);
            print(prev, s, t);
        }

        //
        private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
            if (found == true) return;
            // 标记w被访问过
            visited[w] = true;
            if (w == t) {
                // 找到了停止
                found = true;
                return;
            }
            // 遍历w的相邻节点
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    // 如果没有，找到该节点到目标节点的路径
                    prev[q] = w;
                    recurDfs(q, t, visited, prev);
                }
            }
        }
    }


}
