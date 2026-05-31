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
}
