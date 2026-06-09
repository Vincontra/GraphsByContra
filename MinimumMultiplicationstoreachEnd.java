import java.util.*;
public class MinimumMultiplicationstoreachEnd {
    //class Solution {
        public int minSteps(int[] arr, int start, int end) {
            boolean vis[]=new boolean[1001];
            Queue<Pair>q1=new LinkedList<>();
            if(start==end){
                return 0;
            }
            q1.add(new Pair(start,0));
            while(!q1.isEmpty()){
                Pair curr=q1.remove();
                int val=curr.val;
                int lvl=curr.lvl;
                if(val==end){
                    return lvl;
                }
                for(int i=0;i<arr.length;i++){
                    int currVal=(arr[i]*val)%1000;
                    if(!vis[currVal]){
                        vis[currVal]=true;
                        q1.add(new Pair(currVal,lvl+1));
                    }
                }
            }
            return -1;

        }
        static class Pair{
            int val;
            int lvl;
            public Pair(int val,int lvl){
                this.val=val;
                this.lvl=lvl;
            }
        }
    //}
}
