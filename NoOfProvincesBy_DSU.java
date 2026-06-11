import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoOfProvincesBy_DSU {
    // LC Number of Provinces
    public int findCircleNum(int[][]arr) {
        int ans=0;
        int V=arr.length;
        DisJoint ds=new DisJoint(V);
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if (arr[i][j]==1){
                    ds.unionByRank(i,j);
                }
            }
        }

        for (int i=0;i<V;i++){
            if (ds.par.get(i)==i){
                ans++;
            }
        }
        return ans;


    }


}


class DisJoint{
    List<Integer>rank=new ArrayList<>();
    List<Integer>par=new ArrayList<>();

    List<Integer>size=new ArrayList<>();
    public DisJoint(int n){
        for (int i=0;i<n;i++){
            rank.add(0);
            par.add(i);
            size.add(1);
        }
    }
    public  int findUPar(int node){
        // isme sath ke sath Path compression bhi krli hai
        if (node==par.get(node)){
            return node;
        }
        int ulp=findUPar(par.get(node));
        par.set(node,ulp);
        return ulp;
    }
    public void unionByRank(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if (ulp_u==ulp_v){
            return;
        }
        if (rank.get(ulp_u)<rank.get(ulp_v)){
            par.set(ulp_u,ulp_v);
        }
        else if (rank.get(ulp_u)>rank.get(ulp_v)){
            par.set(ulp_v,ulp_u);
        }
        else{
            // koi kisi ko bhi chipka do
            par.set(ulp_u,ulp_v);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }
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
