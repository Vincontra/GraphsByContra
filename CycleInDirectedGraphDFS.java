import java.util.ArrayList;

public class CycleInDirectedGraphDFS {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>>adj){
        boolean vis[]=new boolean[V];
        boolean samepath[]=new boolean[V];
        for (int i=0;i<V;i++){
            if (!vis[i]){
                if (dfs(i,adj,vis,samepath)){
                    return true;
                }
            }
        }
        return false;

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
}
