import java.util.*;
class Solutions {

    //1091. Shortest Path in Binary Matrix this is similar q from LC isme 8 possible directions whrere src 00
    //dest n-,n-1
    // and clear path is only you can follow zero
    //
    int shortestPath(int[][] grid, int[] source, int[] destination) { // iska ek aur sol like same but hashmap and all krne ke jagah thoda easy one
        // although this one is good too
        if(grid[source[0]][source[1]]==0||grid[destination[0]][destination[1]]==0){
            return -1;
        }
        HashMap<String,ArrayList<Pair>> hm=new HashMap<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    String curr=i+","+j;
                    if (!hm.containsKey(curr)){
                        hm.put(curr,new ArrayList<>());
                    }
                    if (i>0&&grid[i-1][j]==1){
                        hm.get(curr).add(new Pair((i-1)+","+j, 1));
                    }
                    if (i<grid.length-1&&grid[i+1][j]==1){
                        hm.get(curr).add(new Pair((((i+1)+","+j)), 1));
                    }
                    if (j>0&&grid[i][j-1]==1){
                        hm.get(curr).add(new Pair((((i)+","+(j-1))), 1));
                    }
                    if (j<grid[0].length-1&&grid[i][j+1]==1){
                        hm.get(curr).add(new Pair((((i)+","+(j+1))), 1));
                    }
                }
            }
        }
        int V= hm.size();
        HashMap<String,Integer>dist=new HashMap<>();
        for (String k: hm.keySet()){
            dist.put(k,Integer.MAX_VALUE);
        }
        String src=(source[0]+","+source[1]);
        dist.put(src,0);
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while (!pq.isEmpty()){
            Pair curr=pq.remove();
            String node=curr.v;
            int wt=curr.val;
            for (Pair p: hm.get(node)){
                if (wt+p.val<dist.get(p.v)){
                    dist.put(p.v,wt+p.val);
                    pq.add(new Pair(p.v,dist.get(p.v)));
                }
            }
        }
        if(grid[source[0]][source[1]]==0||grid[destination[0]][destination[1]]==0){
            return -1;
        }
        String dest=(destination[0]+","+destination[1]);
        if (dist.get(dest)==Integer.MAX_VALUE){
            return -1;
        }
        return dist.get(dest);
    }
    static class Pair implements Comparable<Pair>{
        String v;
        int val;
        public Pair(String v,int val){
            this.v=v;
            this.val=val;
        }
        @Override
        public int compareTo(Pair other){
            return this.val-other.val;
        }
    }
}

//class Solution {
//
//    int shortestPath(int[][] grid, int[] source, int[] destination) {
//        if(grid[source[0]][source[1]] == 0 ||
//                grid[destination[0]][destination[1]] == 0)
//            return -1;
//        if(source[0] == destination[0] &&
//                source[1] == destination[1])
//            return 0;
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] dist = new int[n][m];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                dist[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        dist[source[0]][source[1]] = 0;
//        pq.add(new Pair(source[0], source[1], 0));
//        int[] dr = {-1, 0, 1, 0};
//        int[] dc = {0, 1, 0, -1};
//
//        while(!pq.isEmpty()){
//            Pair curr = pq.remove();
//            int r = curr.r;
//            int c = curr.c;
//            int d = curr.dist;
//            if(d > dist[r][c]) continue;
//            if(r == destination[0] && c == destination[1])
//                return d;
//            for(int i = 0; i < 4; i++){
//                int nr = r + dr[i];
//                int nc = c + dc[i];
//                if(nr >= 0 && nr < n &&
//                        nc >= 0 && nc < m &&
//                        grid[nr][nc] == 1){
//                    if(d + 1 < dist[nr][nc]){
//                        dist[nr][nc] = d + 1;
//                        pq.add(new Pair(nr, nc, d + 1));
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//    static class Pair implements Comparable<Pair>{
//        int r;
//        int c;
//        int dist;
//        Pair(int r, int c, int dist){
//            this.r = r;
//            this.c = c;
//            this.dist = dist;
//        }
//        public int compareTo(Pair other){
//            return this.dist - other.dist;
//        }
//    }
//}