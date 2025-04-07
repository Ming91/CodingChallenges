// Top Interview 150 Trie Q3
class Solution {
    class Node {
        Node[] next;
        boolean isEnd;
        int passCount;
        int endCount;
        String word;
        Node() {
            next = new Node[26];
            passCount = 0;
            endCount = 0;
            word = null;
        }
    }
    int m, n;
    void add(Node root, String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Node();
            }
            curr.passCount++;
            curr = curr.next[c - 'a'];
        }
        curr.passCount++;
        curr.endCount++;
        curr.isEnd = true;
        curr.word = word;
    }
    // boolean hasChildren()
    void search(char[][] board, List<String> ans, Node curr, int i, int j) {
        char c = board[i][j];
        if (c == '#') {
            return;
        }
        Node next = curr.next[c - 'a'];
        if (next == null) {
            return;
        }
        
        if (next.isEnd) {
            ans.add(next.word);
            next.word = null;
            next.isEnd = false;
            curr.passCount -= next.endCount;
            next.passCount -= next.endCount;
            next.endCount = 0;
        }
        board[i][j] = '#';
        if (i < m - 1) {
            search(board, ans, next, i + 1, j);
        }
        if (i > 0) {
            search(board, ans, next, i - 1, j);
        }
        if (j < n - 1) {
            search(board, ans, next, i, j + 1);
        }
        if (j > 0) {
            search(board, ans, next, i, j - 1);
        }
        board[i][j] = c;
        if (next.passCount == 0) {
            curr.next[c - 'a'] = null;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            add(root, word);
        }
        List<String> ans = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search(board, ans, root, i, j);
            }
        }
        return ans;
    }
}
// [Editorial]
//  Optimized Trie Backtracking. 
//  1. store word in the trie
//  2. after reached a word and added to ans, delete this word(make this node word=null, count = 0...)
//     this will not effect its child node.
//  3. if one node has no child after delete, then delete this node.
//  This will make sure no dulplicate search and no dulplicate in ans. And no need for a set to store ans. 

// [TODO]
// [Beat 99%]
//  Use a 3-length string dict set from board to check if we need to add curr word to the trie.
//  If curr word contains a 3-length substring that is not contained in the board, we can skip this word. 

// class Solution {
//     static int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//     public List<String> findWords(char[][] board, String[] words) {
//         //深搜board所有长度为3的子串，构成词典，把包含非法子串的word排除，压缩字典树。
//         Three three = new Three(board);
//         Trie trie = new Trie();
//         for (String word : words) {
//             if (three.check(word)) trie.insert(word);
//         }

//         List<String> ans = new ArrayList<>();
//         for (int i = 0; i < board.length; ++i) {
//             for (int j = 0; j < board[0].length; ++j) {
//                 dfs(board, trie, i, j, ans);
//             }
//         }

//         return ans;
//     }

//     public void dfs(char[][] board, Trie now, int i, int j, List<String> ans) {
//         if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;
//         if (!now.children.containsKey(board[i][j])) return;

//         char ch = board[i][j];
//         Trie nxt = now.children.get(ch);
//         if (nxt.word.length() > 0) {
//             ans.add(nxt.word);
//             nxt.word = "";
//         }

//         if (!nxt.children.isEmpty()) {
//             board[i][j] = '#';
//             for (int[] direct : directs) {
//                 dfs(board, nxt, i + direct[0], j + direct[1], ans);
//             }
//             board[i][j] = ch;
//         }

//         if (nxt.children.isEmpty()) now.children.remove(ch);
//     }
// }

// class Trie {
//     String word;
//     Map<Character, Trie> children;

//     public Trie() {
//         this.word = "";
//         this.children = new HashMap<>();
//     }

//     public void insert(String word) {
//         Trie cur = this;
//         for (int i = 0; i < word.length(); ++i) {
//             char c = word.charAt(i);
//             if (!cur.children.containsKey(c)) {
//                 cur.children.put(c, new Trie());
//             }
//             cur = cur.children.get(c);
//         }
//         cur.word = word;
//     }
// }

// class Three {//道生一，一生二，三生万物
//     static int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//     Set<String> dict;

//     public Three(char[][] board) {
//         dict = new HashSet<>();
//         char[] choose = new char[3];//长度定为3，时空开销适中。
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 dfs(board, i, j, 0, choose);
//             }
//         }
//     }

//     void dfs(char[][] board, int i, int j, int now, char[] choose) {
//         if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;
//         if (board[i][j] == '#') return;
//         char ch = board[i][j];
//         choose[now] = ch;
//         if (now == choose.length - 1) {
//             dict.add(String.valueOf(choose));
//         } else {
//             board[i][j] = '#';
//             for (int[] direct : directs) {
//                 dfs(board, i + direct[0], j + direct[1], now + 1, choose);
//             }
//             board[i][j] = ch;
//         }
//     }

//     static int[] checkPoint = {10, 3, 8, 5};//随便选几段检查即可，降低开销。

//     public boolean check(String word) {
//         int n = word.length();
//         for (int p : checkPoint) {
//             if (n >= p && !dict.contains(word.substring(p - 3, p))) return false;
//         }
//         return true;
//     }
// }

// [Ming] Backtracking with Trie, very slow. No optimization. 
// class Solution {
//     class Node {
//         Node[] next;
//         boolean isEnd;
//         Node() {
//             next = new Node[26];
//         }
//     }

//     static final int[] DIR = new int[] {0, -1, 0, 1, 0};

//     int m, n;
//     char[][] board;
//     void add(String word, Node root) {
//         Node curr = root;
//         for (char c : word.toCharArray()) {
//             if (curr.next[c - 'a'] == null) {
//                 curr.next[c - 'a'] = new Node();
//             }
//             curr = curr.next[c - 'a'];
//         }
//         curr.isEnd = true;
//     }
//     void dfs(Set<String> ans, boolean[] visited, int[] start, Node curr, String res) {
//         if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0] * n + start[1]]) {
//             return;
//         }
//         char c = board[start[0]][start[1]];
//         if (curr.next[c - 'a'] == null) {
//             return;
//         }
//         visited[start[0] * n + start[1]] = true;
//         res += c;
//         if (curr.next[c - 'a'].isEnd) {
//             ans.add(res);
//         }
//         for (int i = 0; i < 4; i++) {

//             dfs(ans, visited, new int[]{start[0] + DIR[i], start[1] + DIR[i + 1]}, curr.next[c - 'a'], res);
//         }
        
//         visited[start[0] * n + start[1]] = false;
        
//     }
//     public List<String> findWords(char[][] board, String[] words) {
//         Node root = new Node();
//         for (String word : words) {
//             add(word, root);
//         }
//         m = board.length;
//         n = board[0].length;
//         this.board = board;
//         Set<String> ans = new HashSet<>();
//         boolean[] visited = new boolean[m * n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 // Arrays.fill(visited, false);
//                 dfs(ans, visited, new int[]{i, j}, root, "");
//             }
//         }
//         return new ArrayList<>(ans);
//     }
// }
