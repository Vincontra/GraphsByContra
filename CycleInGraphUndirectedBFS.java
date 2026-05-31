import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class CycleInGraphUndirectedBFS {
    public static void main(String[] args) {
        // tc  O(N+2E)
        // sc O(N)
    }
    public boolean Cycle(int V, ArrayList<ArrayList<Integer>>adj){
        boolean vis[]=new boolean[V];
        for (int i=0;i<V;i++){ // this for connected component
            if (!vis[i]){
                if (check(i,V,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(int src,int V,ArrayList<ArrayList<Integer>>adj,boolean vis[]){
        vis[src]=true;
        Queue<Pair>q1=new LinkedList<>();
        q1.add(new Pair(src,-1));
        while (!q1.isEmpty()){
            Pair curr=q1.remove();
            int node=curr.src;
            int par=curr.par;
            for (int i:adj.get(node)){
                if (!vis[i]){
                    vis[i]=true;
                    q1.add(new Pair(i,node));
                }else if (par!=i){
                    return true;// cycle mil gyai
                }
            }
        }
        return false;
    }
    static class Pair{
        int src;
        int par;
        public Pair(int src,int par){
            this.src=src;
            this.par=par;
        }
    }
}
