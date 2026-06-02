import java.util.*;
public class BipartiteGraphBFS {
    public static void main(String[] args) {
        //785. Is Graph Bipartite?
        // agar ubdirected graph me cycle odd hai then graph is not bipartitie
        // only even allowed
        // reason: we have to color the graph using only two colors  such that adjacent ones have diff color
        // abhi ye krne jaoge to agar cycle nhi hai ya jo part cycle ke bahar hai uske liye always works
        // cycle me even ke liye works
        // Approach:
        // just bfs color it as mentioned and agar dono ke same ata hai means not bipartite
        // else hai
    }

        public boolean isBipartite(int[][] graph) {
            int color[]=new int[graph.length];
            Arrays.fill(color,-1);
            ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
            for(int i=0;i<graph.length;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<graph.length;i++){
                int arr[]=graph[i];
                for(int j=0;j<arr.length;j++){
                    adj.get(i).add(graph[i][j]);
                }
            }

            for(int i=0;i<adj.size();i++){
                if(color[i]==-1){
                    if(!check(i,adj,color)){
                        return false;
                    }
                }
            }
            return true;

        }
        public static boolean check(int node, ArrayList<ArrayList<Integer>>adj,int color[]){
            Queue<Integer>q1=new LinkedList<>();
            q1.add(node);
            color[node]=0;
            while(!q1.isEmpty()){
                int currnode=q1.remove();
                for(int i:adj.get(currnode)){
                    if(color[i]==-1){
                        color[i]=1-color[currnode];
                        q1.add(i);
                    }else if(color[currnode]==color[i]){
                        return false;
                    }
                }
            }
            return true;
        }
}
