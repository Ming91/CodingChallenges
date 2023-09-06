// Daily Challenge 08/23/2023
class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int max = 0, maxC = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                maxC = i;
            }
        }
        if (max > (n + 1) / 2) {
            return "";
        }
        char[] ch = new char[n];
        int i = 0;
        count[maxC] = 0;
        for (int j = 0; j < max; j++) {
            ch[i] = (char) (maxC + 'a');
            i += 2;
        }
        for (int j = 0; j < 26; j++) {
            if (count[j] == 0) {
                continue;
            }
            while (count[j] > 0) {
                if (i >= n) {
                    i = 1;
                }
                ch[i] = (char) (j + 'a');
                i += 2;
                count[j]--;
            }
        }
        return new String(ch);
    }
}
// better idea:
//  don't need to sort, just store the max one

// naive idea:
// use backtrack to gen a suitable result

// class Solution {
//     void backtrack(int[][] count, int idx, char[] curr, int invalid) {
//         if (idx == curr.length) {
//             return ;
//         }
//         for (int i = 0; i < 26; i++) {
//             if (count[i][0] > 0 && i != invalid) {
//                 count[i][0]--;
//                 curr[idx] = (char) (count[i][1] + 'a');
//                 backtrack(count, idx + 1, curr, i);
//                 if (curr[curr.length - 1] > 0) {
//                     return ;
//                 }
//                 count[i][0]++;
//             }
//         }
//         return ;
//     }
//     public String reorganizeString(String s) {
//         int[][] count = new int[26][2];
//         int n = s.length();
//         for (int i = 0; i < 26; i++) {
//             count[i][1] = i;
//         }
//         for (char c : s.toCharArray()) {
//             count[c - 'a'][0]++;
//         }
//         Arrays.sort(count, (a, b) -> (b[0] - a[0]));
//         if (count[0][0] > (n + 1) / 2) {
//             return "";
//         }
//         int i = 0, j = 1;
//         char[] ch = new char[n];
//         backtrack(count, 0, ch, -1);
//         return new String(ch);
//     }
// }
// aba
// aabbcc
