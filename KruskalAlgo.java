import java.util.*;
public class KruskalAlgo {
    public static void main(String[] args) {
        //Min Cost to Connect All Points LC
    }
    static int kruskalsMST(int V, int[][] edges) {
        DisJoint ds=new DisJoint(V);
        List<Pair>edg=new ArrayList<>();
        for(int i=0;i<edges.length;i++){   // O(M edges)
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            edg.add(new Pair(u,v,w));
        }
        Collections.sort(edg);   // MlogM
        int ans=0;
        for(int i=0;i<edg.size();i++){    // M*4Alpha*2   and space is O(M) for storing and all
            Pair curr=edg.get(i);
            int u=curr.u;
            int v=curr.v;
            int w=curr.wt;
            if (ds.findUPar(u)!=ds.findUPar(v)){
                ans+=w;
                ds.unionByRank(u,v);
            }
        }
        return ans;
    }
    static class Pair implements Comparable<Pair>{
        int u;
        int v;
        int wt;
        public Pair(int u,int v,int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }

        public int compareTo(Pair o){
            return this.wt-o.wt;
        }

    }


}

//class DisJoint{
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
//
//    }
//
//}
//

