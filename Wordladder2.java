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
public class Wordladder2 { // HARDEST EVER THOUGHT IT BUT COULD NOT CODE IT LIKE PRO
    // WAS ABLE TO CODE ABOVE ON 33/35 CASES BUT NOT OPTIMIZED ONE
    // NEED TO CHECK THIS AGAIN AND AGAIN

    class Solution {
        HashMap<String, ArrayList<String>> parent=new HashMap<>();
        List<List<String>>ans=new ArrayList<>();
        public List<List<String>> findLadders(String beginWord,String endWord,List<String>wordList) {
            HashSet<String>hs=new HashSet<>(wordList);
            if (!hs.contains(endWord)){
                return ans;
            }
            Queue<String> q = new LinkedList<>();
            q.add(beginWord);
            HashMap<String,Integer>level=new HashMap<>();
            level.put(beginWord,0);
            while (!q.isEmpty()){
                String curr=q.remove();
                char arr[] = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String nw = new String(arr);
                        if (!hs.contains(nw))
                            continue;
                        if (!level.containsKey(nw)) {
                            level.put(nw,level.get(curr)+1);
                            q.add(nw);
                            parent.putIfAbsent(nw,new ArrayList<>());
                            parent.get(nw).add(curr);
                        }
                        else if (level.get(nw)==level.get(curr)+1) {
                            parent.get(nw).add(curr);
                        }
                    }
                    arr[i]=old;
                }
            }

            if(!level.containsKey(endWord)){
                return ans;
            }
            ArrayList<String>path=new ArrayList<>();
            dfs(endWord,beginWord,path);
            return ans;
        }
        void dfs(String word,String beginWord,ArrayList<String>path){
            path.add(word);
            if (word.equals(beginWord)){
                ArrayList<String>temp=new ArrayList<>(path);
                Collections.reverse(temp);
                ans.add(temp);
            }
            else{
                if(parent.containsKey(word)){
                    for (String p : parent.get(word)) {
                        dfs(p, beginWord, path);
                    }
                }
            }
            path.remove(path.size()-1);
        }
    }
}
