import java.util.*;
public class CourseSchedule2 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>ans=isCyclic(numCourses,prerequisites);
            if(ans.size()!=numCourses){
                return new int[0];
            }
            int a[]=new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                a[i]=ans.get(i);
            }
            return a;
        }
        public ArrayList<Integer>isCyclic(int V,int[][] edges) {
            ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<>());
            }
            for(int[]edge:edges){
                adj.get(edge[1]).add(edge[0]);
            }
            int indegree[]=new int[V];
            for(int i=0;i<V;i++){
                for(int j:adj.get(i)){
                    indegree[j]++;
                }
            }
            Queue<Integer>q1=new LinkedList<>();
            for(int i=0;i<indegree.length;i++){
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
            return l1;
        }
    }

}
