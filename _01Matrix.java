import java.util.*;
public class _01Matrix {
    //lc 542
    public static void main(String[] args) {

    }
//    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m=mat.length;
            int n=mat[0].length;
            int ans[][]=new int[m][n];
            Queue<Pair>q1=new LinkedList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==0){
                        q1.add(new Pair(i,j,0));
                    }
                }
            }

            while(!q1.isEmpty()){
                int size=q1.size();
                for(int i=0;i<size;i++){
                    Pair curr=q1.remove();
                    int r=curr.r;
                    int c=curr.c;
                    int lvl=curr.lvl;

                    if(r-1>=0&&mat[r-1][c]==1){
                        ans[r-1][c]=lvl+1;
                        mat[r-1][c]=0;
                        q1.add(new Pair(r-1,c,lvl+1));
                    }
                    if(r+1<m&&mat[r+1][c]==1){
                        ans[r+1][c]=lvl+1;
                        mat[r+1][c]=0;
                        q1.add(new Pair(r+1,c,lvl+1));
                    }
                    if(c-1>=0&&mat[r][c-1]==1){
                        ans[r][c-1]=lvl+1;
                        mat[r][c-1]=0;
                        q1.add(new Pair(r,c-1,lvl+1));
                    }
                    if(c+1<n&&mat[r][c+1]==1){
                        ans[r][c+1]=lvl+1;
                        mat[r][c+1]=0;
                        q1.add(new Pair(r,c+1,lvl+1));
                    }

                }
            }
            return ans;
        }

        static class Pair{
            int r;
            int c;
            int lvl;
            public Pair(int r,int c,int lvl){
                this.r=r;
                this.c=c;
                this.lvl=lvl;

            }
        }
    //}
}
