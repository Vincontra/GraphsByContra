import java.util.*;
public class WordLadder1 {
    // hardest question ever but i got this withing 15 mins of thinking
    // removal of vis is imp from hashset so that is somethiing u have to thingk about
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String>hs=new HashSet<>();
            for(int i=0;i<wordList.size();i++){
                hs.add(wordList.get(i));
            }
            if(!hs.contains(endWord)){
                return 0;
            }
            Queue<Pair>q1=new LinkedList<>();
            q1.add(new Pair(beginWord,1));
            hs.remove(beginWord);
            while(!q1.isEmpty()){
                Pair curr=q1.remove();
                String c=curr.word;
                int lvl=curr.lvl;
                if(c.equals(endWord)){
                    return lvl;
                }
                else{
                    //try to change each char and then check is it in hashmap if so then add it to queue
                    // with curr.lvl+1;
                    for(int i=0;i<c.length();i++){
                        // i th char ko a se lekr z tak change and it should not be eqal to string c as
                        // jisse ban rhe hai usko hi wapas so overhead that is why
                        char arr[]=c.toCharArray();
                        for(char j='a';j<='z';j++){
                            if(arr[i]==j){
                                continue;
                            }
                            arr[i]=j;
                            String nw=new String(arr);
                            if(hs.contains(nw)){
                                q1.add(new Pair(nw,lvl+1));
                                hs.remove(nw);         // very imp to do this as it might recheck even though we have visited this one
                            }
                        }
                    }
                }
            }
            return 0;
        }
        static class Pair{
            String word;
            int lvl;
            public Pair(String w,int lvl){
                this.word=w;
                this.lvl=lvl;
            }
        }
    }
}
