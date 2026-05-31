public class FloodFillAlgo {
    // LC 733
    public static void main(String[] args) {


    }
    public int[][] floodFill(int[][]arr, int sr, int sc, int color) {
        int n=arr.length;
        int m=arr[0].length;
        boolean check[][]=new boolean[n][m];;
        int initilaCol=arr[sr][sc];
        dfs(arr,sr,sc,color,check,n,m,initilaCol);
        return arr;
    }
    public static void dfs(int [][]arr,int sr,int sc,int color,boolean check[][],int n,int m,int initCol){
        if(sr<0||sr>=n||sc<0||sc>=m){
            return;
        }
        if(check[sr][sc]){
            return;
        }
        if (arr[sr][sc]!=initCol){
            return;
        }
        check[sr][sc]=true;
        arr[sr][sc]=color;
        dfs(arr,sr+1,sc,color,check,n,m,initCol);
        dfs(arr,sr-1,sc,color,check,n,m,initCol);
        dfs(arr,sr,sc+1,color,check,n,m,initCol);
        dfs(arr,sr,sc-1,color,check,n,m,initCol);
    }
}
