import java.util.*;
class AccountsMerge721{
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        List<List<String>>ans=new ArrayList<>();
        Disjoint ds=new Disjoint(n);
        HashMap<String,Integer>hashMap=new HashMap<>();
        for (int i=0;i<accounts.size();i++){
            for (int j=1;j<accounts.get(i).size();j++){
                if (!hashMap.containsKey(accounts.get(i).get(j))){
                    hashMap.put(accounts.get(i).get(j),i);
                }
                else{
                    int u=i;
                    int v=hashMap.get(accounts.get(i).get(j));
                    ds.rankByUnion(u,v);
                }
            }
        }
        for (int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for (String s:hashMap.keySet()){
            int l1=hashMap.get(s);
            l1=ds.findPar(l1);
            ans.get(l1).add(s);
        }
        List<List<String>>res=new ArrayList<>();
        for (int i=0;i<n;i++){
            if(ans.get(i).size()==0){
                continue;
            }
            Collections.sort(ans.get(i));
            ans.get(i).add(0,accounts.get(i).get(0));
            res.add(ans.get(i));
        }
        return res;
    }

}

class Disjoint{
    List<Integer>par=new ArrayList<>();
    List<Integer>rank=new ArrayList<>();
    public Disjoint(int n){
        for (int i=0;i<n;i++){
            par.add(i);
            rank.add(0);
        }
    }
    public int findPar(int node){
        if (par.get(node)==node){
            return node;
        }
        par.set(node,findPar(par.get(node)));
        return par.get(node);

    }
    public void rankByUnion(int u,int v){
        int ulpU=findPar(u);
        int ulpV=findPar(v);

        if (rank.get(ulpU)<rank.get(ulpV)){
            par.set(ulpU,ulpV);
        }
        else if (rank.get(ulpU)>rank.get(ulpV)){
            par.set(ulpV,ulpU);
        }
        else{
            par.set(ulpV,ulpU);
            rank.set(ulpU,rank.get(ulpU)+1);
        }


    }
}