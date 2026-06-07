import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijikstraByPQ {

    // Question is Why Dijikstra Does not Work for Negative Weight Cycle??

    // It does not work in neg cycles as well as neg e=weight edges the reason is
    // each time the dist will decrease than the prev as neg weight ;; take any graph do the simulation you will get it
    // It will be infinite loop ---->>>>>>>>> TLE
    //BOOM


    // TC: E*LOGV
    public int[] dijkstra(int V, int[][] edges, int src) {
        int dist[]=new int[V];
        for (int i=0;i<dist.length;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while (!pq.isEmpty()){
            Pair curr=pq.remove();
            int wt= curr.wt;
            int node=curr.node;
            for (Pair c:adj.get(node)){
                if (wt+c.wt<dist[c.node]){
                    dist[c.node]=wt+c.wt;
                    pq.add(new Pair(c.node,wt+c.wt));
                }
            }
        }

        return dist;
    }
    static class Pair implements Comparable<Pair>{
        int wt;
        int node;
        public Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
        @Override
        public int compareTo(Pair other){
            return this.wt-other.wt;
        }
    }
}
