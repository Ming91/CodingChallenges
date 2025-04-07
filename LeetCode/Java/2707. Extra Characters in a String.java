// Daily Question 09/02/2023
class Solution {
    class TrieNode {
        TrieNode[] next;
        boolean isWord;
        TrieNode() {
            next = new TrieNode[26];
            isWord = false;
        }
    }

    void insert(TrieNode root, char[] ch) {
        TrieNode curr = root;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isWord = true;
    }

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Integer[] dp = new Integer[n + 1];
        TrieNode root = new TrieNode();
        int min = 51, max = 0;
        for (String d : dictionary) {
            insert(root, d.toCharArray());
            // min = Math.min(min, d.length());
            // max = Math.max(max, d.length());
        }
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] == null || (i > 0 && dp[i] > dp[i - 1] + 1)) {
                dp[i] = dp[i - 1] + 1;
            }
            // [Ming] Version 1: no Trie
            // for (String d : dictionary) {
            //     int j = i + d.length();
            //     if (j <= n && s.substring(i, j).equals(d)) {
            //         if (dp[j] == null) {
            //             dp[j] = dp[i];
            //         } else {
            //             dp[j] = Math.min(dp[j], dp[i]);
            //         }
            //     }
            // }

            // Verion 2: Trie
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (curr.next[c - 'a'] == null) {
                    break;
                } 
                curr = curr.next[c - 'a'];
                if (curr.isWord) {
                    if (dp[j + 1] == null) {
                        dp[j + 1] = dp[i];
                    } else {
                        dp[j + 1] = Math.min(dp[j + 1], dp[i]);
                    }
                }
            }
        }
        return dp[n];
    }
}
