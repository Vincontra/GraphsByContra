//import java.util.ArrayList;
//import java.util.List;
//
//public class NumberofOperationsMakeNetworkConnected {
//    // LC 1319
//    public int makeConnected(int n, int[][] edges) {
//        DisJoint ds=new DisJoint(n);
//        int cntEdges[]=new int[1];
//        // ans would if--------> No of components-1<=cntEdges; then true else false
//        for (int i=0;i<edges.length;i++){
//            int u=edges[i][0];
//            int v=edges[i][1];
//            ds.unionByRank(u,v,cntEdges);
//        }
//        int NoofCompo=0;
//        List<Integer>par=ds.par;
//        for (int i=0;i<n;i++){
//            if (i==par.get(i)){
//                NoofCompo++;
//            }
//        }
//        if (NoofCompo-1<=cntEdges[0]){
//            return NoofCompo-1;
//        }
//        return -1;
//
//    }
//}

//class DisJoint{
//    List<Integer> rank=new ArrayList<>();
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
//    public void unionByRank(int u,int v,int arr[]){
//        int ulp_u=findUPar(u);
//        int ulp_v=findUPar(v);
//        if (ulp_u==ulp_v){
//            arr[0]++;  // this means faltu ka edge or extra edge
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
//
//    }
//
//}
