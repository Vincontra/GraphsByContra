import java.util.ArrayList;

public class CycleInGraphUndirectedDFS {

    public boolean Cycle(int V, ArrayList<ArrayList<Integer>>adj){
        boolean vis[]=new boolean[V];
        boolean ans[]=new boolean[1];
        for (int i=0;i<V;i++){
            if (!vis[i]){
                dfs(ans,adj,vis,i,-1);
                if (ans[0]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void dfs(boolean ans[],ArrayList<ArrayList<Integer>>adj,boolean vis[],int src,int par){
        if (ans[0]){
            return;
        }
        vis[src]=true;
        for (int i:adj.get(src)){
            if (i!=par){
                if (vis[i]){
                    ans[0]=true;
                }else{
                    dfs(ans,adj,vis,i,src);
                }
            }
        }
    }
}

//    public boolean Cycle(int V, ArrayList<ArrayList<Integer>> adj) {
//        boolean[] vis = new boolean[V];
//
//        for (int i = 0; i < V; i++) {
//            if (!vis[i]) {
//                if (dfs(adj, vis, i, -1)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean dfs(ArrayList<ArrayList<Integer>> adj,
//                       boolean[] vis,
//                       int src,
//                       int par) {
//
//        vis[src] = true;
//
//        for (int nbr : adj.get(src)) {
//            if (nbr != par) {
//                if (vis[nbr]) {
//                    return true;
//                }
//
//                if (dfs(adj, vis, nbr, src)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }