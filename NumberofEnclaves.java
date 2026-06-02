import java.util.*;
public class NumberofEnclaves {
    public static void main(String[] args) {

    }
        public int numEnclaves(int[][]arr) {

            int ans=0;
            Queue<Pair>q1=new LinkedList<>();
            int m=arr.length;
            int n=arr[0].length;

            for(int j=0;j<n;j++){
                if(arr[0][j]==1){
                    q1.add(new Pair(0,j));
                }
                if(arr[m-1][j]==1){
                    q1.add(new Pair(m-1,j));
                }
            }

            for(int i=1;i<m-1;i++){
                if(arr[i][0]==1){
                    q1.add(new Pair(i,0));
                }
                if(arr[i][n-1]==1){
                    q1.add(new Pair(i,n-1));
                }
            }

            while(!q1.isEmpty()){
                Pair curr=q1.remove();
                int r=curr.r;
                int c=curr.c;
                arr[r][c]=0;

                if(r-1>=0&&arr[r-1][c]==1){
                    arr[r-1][c]=0;
                    q1.add(new Pair(r-1,c));
                }
                if(r+1<m&&arr[r+1][c]==1){
                    arr[r+1][c]=1;
                    q1.add(new Pair(r+1,c));
                }
                if(c-1>=0&&arr[r][c-1]==1){
                    arr[r][c-1]=0;
                    q1.add(new Pair(r,c-1));
                }
                if(c+1<n&&arr[r][c+1]==1){
                    arr[r][c+1]=0;
                    q1.add(new Pair(r,c+1));
                }
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]==1)ans++;
                }
            }

            return ans;


        }
        static class Pair{
            int r;
            int c;
            public Pair(int r,int c){
                this.r=r;
                this.c=c;

            }
        }
}
