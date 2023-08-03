// Daily Challenge 08/03/2023
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
    void backtrack(List<String> ans, char[] ch, int idx, char[] curr) {
        if (idx == ch.length) {
            ans.add(new String(curr));
            return ;
        }
        for (char letter : PAD[ch[idx] - '2']) {
            curr[idx] = letter;
            backtrack(ans, ch, idx + 1, curr);
        }
        return ;
    }
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        backtrack(ans, digits.toCharArray(), 0, new char[digits.length()]);
        return ans;
    }
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
