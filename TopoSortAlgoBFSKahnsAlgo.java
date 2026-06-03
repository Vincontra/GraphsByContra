import java.util.*;
public class TopoSortAlgoBFSKahnsAlgo {
    // bfs for topo called as Kahn Algo

//
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int indegree[]=new int[V];
        for (int i=0;i<V;i++){
            for (int j:adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer>q1=new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i]==0){
                q1.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q1.isEmpty()){
            int curr=q1.remove();
            ans.add(curr);
            // abhi iske neigbourse ki indegree we need to reduce by 1 and if that nodes indegree becomes 0 add to queue
            for (int j:adj.get(curr)){
                indegree[j]--;
                if (indegree[j]==0){
                    q1.add(j);
                }
            }
        }
        return ans;
    }

}
