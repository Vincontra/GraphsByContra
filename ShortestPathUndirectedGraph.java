import java.util.*;
public class ShortestPathUndirectedGraph {

    class Solution {
        public List<Integer> shortestPath(int n, int m, int edges[][]) {
            List<Integer>ans=new ArrayList<>();
            int dist[]=new int[n+1];
            for(int i=0;i<=n;i++){
                dist[i]=Integer.MAX_VALUE;
            }
            dist[1]=0;
            int par[]=new int[n+1];
            for(int i=1;i<=n;i++)par[i]=i;

            ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
            for(int i=0;i<=n;i++){
                adj.add(new ArrayList<Pair>());
            }

            for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                int wt=edges[i][2];
                adj.get(u).add(new Pair(v,wt));
                adj.get(v).add(new Pair(u,wt));
            }

            PriorityQueue<Pair>pq=new PriorityQueue<>();
            pq.add(new Pair(1,0));
            while(!pq.isEmpty()){
                Pair curr=pq.remove();
                int node=curr.node;
                int wt=curr.wt;
                for(Pair i:adj.get(node)){
                    if(wt+i.wt<dist[i.node]){
                        dist[i.node]=wt+i.wt;
                        pq.add(new Pair(i.node,dist[i.node]));
                        par[i.node]=node;
                    }
                }
            }

            if(dist[n]==Integer.MAX_VALUE){
                ans.add(-1);
                return ans;
            }

            int dest=n;

            while(par[dest]!=dest){
                ans.add(dest);
                dest=par[dest];
            }
            ans.add(1);
            ans.add(dist[n]);
            Collections.reverse(ans);
            return ans;

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
}
