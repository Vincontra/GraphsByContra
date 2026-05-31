import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    // LC 994

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q1=new LinkedList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==2){
                    q1.add(new Pair(i,j,0));
                }
            }
        }
        int ans=0;
        while (!q1.isEmpty()){
            int size=q1.size();
            for (int i=0;i<size;i++){
                Pair rem=q1.remove();
                int row= rem.r;
                int col=rem.c;
                ans=Math.max(ans,rem.t);

                if (row-1!=-1&&grid[row-1][col]==1){
                    q1.add(new Pair(row-1,col,rem.t+1));
                    grid[row-1][col]=2; // le bc tu bhi saad
                }
                if (row+1!=n&&grid[row+1][col]==1){
                    q1.add(new Pair(row+1,col,rem.t+1));
                    grid[row+1][col]=2; // le bc tu bhi saad

                }
                if (col-1!=-1&&grid[row][col-1]==1){
                    q1.add(new Pair(row,col-1,rem.t+1));
                    grid[row][col-1]=2; // le bc tu bhi saad

                }
                if (col+1!=m&&grid[row][col+1]==1){
                    q1.add(new Pair(row,col+1,rem.t+1));
                    grid[row][col+1]=2; // le bc tu bhi saad
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
    static class Pair{
        int r;
        int c;
        int t;
        public Pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;

        }
    }

}
