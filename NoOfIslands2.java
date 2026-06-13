import java.util.*;
public class NoOfIslands2{
    // see it on gfg
    //online queries
    // 0 --> SEA
    // 1 -->ISLANDS
    // after each query we have to tell the no of components this is the Q

    //To be Honest I dont get this one on my own
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        boolean mat[][]=new boolean[rows][cols];
        List<Integer>l1=new ArrayList<>();
        DisJoint ds=new DisJoint(rows*cols);
        int ans=0;
        for (int i=0;i<operators.length;i++){  // queries
            int u=operators[i][0];
            int v=operators[i][1];// nothing but coordinates
            int node=u*cols+v;
            if (!mat[u][v]){
                mat[u][v]=true;
                ans+=1;  // mman ke chalo this is one of the component
                // abhi all 4 dir me check
                if (u>0&&mat[u-1][v]){
                    int nodeupparwala=(u-1)*cols+v;
                    if (ds.findUPar(node)!=ds.findUPar(nodeupparwala)){
                        ds.unionByRank(nodeupparwala,node);
                        ans--;
                    }
                }
                if (u<rows-1&&mat[u+1][v]){
                    int nodeupparwala=(u+1)*cols+v;
                    if (ds.findUPar(node)!=ds.findUPar(nodeupparwala)){
                        ds.unionByRank(nodeupparwala,node);
                        ans--;
                    }
                }
                if (v>0&&mat[u][v-1]){
                    int nodeupparwala=(u)*cols+v-1;
                    if (ds.findUPar(node)!=ds.findUPar(nodeupparwala)){
                        ds.unionByRank(nodeupparwala,node);
                        ans--;
                    }
                }
                if (v<cols-1&&mat[u][v+1]){
                    int nodeupparwala=(u)*cols+v+1;
                    if(ds.findUPar(node)!=ds.findUPar(nodeupparwala)){
                        ds.unionByRank(nodeupparwala,node);
                        ans--;
                    }
                }

            }
            l1.add(ans);
        }
        return l1;
    }
}

//class DisJoint {
//    List<Integer>rank=new ArrayList<>();
//    List<Integer>par=new ArrayList<>();
//
//    List<Integer>size=new ArrayList<>();
//    public DisJoint(int n){
//        for (int i=0;i<n;i++){
//            rank.add(0);
//            par.add(i);
//            size.add(1);
//        }
//    }
//    public  int findUPar(int node){
//        // isme sath ke sath Path compression bhi krli hai
//        if (node==par.get(node)){
//            return node;
//        }
//        int ulp=findUPar(par.get(node));
//        par.set(node,ulp);
//        return ulp;
//    }
//    public void unionByRank(int u,int v){
//        int ulp_u=findUPar(u);
//        int ulp_v=findUPar(v);
//        if (ulp_u==ulp_v){
//            return;
//        }
//        if (rank.get(ulp_u)<rank.get(ulp_v)){
//            par.set(ulp_u,ulp_v);
//        }
//        else if (rank.get(ulp_u)>rank.get(ulp_v)){
//            par.set(ulp_v,ulp_u);
//        }
//        else{
//            // koi kisi ko bhi chipka do
//            par.set(ulp_u,ulp_v);
//            rank.set(ulp_v,rank.get(ulp_v)+1);
//        }
//    }
//    public void unionBySize(int u,int v){
//        int ulp_u=findUPar(u);
//        int ulp_v=findUPar(v);
//        if (ulp_u==ulp_v){
//            return;
//        }
//        if (size.get(ulp_u)<size.get(ulp_v)){
//            par.set(ulp_u,ulp_v);
//            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
//        }
//        else{
//            par.set(ulp_v,ulp_u);
//            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
//        }
//    }
//}
