// Top Interview 150 Trie Q2
class WordDictionary {
    class Node {
        Node[] next;
        boolean isEnd;
        Node() {
            next = new Node[26];
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Node();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }
    private boolean searchHelper(String word, Node start, int idx) {
        if (start == null) {
            return false;
        }
        if (idx == word.length()) {
            return start.isEnd;
        }
        char c = word.charAt(idx);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchHelper(word, start.next[i], idx + 1)) {
                    return true;
                }
            }
            return false;
        }
        return searchHelper(word, start.next[c - 'a'], idx + 1);
    }
    // private boolean searchWithNode(String word, Node start) {
    //     Node curr = start;
    //     for (int i = 0; i < word.length(); i++) {
    //         char c = word.charAt(i);
    //         if (c == '.') {
    //             boolean res = false;
    //                 for (int j = 0; j < 26 && res == false; j++) {
    //                     res |= curr.next[j] == null ? false : searchWithNode(word.substring(i + 1, word.length()), curr.next[j]);
    //                 }
                
    //             return res;
    //         }
    //         if (curr.next[c - 'a'] == null) {
    //             return false;
    //         }
    //         curr = curr.next[c - 'a'];
    //     }
    //     return curr.isEnd;
    // }
    public boolean search(String word) {
        return searchHelper(word, root, 0);
        // return searchWithNode(word, root);
    }
}
// [Beat 99%]
//  Use idx parameter to avoid copy string in recursion. 

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
