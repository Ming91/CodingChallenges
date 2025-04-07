// LeetCode 75 Trie Q2
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) { 
        List<List<String>> ans = new ArrayList<>();
        int n = products.length;
        int left = 0, right = n - 1;
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            int l = left, r = right;
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) {
                l++;
            }
            while (r >= l && (products[r].length() <= i || products[r].charAt(i) != c)) {
                r--;
            }
            left = l;
            right = r;
            System.out.println(l + "," + r);
            List<String> res = new ArrayList<>();
            for (int j = l; j <= r && j < l + 3; j++) {
                res.add(products[j]);
            }
            ans.add(res);
        }
        return ans;
    }
}
// naive sort + linear search faster
// but binary search has smaller O()
// class Solution {
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//         List<List<String>> ans = new ArrayList<>();
//         String currStr = "";
//         int n = products.length;
//         int left = 0, right = n;
//         int count = 3;
//         Arrays.sort(products);
//         for (int i = 0; i < searchWord.length(); i++) {
//             char c = searchWord.charAt(i);
//             if (count > 0) {
//                 currStr += c;
//                 // binary search left index
//                 int l = left, r = right;
//                 while (l < r) {
//                     int mid = (l + r) >> 1;
//                     if (products[mid].compareTo(currStr) < 0) {

//                     // cant use this condition, will skip result
//                     //  eg. ["bags","baggage","banner","box","cloths"]
//                     //      "bags"
//                     //  will cause left to "box" and still go right

//                     // if (i >= products[mid].length() && products[mid].charAt(i) < c) {
//                         l = mid + 1;
//                     } else {
//                         r = mid;
//                     }
//                 }
//                 left = l;
//             }
            
//             // two binary search version

//             // r = right;
//             // while (l < r) {
//             //     int mid = (l + r) >> 1;
//             //     if (products[mid].charAt(i) <= c) {
//             //         l = mid + 1;
//             //     } else {
//             //         r = mid;
//             //     }
//             // }
//             // right = l;

//             List<String> res = new ArrayList<>();

//             // two binary search version
            
//             // for (int j = left; j < right && j < left + 3; j++) {
//             //     res.add(products[j]);
//             // }
//             for (int j = left; j < left + count && j < n; j++) {
//                 if (i >= products[j].length() || products[j].charAt(i) != c) {
//                     count = j - left;
//                     break;
//                 } else {
//                     res.add(products[j]);
//                 }
                
//             }
//             ans.add(res);
//         }
//         return ans;
//     }
// }


// Trie Version
// class Solution {
//     class TrieNode {
//         TrieNode[] next;
//         boolean isEnd;
//         TrieNode() {
//             next = new TrieNode[R];
//         }
//         public boolean contains(char c) {
//             return next[c - 'a'] != null;
//         }
//         public TrieNode get(char c) {
//             return next[c - 'a'];
//         }
//         public void put(char c) {
//             next[c - 'a'] = new TrieNode();
//         }
//         public void setEnd() {
//             isEnd = true;
//         }
//         public boolean isEnd() {
//             return isEnd;
//         }
//     }
    
//     static final int R = 26;
//     TrieNode prev;
    
//     public void insert(TrieNode root, String word) {
//         TrieNode curr = root;
//         int i = 0, n = word.length();
//         char[] ch = word.toCharArray();
//         for (; i < n; i++) {
//             char c = ch[i];// word.charAt(i);
//             if (!curr.contains(c)) {
//                 curr.put(c);
//             }
//             curr = curr.get(c);
//         }
        
//         curr.setEnd();
//         // len = Math.max(len, n);
//     }
//     void genResult(TrieNode curr, List<String> res, String str) {
//         if (curr == null) {
//             return ;
//         }
        
//         if (res.size() == 3) {
//             return ;
//         }

//         if (curr.isEnd()) {
//             res.add(str);
//         }
        
//         for (char i = 'a'; i <= 'z'; i++) {
//             if (curr.contains(i)) {
//                 genResult(curr.get(i), res, str + i);
//             }
//         }
//         return ;
//     }
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//         TrieNode root = new TrieNode();
//         for (String product : products) {
//             insert(root, product);
//         }
//         prev = root;
//         List<List<String>> ans = new ArrayList<>();
//         String sb = "";
//         for (int i = 0; i < searchWord.length(); i++) {
//             List<String> result = new ArrayList<>();
//             if (prev == null) {
//                 ans.add(result);
//                 continue ;
//             }
//             sb += searchWord.charAt(i);
//             prev = prev.get(searchWord.charAt(i));
//             genResult(prev, result, sb);
//             ans.add(result);
//         }
//         return ans;
//     }
// }
