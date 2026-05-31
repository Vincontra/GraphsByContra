import java.util.*;
public class NoOfIslands {
    public int numIslands(char[][]arr) {
            int m=arr.length;
            int n=arr[0].length;
            int cnt=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]=='1'){
                        cnt++;
                        dfs(i,j,arr,m,n);
                        //bfs(i,j,arr,m,n);
                    }
                }
            }
            return cnt;
    }
    public static void dfs(int i,int j,char arr[][],int m,int n){
            if(i<0||i>=m||j<0||j>=n){
                return;
            }
            if(arr[i][j]=='0'){
                return;
            }
            arr[i][j]='0';
            dfs(i-1,j,arr,m,n);
            dfs(i+1,j,arr,m,n);
            dfs(i,j-1,arr,m,n);
            dfs(i,j+1,arr,m,n);
    }
    public static void bfs(int i, int j, char[][] arr, int m, int n) {
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{i, j});
        arr[i][j]='0'; // visited
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];
            // Up
            if (r - 1 >= 0 && arr[r - 1][c] == '1') {
                arr[r - 1][c] = '0';
                q.add(new int[]{r - 1, c});
            }
            // Down
            if (r + 1 < m && arr[r + 1][c] == '1') {
                arr[r + 1][c] = '0';
                q.add(new int[]{r + 1, c});
            }
            // Left
            if (c - 1 >= 0 && arr[r][c - 1] == '1') {
                arr[r][c - 1] = '0';
                q.add(new int[]{r, c - 1});
            }
            // Right
            if (c + 1 < n && arr[r][c + 1] == '1') {
                arr[r][c + 1] = '0';
                q.add(new int[]{r, c + 1});
            }
        }

    }
}
