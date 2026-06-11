import java.util.ArrayList;

public class CycleInDirectedGraphDFS {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>>adj){
        boolean vis[]=new boolean[V];
        boolean samepath[]=new boolean[V];
        // Directed me simple logic is:
        // we must be on a same path otherwise it may look like we have visted the node
        // and still we are visiting again via another parent
        // but that is not true as since it is visited by some another parent
        // it may possible that the currNode do not have edge towards that par
        // so even though it is visited we can  go to that parent since no edge as directed
        // this is true in undirected as we can move from both par to child and vice versa
        // That is why we use samepath boolean array to have track we are on same track
        //
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
