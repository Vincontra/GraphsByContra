import java.util.*;
public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        int n=dist.length;
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if((dist[i][via]!=(int)1e8)&&(dist[via][j]!=(int)1e8)){
                        dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                    }
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            if (dist[i][i] < 0) {
//                // graph contains a negative weight cycle
//            }
//        }

        // even if there is neg weight cycle the n*n*n iteration will perform
        // after that we need to run the llop through diagonal if <0 means neg weight cycle






    }
}
