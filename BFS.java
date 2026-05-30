import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner v=new Scanner(System.in);
        int V=v.nextInt();
        int E=v.nextInt();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<E;i++){
            int x=v.nextInt();
            int y=v.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        ArrayList<Integer>ans=func(V,adj);
        System.out.println(ans);
    }
    public static ArrayList<Integer> func(int V,ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer>bfs=new ArrayList<>();
        boolean vis[]=new boolean[V];
        // if it is one based indexing then it should be V+1
        Queue<Integer>q1=new LinkedList<>();
        q1.add(0);// start node
        vis[0]=true;
        while (!q1.isEmpty()){
            Integer node=q1.remove();
            bfs.add(node);
            // add all the neighbourse for the current one
            for (Integer i:adj.get(node)){
                if(!vis[i]){
                    q1.add(i);
                    vis[i]=true;
                }
            }
        }
        return bfs;
    }
}