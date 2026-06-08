import java.util.PriorityQueue;

public class PathWithMaxDiff {
    class Solution {
        public int minimumEffortPath(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int dist[][]=new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            dist[0][0]=0;
            // we need to have the track for max effort across the path
            PriorityQueue<Pair>pq=new PriorityQueue<>();
            pq.add(new Pair(0,0,0));
            int max=0;
            while (!pq.isEmpty()){
                Pair curr=pq.remove();
                int val=curr.val;
                int r=curr.r;
                int c=curr.c;
                if(r==n-1&&c==m-1){
                    return val;
                }
                for (int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if (nr>=0&&nr<n&&nc>=0&&nc<m){
                        int nwdiff=Math.max(val,Math.abs(grid[r][c]-grid[nr][nc]));
                        if (nwdiff<dist[nr][nc]){
                            dist[nr][nc]=nwdiff;
                            pq.add(new Pair(nwdiff,nr,nc));
                        }
                    }
                }

            }
            return max;

        }
        static class Pair implements Comparable<Pair>{
            int val;
            int r;
            int c;
            public Pair(int val,int r,int c){
                this.val=val;
                this.r=r;
                this.c=c;
            }

            @Override
            public int compareTo(Pair o) {
                return this.val-o.val;
            }
        }
    }
}
