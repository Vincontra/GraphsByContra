import java.util.ArrayList;
import java.util.List;

public class MostStonesRemovedwithSameRowColumn_947 {

//    public int removeStones(int[][] stones) {
//        int n=stones.length;
//        int mxr=0;
//        int mxc=0;
//        for (int i = 0;i<stones.length;i++){
//            mxr=Math.max(mxr,stones[i][0]);
//            mxc=Math.max(mxc,stones[i][1]);
//        }
//        Disjoint ds=new Disjoint(mxc+mxr);
//
//        // agar koi one hai at any cell and we have any other one in its row or col they are part of
//        // same component this is logic basically other wise we cant remove the current stone
//        // and in each component we can remove total-1 because last one cant be removed as it does not have any one
//        // in its row or col
//        // ans+=for each compsize-1;
//        // lets connect evryone and the we will traverse to check each ultimate par size -1
//        for (int i=0;i<stones.length;i++){
//            int nr=stones[i][0];
//            int nc=stones[i][1];
//            int node=(mxc+1)*nr+nc;
//            for (int j=i+1;j<stones.length;j++){
//                int adjr=stones[j][0];
//                int adjc=stones[j][1];
//                int adjNode=(mxc+1)*adjr+adjc;
//                if ((nr==adjr||nc==adjc)&&(ds.findUPar(node)!=ds.findUPar(adjNode))){
//                    ds.unionBySize(node,adjNode);
//                }
//            }
//        }
//        int ans=0;
//        for (int i=0;i<n;i++){
//            if (ds.findUPar(i)==i){
//                ans+=ds.size.get(i)-1;
//            }
//        }
//        return ans;
//    }



    public int removeStones(int[][] stones) {
        int n = stones.length;
        Disjoint ds = new Disjoint(n);
        for (int i = 0; i < n; i++) {
            int nr = stones[i][0];
            int nc = stones[i][1];
            for (int j = i + 1; j < n; j++) {
                int adjr = stones[j][0];
                int adjc = stones[j][1];
                if (nr == adjr || nc==adjc){
                    ds.unionBySize(i,j);
                }
            }
        }
        int ans=0;
        for (int i=0;i<n;i++) {
            if (ds.findUPar(i)==i) {
                ans+=ds.size.get(i)-1;
            }
        }
        return ans;
    }
}

class Disjoint{
    List<Integer> par=new ArrayList<>();
    List<Integer>size=new ArrayList<>();

    public Disjoint(int n){
        for (int i=0;i<=n;i++){
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



