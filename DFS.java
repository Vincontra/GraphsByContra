import java.util.ArrayList;
import java.util.Scanner;
public class DFS {
    public static void main(String[] args) {
        Scanner v=new Scanner(System.in);
        int V=v.nextInt();
        int E=v.nextInt();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<E;i++){
            int x=v.nextInt();
            int y=v.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        // TC:DFS over the entire graph:O(V + E)
        ArrayList<Integer>ans=new ArrayList<>();
        boolean arr[]=new boolean[V];
        int cnt=0; //connectedComponents
        for (int i=0;i<V;i++){ // this loop basically i m using just to ensure all connected components also get visited
            if (!arr[i]){
                dfs(adj,ans,arr,i);
                cnt++;
            }
        }
        System.out.println(ans);
        System.out.println(cnt);
    }

    public static void dfs(ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans,boolean arr[],int node){
        arr[node]=true;
        ans.add(node);
        for (int i:adj.get(node)){
            if (!arr[i]){
                dfs(adj,ans,arr,i);
            }
        }
    }
}
