class Solution {
    Trie trie;
    String s;
    List<String> wordDict;
    int n;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.trie = new Trie();
        this.s = s;
        this.wordDict = wordDict;
        this.n = s.length();

        buildTrie(trie, wordDict);

        List<List<Integer>> ansLists = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(ansLists, currList, 0);

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : ansLists) {
            // System.out.println(list);
            for (int i : list) {
                sb.append(wordDict.get(i));
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);

            ans.add(sb.toString());
            sb.setLength(0);
        }

        return ans;
    }

    void backtrack(List<List<Integer>> ansLists, List<Integer> currList, int start) {
        // [GPT] Better method to avoid creating a new list every time
        if (start == n) {
            ansLists.add(new ArrayList<>(currList));
            return;
        }
        List<Integer> res = trie.search(s, start);
        for (int i : res) {
            currList.add(i);
            backtrack(ansLists, currList, start + wordDict.get(i).length());
            currList.remove(currList.size() - 1); // Backtrack
        }
    }

    void buildTrie(Trie trie, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            trie.insert(wordDict.get(i), i);
        }
    }

    class Trie {
        class TrieNode {
            int isEnd;
            TrieNode[] next;

            TrieNode() {
                this(-1);
            }

            TrieNode(int isEnd) {
                this.isEnd = isEnd;
                next = new TrieNode[26];
            }
        }

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String s, int idx) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (curr.next[i] == null) {
                    curr.next[i] = new TrieNode();
                }
                curr = curr.next[i];
            }
            curr.isEnd = idx;
        }

        List<Integer> search(String s, int start) {
            List<Integer> res = new ArrayList<>();
            TrieNode curr = root;
            for (int i = start; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (curr.next[c] == null) {
                    break;
                }
                curr = curr.next[c];
                if (curr.isEnd >= 0) {
                    res.add(curr.isEnd);
                }
            }
            return res;
        }

    }
}