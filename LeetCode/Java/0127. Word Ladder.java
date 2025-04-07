// Top Interview 150 Graph BFS Q3
class Solution {
    int biBFS(Set<String> begin, Set<String> end, Set<String> beginDict, Set<String> endDict, int res) {
        if (begin.size() == 0) {
            return 0;
        }
        if (begin.size() > end.size()) {
            return biBFS(end, begin, endDict, beginDict, res);
        }        
        // for (String w : begin) {
        //     word.remove(w);
        // }
        Set<String> next = new HashSet<>();
        for (String curr : begin) {
            beginDict.remove(curr);
            char[] ch = curr.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    ch[i] = j;
                    String neighbor = new String(ch);
                    if (beginDict.contains(neighbor)) {
                        if (end.contains(neighbor)) {
                            return res + 1;
                        }
                        next.add(neighbor);
                    }
                    ch[i] = c;
                }
            }
        }
        return biBFS(next, end, beginDict, endDict, res + 1);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> beginDict = new HashSet<>(wordList);
        Set<String> endDict = new HashSet<>(wordList);
        if (!endDict.contains(endWord)) {
            return 0;
        }
        begin.add(beginWord);
        end.add(endWord);
        return biBFS(begin, end, beginDict, endDict, 1);
    }
}
// [Editorial + Beat 99%]
//  Since we know begin and end, we can run bfs from both side. 
//  If curr set/queue is larger than the inverse side, just go the other direction. 
//  Use word or beginDict + endDict to track available next. 

// [Ming] Simple BFS. 
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         // Map<String, List<String>> adj = new HashMap<>();
//         // adj.put(beginWord, new ArrayList<>());
//         Set<String> wordSet = new HashSet<>(wordList);
//         if (!wordSet.contains(endWord)) {
//             return 0;
//         }
//         Queue<String> q = new LinkedList<>();
//         q.add(beginWord);
//         int ans = 1;
//         while (!q.isEmpty()) {
//             ans++;
//             int size = q.size();
//             while (size > 0) {
//                 StringBuilder curr = new StringBuilder(q.poll());
//                 for (int i = 0; i < curr.length(); i++) {
//                     for (int j = 0; j < 26; j++) {
//                         char c = curr.charAt(i);
//                         if (c - 'a' == j) {
//                             continue;
//                         }
//                         char d = (char)(j + 'a');
//                         curr.setCharAt(i, d);
//                         String next = curr.toString();
//                         if (wordSet.contains(next)) {
//                             if (next.equals(endWord)) {
//                                 return ans;
//                             }
//                             q.add(next);
//                             wordSet.remove(next);
//                         }
//                         curr.setCharAt(i, c);
//                     }
//                 }
//                 size--;
//             }
//         }
//         return 0;
//     }
// }
