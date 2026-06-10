public class CitySmallestNoNeighborsThresholdDistance {
    //City With the Smallest Number of Neighbors at a Threshold Distance
    // lc 1334
    public int findTheCity(int n, int[][] edges, int k) {
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    mat[i][j]=0;
                }else{
                    mat[i][j]=(int)1e8;
                }

            }
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            mat[u][v]=wt;
            mat[v][u]=wt;
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if((mat[i][via]!=(int)1e8)&&(mat[via][j]!=(int)1e8)){
                        mat[i][j]=Math.min(mat[i][j],mat[i][via]+mat[via][j]);
                    }
                }
            }
        }


        int ansNode=0;
        int MinCnt=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]<=k){
                    cnt++;
                }
            }
            if(cnt<MinCnt){
                MinCnt=cnt;
                ansNode=i;

            }
            else if(cnt==MinCnt){
                ansNode=Math.max(ansNode,i);
            }
        }
        return ansNode;

    }
}
