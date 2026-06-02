import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphDFS {
    public boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            int arr[]=graph[i];
            for(int j=0;j<arr.length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        for(int i=0;i<adj.size();i++){
            if(color[i]==-1){ // connected components
                if(!check(i,adj,color,0)){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean check(int node, ArrayList<ArrayList<Integer>>adj,int color[],int col){
        color[node]=col;
        for(int i:adj.get(node)){
            if(color[i]==-1){
                if (!check(i,adj,color,1-col)){
                        return false;
                }
            }
            else if(color[node]==color[i]){
                    return false;
            }
        }
        return true;
    }
}
