import java.util.*;
public class CheapestFlightsWithinKStops {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            int dist[]=new int[n];
            for (int i=0;i<n;i++) {
                dist[i]=Integer.MAX_VALUE;
            }
            dist[src]=0;
            ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
            for (int i=0;i<n;i++) {
                adj.add(new ArrayList<>());
            }

            for (int i=0;i<flights.length;i++) {
                int u=flights[i][0];
                int v=flights[i][1];
                int cost=flights[i][2];
                adj.get(u).add(new Pair(v, cost));
            }

            Queue<Pair2> pq = new LinkedList<>();
            pq.add(new Pair2(src, 0, 0));
            while (!pq.isEmpty()) {
                Pair2 curr = pq.remove();
                int node = curr.node;
                int wt = curr.wt;
                int cnt = curr.cnt;
                if (cnt>k){
                    continue;
                }
                for (Pair p:adj.get(node)){
                    if (wt+p.wt<dist[p.dest]&&cnt<=k){
                        dist[p.dest]=wt+p.wt;
                        pq.add(new Pair2(p.dest,dist[p.dest],cnt+1));
                    }
                }
            }

            if(dist[dst]==Integer.MAX_VALUE){
                return -1;
            }
            return dist[dst];
        }

        static class Pair {
            int dest;
            int wt;
            public Pair(int dest, int wt) {
                this.dest = dest;
                this.wt = wt;
            }
        }

        static class Pair2 implements Comparable<Pair2> {
            int node;
            int wt;
            int cnt;

            public Pair2(int node, int wt, int cnt) {
                this.node = node;
                this.wt = wt;
                this.cnt = cnt;
            }
            @Override
            public int compareTo(Pair2 o) {
                return this.wt - o.wt;
            }
        }
}
