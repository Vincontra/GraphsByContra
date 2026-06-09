import java.util.*;
public class NumberWaysArriveDestination {
    class Solution {
        // LC 1976.Number of Ways to Arrive at Destination
        // LC pr cases are big so take care of that
        // kuch overflow ka issue otherwise everythin else is fine
        public int countPaths(int V, int[][] edges) {
            int ans=0;
            ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                int wt=edges[i][2];
                adj.get(u).add(new Pair(v,wt));
                adj.get(v).add(new Pair(u,wt));
            }

            int dist[]=new int[V];
            int ways[]=new int[V];
            for(int i=0;i<dist.length;i++){
                dist[i]=Integer.MAX_VALUE;
            }
            dist[0]=0;
            ways[0]=1;

            PriorityQueue<Pair>pq=new PriorityQueue<>();
            pq.add(new Pair(0,0));

            while(!pq.isEmpty()){
                Pair curr=pq.remove();
                int node=curr.val;
                int wt=curr.wt;
                for(Pair p:adj.get(node)){
                    int adjnode=p.val;
                    int adjwt=p.wt;
                    if(wt+adjwt==dist[adjnode]){
                        ways[adjnode]=ways[adjnode]+ways[node];
                    }
                    else{
                        if(wt+adjwt<dist[adjnode]){
                            dist[adjnode]=wt+adjwt;
                            pq.add(new Pair(adjnode,dist[adjnode]));
                            ways[adjnode]=ways[node];
                        }
                    }

                }
            }
            return ways[V-1];
        }
        static class Pair implements Comparable<Pair>{
            int val;
            int wt;
            public Pair(int val,int wt){
                this.val=val;
                this.wt=wt;

            }

            @Override
            public int compareTo(Pair o){
                return this.wt-o.wt;
            }
        }
    }
}








// this my soln what i thought about
// but this is not correct as we should have the information regarding the related to all nodes
// like at each node how many ways are there to reach in min dist or weight
// i was just considering the last node






//class Solution {
//    public int countPaths(int V, int[][] edges) {
//        int ans=0;
//        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
//        for(int i=0;i<V;i++){
//            adj.add(new ArrayList<>());
//        }
//        for(int i=0;i<edges.length;i++){
//            int u=edges[i][0];
//            int v=edges[i][1];
//            int wt=edges[i][2];
//            adj.get(u).add(new Pair(v,wt));
//            adj.get(v).add(new Pair(u,wt));
//        }
//
//        int dist[]=new int[V];

//        for(int i=0;i<dist.length;i++){
//            dist[i]=Integer.MAX_VALUE;
//        }
//        dist[0]=0;

//
//        PriorityQueue<Pair>pq=new PriorityQueue<>();
//        pq.add(new Pair(0,0));
//
//        while(!pq.isEmpty()){
//            Pair curr=pq.remove();
//            int node=curr.val;
//            int wt=curr.wt;
//            for(Pair p:adj.get(node)){
//                int adjnode=p.val;
//                int adjwt=p.wt;
//                if(adjnode==V-1){
//                    if(wt+adjwt==dist[adjnode]){
//                        ans++; // bcoz we found one more way to reaach the dest with min
//                        // dist so far
//                    }else{
//                        if(wt+adjwt<dist[adjnode]){
//                            dist[adjnode]=wt+adjwt;
//                            pq.add(new Pair(adjnode,dist[adjnode]));
//                            ans=1;
//                        }
//                    }
//                }
//                else{
//                    if(wt+adjwt<dist[adjnode]){
//                        dist[adjnode]=wt+adjwt;
//                        pq.add(new Pair(adjnode,dist[adjnode]));
//                    }
//                }
//            }
//
//        }
//        return ans;
//
//    }
//    static class Pair implements Comparable<Pair>{
//        int val;
//        int wt;
//        public Pair(int val,int wt){
//            this.val=val;
//            this.wt=wt;
//
//        }
//
//        @Override
//        public int compareTo(Pair o){
//            return this.wt-o.wt;
//        }
//    }
//}
