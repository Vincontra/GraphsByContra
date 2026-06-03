import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortAlgorithmDFS {

    public static void topo(int V, ArrayList<ArrayList<Integer>>adj){
        Stack<Integer>s1=new Stack<>();
        boolean vis[]=new boolean[V];
        for (int i=0;i<V;i++){
            if (!vis[i]){
                dfs(i,adj,s1,vis);
            }
        }
        while (!s1.isEmpty()){
            System.out.print(s1.pop());
        }

    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>>adj,Stack<Integer>s1,boolean vis[]){
         vis[node]=true;
         for (int i:adj.get(node)){
             if (!vis[i]){
                 dfs(i,adj,s1,vis);
             }
         }
         s1.push(node);
    }


}


// this is also coorect below one
//import java.util.*;
//
//class Solution {
//
//    public ArrayList<Integer> topoSort(int V, int[][] edges) {
//
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        for(int i = 0; i < V; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        // Build adjacency list
//        for(int[] edge : edges) {
//            adj.get(edge[0]).add(edge[1]);
//        }
//
//        Stack<Integer> s1 = new Stack<>();
//        boolean vis[] = new boolean[V];
//
//        for(int i = 0; i < V; i++) {
//            if(!vis[i]) {
//                dfs(i, adj, s1, vis);
//            }
//        }
//
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        while(!s1.isEmpty()) {
//            ans.add(s1.pop());
//        }
//
//        return ans;
//    }
//
//    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
//                           Stack<Integer> s1, boolean vis[]) {
//
//        vis[node] = true;
//
//        for(int i : adj.get(node)) {
//            if(!vis[i]) {
//                dfs(i, adj, s1, vis);
//            }
//        }
//
//        s1.push(node);
//    }
//}