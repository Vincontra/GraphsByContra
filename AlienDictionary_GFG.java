import java.util.*;

public class AlienDictionary_GFG {
    public String findOrder(String[] words) {
        StringBuilder sb=new StringBuilder();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        HashSet<Character>hs=new HashSet<>();

        for (int i=0;i<words.length;i++){
            for (char c:words[i].toCharArray()){
                hs.add(c);
            }
        }

        for (int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<words.length-1;i++){
            String f=words[i];
            String s = words[i+1];
            int len=Math.min(f.length(),s.length());
            boolean check=false;
            for (int j=0;j<len;j++){
                if (f.charAt(j)!=s.charAt(j)){
                    adj.get(f.charAt(j)-'a').add(s.charAt(j)-'a');
                    check=true;
                    break;
                }
            }
            if (!check&&f.length()>s.length()){
                return "";
            }
        }

        int indegree[]=new int[26];
        for (int i=0;i<26;i++){
            for (int j:adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer>q1=new LinkedList<>();
        for (char c:hs){
            if (indegree[c-'a']==0){
                q1.add(c-'a');
            }
        }
        while (!q1.isEmpty()){
            int curr=q1.remove();
            sb.append((char)(curr+'a'));
            for (int i:adj.get(curr)){
                indegree[i]--;
                if (indegree[i]==0){
                    q1.add(i);
                }
            }
        }

        if (hs.size()!=sb.length()){
            return "";
        }
        return sb.toString();

    }
}
//1. Take every adjacent pair of strings.
//
//        2. Traverse both strings together.
//
//        3. Find first mismatching character.
//
//        4. If char1 != char2,
//        char1 must come before char2.
//        Create edge char1 -> char2.
//        Break.
//
//        5. After processing all pairs,
//        graph of character ordering is ready.
//
//        6. Some characters may not appear in any edge.
//        They are still nodes in graph.
//
//        7. Apply Topological Sort.
//
//        8. If topo contains all characters,
//        store them in a string and return.
//
//        9. If cycle exists,
//        valid ordering is not possible.