import java.util.*;

public class SurroundedRegions130 {
    class Solution {
        public void solve(char[][]arr) {
            int m=arr.length;
            int n=arr[0].length;
            boolean vis[][]=new boolean[m][n];

            // jo boundry pr 0 hai unse start bfs i mean
            // last me vis me jo bhi false;
            // they will be marked as X

            Queue<Pair>q1=new LinkedList<>();
            for(int j=0;j<n;j++){
                if(arr[0][j]=='O'){
                    q1.add(new Pair(0,j));
                }
                if(arr[m-1][j]=='O'){
                    q1.add(new Pair(m-1,j));
                }
            }

            for(int i=1;i<m-1;i++){
                if(arr[i][0]=='O'){
                    q1.add(new Pair(i,0));
                }
                if(arr[i][n-1]=='O'){
                    q1.add(new Pair(i,n-1));
                }
            }

            while(!q1.isEmpty()){
                int s=q1.size();
                for(int i=0;i<s;i++){
                    Pair curr=q1.remove();
                    int r=curr.r;
                    int c=curr.c;
                    vis[r][c]=true;

                    if(r-1>=0&&arr[r-1][c]=='O'&&!vis[r-1][c]){
                        q1.add(new Pair(r-1,c));
                    }
                    if(r+1<m&&arr[r+1][c]=='O'&&!vis[r+1][c]){
                        q1.add(new Pair(r+1,c));
                    }
                    if(c-1>=0&&arr[r][c-1]=='O'&&!vis[r][c-1]){
                        q1.add(new Pair(r,c-1));
                    }
                    if(c+1<n&&arr[r][c+1]=='O'&&!vis[r][c+1]){
                        q1.add(new Pair(r,c+1));
                    }

                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]=='O'&&!vis[i][j]){
                        arr[i][j]='X';
                    }
                }
            }

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
}
