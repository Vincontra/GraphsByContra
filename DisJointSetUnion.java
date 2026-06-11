import java.util.*;
public class DisJointSetUnion
{
    public static void main(String[] args) {
        DisJoint o=new DisJoint(7);
        o.unionByRank(1,2);




    }
}

class DisJoint{
    List<Integer>rank=new ArrayList<>();
    List<Integer>par=new ArrayList<>();
    public DisJoint(int n){
        for (int i=0;i<n;i++){
            rank.add(0);
            par.add(i);
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
        if (ulp_u<ulp_v){
            par.set(ulp_u,ulp_v);
        }
        else if (ulp_u>ulp_v){
            par.set(ulp_v,ulp_u);
        }
        else{
            // koi kisi ko bhi chipka do
            par.set(ulp_u,ulp_v);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }
    }

}

