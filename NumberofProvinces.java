import java.util.*;
public class NumberofProvinces {
    public static void main(String[] args) {

    }
    public int findCircleNum(int[][]arr) {
            int n=arr.length;
            ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
            for(int i=0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i!=j&&arr[i][j]==1){
                        graph.get(i).add(j);
                    }

                }
            }
            int ans=0;
            boolean vis[]=new boolean[n];
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    dfs(i,graph,vis);
                    ans++;
                }
            }
            return ans;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>>graph,boolean vis[]){
            vis[node]=true;
            for(int i:graph.get(node))
            {
                if(!vis[i]){
                    dfs(i,graph,vis);
                }
            }
    }
}
