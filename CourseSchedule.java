import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return isCyclic(numCourses,prerequisites);
    }
    public boolean isCyclic(int V, int[][] edges) {
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
        ArrayList<Integer>l1=new ArrayList<>();
        while (!q1.isEmpty()){
            int curr=q1.remove();
            l1.add(curr);
            for (int i:adj.get(curr)){
                indegree[i]--;
                if (indegree[i]==0){
                    q1.add(i);
                }
            }
        }
        return l1.size()==V;

    }

}
