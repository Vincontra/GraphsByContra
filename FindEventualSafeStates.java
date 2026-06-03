import java.util.*;
public class FindEventualSafeStates{
//    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer>ans=new ArrayList<>();
            ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
            for (int i=0;i<graph.length;i++){
                adj.add(new ArrayList<>());
            }
            for (int i=0;i<graph.length;i++){
                int arr[]=graph[i];
                for (int j=0;j<arr.length;j++){
                    adj.get(i).add(graph[i][j]);
                }
            }
            isCycle(graph.length,adj,ans);
            return ans;
        }
        public static void isCycle(int V, ArrayList<ArrayList<Integer>>adj,List<Integer>ans){
            boolean vis[]=new boolean[V];
            boolean samepath[]=new boolean[V];
            HashSet<Integer>hs=new HashSet<>();
            for (int i=0;i<V;i++){
                if (!vis[i]){
                    if (dfs(i,adj,vis,samepath)){
                        for (int j=0;j<samepath.length;j++){
                            if (samepath[j]){
                                hs.add(j);  // those who are part of cycle
                                //l1.add(j);
                            }
                        }
                    }
                }
            }
            // abhi those who have the nodes which ar directed towards any node in that cycle
            // unko bhi we need to add as non safe nodes as they will also have atleast one path which will be ended
            // in cycle
            //safe node means no path should end in cycle
            // or all paths should end at the terminal nodes
            // terminal node means outdegree 0;

            for (int i=0;i< V;i++){
                boolean check=false;
                if (!hs.contains(i)){
                    ArrayList<Integer>curr=adj.get(i);
                    for (int j:curr){
                        if (hs.contains(j)){
                            check=true;
                            break;
                        }
                    }
                    if (!check)
                    {
                        ans.add(i);
                    }
                }
            }
        }
        public static boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,boolean vis[],boolean samepath[]){
            vis[node]=true;
            samepath[node]=true;
            for(int i:adj.get(node)){
                if(!vis[i]){
                    if (dfs(i,adj,vis,samepath)){
                        return true;
                    }
                }
                else if (samepath[i]){
                    return true;
                }
            }
            samepath[node]=false;
            return false;
        }
    //}
}
//class Solution {
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        int V=graph.length;
//        List<Integer>ans=new ArrayList<>();
//        boolean check[]=new boolean[V];
//        boolean vis[]=new boolean[V];
//        boolean samepath[]=new boolean[V];
//
//        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
//        for (int i=0;i<graph.length;i++){
//            adj.add(new ArrayList<>());
//        }
//        for (int i=0;i<graph.length;i++){
//            int arr[]=graph[i];
//            for (int j=0;j<arr.length;j++){
//                adj.get(i).add(graph[i][j]);
//            }
//        }
//
//        for(int i=0;i<V;i++){
//            if(!vis[i]){
//                dfs(i,adj,check,vis,samepath);
//            }
//        }
//        for(int i=0;i<V;i++){
//            if(check[i]){
//                ans.add(i);
//            }
//        }
//        return ans;
//
//    }
//    public static boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,boolean check[],boolean vis[],boolean samepath[]){
//        vis[node]=true;
//        samepath[node]=true;
//        check[node]=false;
//        for(int i:adj.get(node)){
//            if(!vis[i]){
//                if(dfs(i,adj,check,vis,samepath)){
//                    return true;
//                }
//            }
//            else if(samepath[i]){
//                return true;
//            }
//        }
//        samepath[node]=false;
//        check[node]=true;
//        return false;
//    }
//}