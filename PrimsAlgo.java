import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public int spanningTree(int V, int[][] edges) {
        int sum=0;
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
        pq.add(new Pair(0,0));
        boolean vis[]=new boolean[V];
        while (!pq.isEmpty()){
            Pair curr=pq.remove();
            int node=curr.node;
            int wt= curr.wt;
            if (vis[node]){
                continue;
            }
            vis[node]=true;
            sum+=wt;
            for (Pair c:adj.get(node)){
                int adjNode=c.node;
                int adjWt=c.wt;
                if (!vis[adjNode]){
                    pq.add(new Pair(adjNode,adjWt));
                }
            }
        }
        return sum;

    }
    static class Pair implements Comparable<Pair>{
        int node;
        int wt;
        public Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }
}
