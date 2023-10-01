// Weekly Premium Oct 2023 W1
class Trie {
    class Node {
        Node[] next = new Node[26];
        int onPath;
        int endWith;
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for (char cc : word.toCharArray()) {
            int c = cc - 'a';
            if (curr.next[c] == null) {
                curr.next[c] = new Node();
            }
            curr = curr.next[c];
            curr.onPath++;
        }
        curr.endWith++;
    }
    
    public int countWordsEqualTo(String word) {
        Node curr = root;
        for (char cc : word.toCharArray()) {
            int c = cc - 'a';
            if (curr.next[c] == null) {
                return 0;
            }
            curr = curr.next[c];
        }
        return curr.endWith;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node curr = root;
        for (char cc : prefix.toCharArray()) {
            int c = cc - 'a';
            if (curr.next[c] == null) {
                return 0;
            }
            curr = curr.next[c];
        }
        return curr.onPath;
    }
    
    public void erase(String word) {
        
        Node curr = root;
        for (char cc : word.toCharArray()) {
            int c = cc - 'a';
            curr = curr.next[c];
            curr.onPath--;
        }
        curr.endWith--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
