import java.util.*;
public class ShortestDistByTopoGFG {
    // User function Template for Java
    class Solution {

        public int[] shortestPath(int V, int E, int[][] edges) {

            int dist[]=new int[V];
            dist[0]=0;
            for(int i=1;i<V;i++){
                dist[i]=Integer.MAX_VALUE;
            }

            ArrayList<ArrayList<Pair>>adj=new ArrayList<>();

            for(int i=0;i<V;i++){
                adj.add(new ArrayList<Pair>());
            }

            for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                int wt=edges[i][2];
                adj.get(u).add(new Pair(v,wt));
            }

            int indegree[]=new int[V];

            for(int i=0;i<V;i++){
                for(Pair p:adj.get(i)){
                    indegree[p.v]++;
                }
            }

            Queue<Integer>q1=new LinkedList<>();
            for(int i=0;i<indegree.length;i++){
                if(indegree[i]==0){
                    q1.add(i);
                }
            }
            ArrayList<Integer>topo=new ArrayList<>();
            while(!q1.isEmpty()){
                int curr=q1.remove();
                topo.add(curr);
                for(Pair p:adj.get(curr)){
                    indegree[p.v]--;
                    if(indegree[p.v]==0){
                        q1.add(p.v);
                    }
                }
            }


            // now khela hobe

            for(int i=0;i<topo.size();i++){
                int curr=topo.get(i);
                if(dist[curr]==Integer.MAX_VALUE){
                    continue;  //INF=I don't know how to reach this node yet
                }
                for(int j=0;j<adj.get(curr).size();j++){
                    int v=adj.get(curr).get(j).v;
                    int wt=adj.get(curr).get(j).wt;

                    if(dist[curr]+wt<dist[v]){
                        dist[v]=dist[curr]+wt;
                    }

                }

            }
            // this might happen when we did not visit any node
            // it may possible that there is no path to reach there from src
            for(int i=0;i<dist.length;i++){
                if(dist[i]==Integer.MAX_VALUE){
                    dist[i]=-1;
                }
            }
            return dist;

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
