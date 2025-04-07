// Top Interview 150 Trie Q1
// LeetCode 75 Trie Q1

// Top Interview 150 10/03/2023 Impl
class Trie {
    class Node {
        Node[] next;
        boolean isEnd;
        Node() {
            next = new Node[26];
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Node();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            }
            curr = curr.next[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            }
            curr = curr.next[c - 'a'];
        }
        return true;
    }
}

// LeetCode 75 Impl
// class Trie {
//     class TrieNode {
//         static final int R = 26;
//         // char val;
//         boolean isEnd;
//         TrieNode[] next;
        
//         public TrieNode() {
//             next = new TrieNode[R];
//         }
//         public boolean containsKey(char c) {
//             return next[c - 'a'] != null;
//         }
//         public TrieNode get(char c) {
//             return next[c - 'a'];
//         }
//         public void put (char c, TrieNode node) {
//             next[c - 'a'] = node;
//         }
//         public void setEnd() {
//             isEnd = true;
//         }
//         public boolean isEnd() {
//             return isEnd;
//         }
//     }

//     TrieNode root;
//     int len;
//     public Trie() {
//         root = new TrieNode();
//         len = 0;
//     }
    
//     public void insert(String word) {
//         TrieNode curr = root;
//         int i = 0, n = word.length();
//         char[] ch = word.toCharArray();
//         for (; i < n; i++) {
//             char c = ch[i];// word.charAt(i);
//             if (!curr.containsKey(c)) {
//                 break;
//             }
//             curr = curr.get(c);
//         }
//         for (; i < n; i++) {
//             char c = ch[i];// word.charAt(i);
//             curr.put(c, new TrieNode());
//             curr = curr.get(c);
//         }
        
//         curr.setEnd();
//         len = Math.max(len, n);
//     }
    
//     public boolean search(String word) {
//         TrieNode curr = root;
//         int n = word.length();
//         char[] ch = word.toCharArray();
//         if (n > len) {
//             return false;
//         }

//         for (int i = 0; i < n; i++) {
//             char c = ch[i];// word.charAt(i);
//             if (!curr.containsKey(c)) {
//                 return false;
//             }
//             curr = curr.get(c);
//         }
//         return curr.isEnd();
//     }
    
//     public boolean startsWith(String word) {
        
//         TrieNode curr = root;
//         int n = word.length();
//         char[] ch = word.toCharArray();
//         if (n > len) {
//             return false;
//         }

//         for (int i = 0; i < n; i++) {
//             char c = ch[i];// word.charAt(i);
//             if (!curr.containsKey(c)) {
//                 return false;
//             }
//             curr = curr.get(c);
//         }
//         return true;
//     }
// }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
