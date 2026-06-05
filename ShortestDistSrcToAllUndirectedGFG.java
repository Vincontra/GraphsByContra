import java.util.*;
public class ShortestDistSrcToAllUndirectedGFG
{
    class Solution {
        public int[] shortestPath(int V, int[][] edges, int src) {
            ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<Pair>());
            }
            for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                adj.get(u).add(new Pair(v,1));
                adj.get(v).add(new Pair(u,1));
            }
            int arr[]=new int[V];
            for(int i=0;i<V;i++)arr[i]=Integer.MAX_VALUE;
            arr[src]=0;

            Queue<Integer>q1=new LinkedList<>();
            q1.add(src);
            while(!q1.isEmpty()){
                int curr=q1.remove();
                for(Pair j:adj.get(curr)){
                    if(arr[curr]+j.wt<arr[j.v]){
                        arr[j.v]=arr[curr]+j.wt;
                        q1.add(j.v);
                    }
                }
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]==Integer.MAX_VALUE){
                    arr[i]=-1;
                }
            }
            return arr;
        }

        static class Pair{
            int v;
            int wt;
            public Pair(int v,int wt){
                this.v=v;
                this.wt=wt;

            }
        }
    }

}
