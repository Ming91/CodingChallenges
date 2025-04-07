// LeetCode 75 Backtracking Q1
// Daily Challenge 08/03/2023
// Top Interview 150 Backtracking Q1
class Solution {
    static char[][] PAD = new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    int n;
    // 10/04/2023 Impl
    // void backtrack(List<String> ans, char[] d, String res) {
    //     if (res.length() == n) {
    //         if (n != 0) {
    //             ans.add(res);
    //         }
    //         return;
    //     }
    //     int i = res.length();
    //     for (char c : PAD[d[i] - '2']) {
    //         backtrack(ans, d, res + c);
    //     }
    // }
    // public List<String> letterCombinations(String digits) {
    //     n = digits.length();
    //     List<String> ans = new ArrayList<>();
    //     backtrack(ans, digits.toCharArray(), "");
    //     return ans;
    // }
    // 08/22/2023 impl
    void backtrack(List<String> ans, int[] d, int idx, char[] curr) {
        if (idx == d.length) {
            ans.add(new String(curr));
            return ;
        }
        for (char c : PAD[d[idx]]) {
            curr[idx] = c;
            backtrack(ans, d, idx + 1, curr);
        }
        return ;
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = digits.charAt(i) - '2';
        }

        backtrack(ans, d, 0, new char[n]);
        return ans;
    }

    // 08/03/2023 impl
    // void backtrack(List<String> ans, char[] ch, int idx, char[] curr) {
    //     if (idx == ch.length) {
    //         ans.add(new String(curr));
    //         return ;
    //     }
    //     for (char letter : PAD[ch[idx] - '2']) {
    //         curr[idx] = letter;
    //         backtrack(ans, ch, idx + 1, curr);
    //     }
    //     return ;
    // }
    // public List<String> letterCombinations(String digits) {
    //     if (digits.isEmpty()) {
    //         return new ArrayList<>();
    //     }
    //     List<String> ans = new ArrayList<>();
    //     backtrack(ans, digits.toCharArray(), 0, new char[digits.length()]);
    //     return ans;
    // }
}

// ugly simulation
// class Solution {
//     static char[][] PAD = new char[][] {
//         {'a', 'b', 'c'},
//         {'d', 'e', 'f'},
//         {'g', 'h', 'i'},
//         {'j', 'k', 'l'},
//         {'m', 'n', 'o'},
//         {'p', 'q', 'r', 's'},
//         {'t', 'u', 'v'},
//         {'w', 'x', 'y', 'z'}
//     };
//     public List<String> letterCombinations(String digits) {
//         List<String> ans = new ArrayList<>();
//         for (char digit : digits.toCharArray()) {
//             List<String> temp = new ArrayList<>(ans);
//             ans.clear();
//             for (char letter : PAD[digit - '2']) {
//                 for (String s : temp) {
//                     ans.add(s + letter);
//                 }
//                 if (temp.isEmpty()) {
//                     ans.add(Character.toString(letter));
//                 }
//             }
//         }
//         return ans;
//     }
// }
