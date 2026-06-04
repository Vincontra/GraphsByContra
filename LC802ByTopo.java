import java.lang.reflect.Array;
import java.util.*;
public class LC802ByTopo {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer>ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        // logic is simple
        // topo works for indegree and this question is based on outdegree
        // now what we have done is just change the edges or reversed them
        // reason is orignially we have to start from terminal node means outdegree 0
        // so in reverse manner their if we reverse their edges outdgree 0 means indegree 0
        // and now we can appply topo easily
        // and in topo is only applicable on DAG
        // so if the cycle is there or any node connected to those cycles will be automatically eliminated
        // and whatever is outside the cycle are safe nodes
        // means all the elements from topo sort will be our safe nodes
        // and that's it
        //CONTRA

        for (int i=0;i<graph.length;i++){
            int arr[]=graph[i];
            for (int j=0;j<arr.length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }
        int indegree[]=new int[graph.length];
        for (int i=0;i<graph.length;i++){
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
        while (!q1.isEmpty()){
            int curr=q1.remove();
            ans.add(curr);
            for (int i:adj.get(curr)){
                indegree[i]--;
                if (indegree[i]==0){
                    q1.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;

    }
}
