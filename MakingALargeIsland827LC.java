import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MakingALargeIsland827LC {
    public int largestIsland(int[][] grid) {
        int row= grid.length;
        int col=grid[0].length;
        int size=row*col;
        Disjoint ds=new Disjoint(size);
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]==1){
                     if (i>0&&grid[i-1][j]==1){
                         int node=col*i+j;
                         int adjNode=col*(i-1)+j;
                         ds.unionBySize(node,adjNode);
                     }
                    if (i<row-1&&grid[i+1][j]==1){
                        int node=col*i+j;
                        int adjNode=col*(i+1)+j;
                        ds.unionBySize(node,adjNode);
                    }
                    if (j>0&&grid[i][j-1]==1){
                        int node=col*i+j;
                        int adjNode=col*(i)+j-1;
                        ds.unionBySize(node,adjNode);
                    }
                    if (j<col-1&&grid[i][j+1]==1){
                        int node=col*i+j;
                        int adjNode=col*(i)+j+1;
                        ds.unionBySize(node,adjNode);
                    }
                }
            }
        }

        int ans=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                HashSet<Integer>hashSet=new HashSet<>();
                if (grid[i][j]==0){
                    if (i>0&&grid[i-1][j]==1){
                        int adjNode=col*(i-1)+j;
                        hashSet.add(ds.findUPar(adjNode));
                        // just to avouod the adding of ultimatre parent more than one time as we need size for that
                        // it would give wrong answer when we have them more than one time
                        // this can be also done via checking that ultimate par for these node and adjnode are not same then only add
                        // but ffor that matter we need to add node with adjnode as unionBy size but
                        // for this we are just cheking that whether this current position give us max or not we are not actually changing that
                    }
                    if (i<row-1&&grid[i+1][j]==1){
                        int adjNode=col*(i+1)+j;
                        hashSet.add(ds.findUPar(adjNode));
                    }
                    if (j>0&&grid[i][j-1]==1){
                        int adjNode=col*(i)+j-1;
                        hashSet.add(ds.findUPar(adjNode));
                    }
                    if (j<col-1&&grid[i][j+1]==1){
                        int adjNode=col*(i)+j+1;
                        hashSet.add(ds.findUPar(adjNode));
                    }

                    int currsize=0;
                    for (int i1:hashSet){
                        currsize+=ds.size.get(i1);
                    }
                    ans=Math.max(ans,currsize+1);
                }
            }
        }
        for (int i=0;i<row*col;i++){
            ans=Math.max(ans,ds.size.get(ds.findUPar(i)));
        }
        return ans;
    }
}
class Disjoint{
    List<Integer>par=new ArrayList<>();
    List<Integer>size=new ArrayList<>();

    public Disjoint(int n){
        for (int i=0;i<n;i++){
            par.add(i);
            size.add(1);
        }
    }
    public  int findUPar(int node){
        if (node==par.get(node)){
            return node;
        }
        int ulp=findUPar(par.get(node));
        par.set(node,ulp);
        return ulp;
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if (ulp_u==ulp_v){
            return;
        }
        if (size.get(ulp_u)<size.get(ulp_v)){
            par.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            par.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
