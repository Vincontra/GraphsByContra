// User function Template for Java
import java.util.*;
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

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
