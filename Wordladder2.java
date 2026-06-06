//
//class Solution {
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//
//        List<List<String>> ans = new ArrayList<>();
//
//        HashSet<String> hs = new HashSet<>(wordList);
//
//        if (!hs.contains(endWord)) {
//            return ans;
//        }
//
//        Queue<ArrayList<String>> q1 = new LinkedList<>();
//
//        ArrayList<String> seq = new ArrayList<>();
//        seq.add(beginWord);
//        q1.add(seq);
//
//        hs.remove(beginWord);
//
//        while (!q1.isEmpty()) {
//
//            int size = q1.size();
//
//            HashSet<String> joDeleteKrnehaiAfterCurrLvl = new HashSet<>();
//
//            boolean check = false;
//
//            for (int i = 0; i < size; i++) {
//
//                ArrayList<String> curr = q1.remove();
//
//                String lastWord = curr.get(curr.size() - 1);
//
//                if (lastWord.equals(endWord)) {
//
//                    ans.add(curr);
//                    check = true;
//                    continue;
//                }
//
//                // IMPORTANT OPTIMIZATION
//                if (check) continue;
//
//                char[] arr = lastWord.toCharArray();
//
//                for (int j = 0; j < arr.length; j++) {
//
//                    char old = arr[j];
//
//                    for (char c = 'a'; c <= 'z'; c++) {
//
//                        if (c == old) continue;
//
//                        arr[j] = c;
//
//                        String nw = new String(arr);
//
//                        if (hs.contains(nw)) {
//
//                            ArrayList<String> temp = new ArrayList<>(curr);
//                            temp.add(nw);
//
//                            q1.add(temp);
//
//                            joDeleteKrnehaiAfterCurrLvl.add(nw);
//                        }
//                    }
//
//                    arr[j] = old;
//                }
//            }
//
//            for (String s : joDeleteKrnehaiAfterCurrLvl) {
//                hs.remove(s);
//            }
//
//            if (check) {
//                break;
//            }
//        }
//
//        return ans;
//    }
//}



import java.util.*;
//public class Wordladder2 { // HARDEST EVER THOUGHT IT BUT COULD NOT CODE IT LIKE PRO
//    // WAS ABLE TO CODE ABOVE ON 33/35 CASES BUT NOT OPTIMIZED ONE
//    // NEED TO CHECK THIS AGAIN AND AGAIN
//
//    class Solution {
//        HashMap<String, ArrayList<String>> parent=new HashMap<>();
//        List<List<String>>ans=new ArrayList<>();
//        public List<List<String>> findLadders(String beginWord,String endWord,List<String>wordList) {
//            HashSet<String>hs=new HashSet<>(wordList);
//            if (!hs.contains(endWord)){
//                return ans;
//            }
//            Queue<String> q = new LinkedList<>();
//            q.add(beginWord);
//            HashMap<String,Integer>level=new HashMap<>();
//            level.put(beginWord,0);
//            while (!q.isEmpty()){
//                String curr=q.remove();
//                char arr[] = curr.toCharArray();
//                for (int i = 0; i < arr.length; i++) {
//                    char old = arr[i];
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        arr[i] = c;
//                        String nw = new String(arr);
//                        if (!hs.contains(nw))
//                            continue;
//                        if (!level.containsKey(nw)) {
//                            level.put(nw,level.get(curr)+1);
//                            q.add(nw);
//                            parent.putIfAbsent(nw,new ArrayList<>());
//                            parent.get(nw).add(curr);
//                        }
//                        else if (level.get(nw)==level.get(curr)+1) {
//                            parent.get(nw).add(curr);
//                        }
//                    }
//                    arr[i]=old;
//                }
//            }
//
//            if(!level.containsKey(endWord)){
//                return ans;
//            }
//            ArrayList<String>path=new ArrayList<>();
//            dfs(endWord,beginWord,path);
//            return ans;
//        }
//        void dfs(String word,String beginWord,ArrayList<String>path){
//            path.add(word);
//            if (word.equals(beginWord)){
//                ArrayList<String>temp=new ArrayList<>(path);
//                Collections.reverse(temp);
//                ans.add(temp);
//            }
//            else{
//                if(parent.containsKey(word)){
//                    for (String p : parent.get(word)) {
//                        dfs(p, beginWord, path);
//                    }
//                }
//            }
//            path.remove(path.size()-1);
//        }
//    }
//}

class Solution {
    // this one is coded by me took some help as i was implementing it in a little bit in a wrong way
    //Done it and understand it now
    static HashMap<String,Integer> hm = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        hm.clear();
        int maxDepth = ladderLength(beginWord, endWord, wordList);
        List<List<String>> ans = new ArrayList<>();
        if(maxDepth == 0){
            return ans;
        }
        List<String> curr = new ArrayList<>();
        curr.add(endWord);
        dfs(beginWord, endWord, curr, ans);
        return ans;
    }
    public void dfs(String beginWord, String currword,List<String> seq, List<List<String>> ans){
        if(currword.equals(beginWord)){
            List<String>temp=new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        char arr[]=currword.toCharArray();
        for(int i=0;i<arr.length;i++){
            char old=arr[i];
            for(char j='a';j<='z';j++){
                if(old == j){
                    continue;
                }
                arr[i]=j;
                String nw = new String(arr);
                if(hm.containsKey(nw)&& hm.get(nw) + 1 == hm.get(currword)){
                    seq.add(nw);
                    dfs(beginWord, nw, seq, ans);
                    seq.remove(seq.size()-1);
                }
            }
            arr[i]=old;
        }
    }
    public int ladderLength(String beginWord, String endWord,List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        if(!hs.contains(endWord)){
            return 0;
        }
        Queue<Pair> q1 = new LinkedList<>();
        q1.add(new Pair(beginWord, 0));
        hm.put(beginWord, 0);
        hs.remove(beginWord);
        while(!q1.isEmpty()){
            int size = q1.size();
            HashSet<String> usedThisLevel = new HashSet<>();
            for(int k=0;k<size;k++){
                Pair curr = q1.remove();
                String c = curr.word;
                int lvl = curr.lvl;
                if(c.equals(endWord)){
                    return lvl + 1;
                }
                for(int i=0;i<c.length();i++){
                    char arr[] = c.toCharArray();
                    for(char j='a';j<='z';j++){
                        if(arr[i] == j) continue;
                        arr[i] = j;
                        String nw = new String(arr);
                        if(hs.contains(nw)){
                            if(!hm.containsKey(nw)){
                                hm.put(nw, lvl + 1);
                                q1.add(new Pair(nw, lvl + 1));
                                usedThisLevel.add(nw);
                            }
                        }
                    }
                }
            }
            for(String s : usedThisLevel){
                hs.remove(s);
            }
        }
        return 0;
    }

    static class Pair{
        String word;
        int lvl;
        public Pair(String w, int lvl){
            this.word = w;
            this.lvl = lvl;
        }
    }
}