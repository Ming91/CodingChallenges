// Daily Question 09/26/2023
class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Integer[] lastIdx = new Integer[26];
        boolean[] isAdded = new boolean[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        // System.out.println(Arrays.toString(lastIdx));
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (isAdded[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.getLast() > c && lastIdx[stack.getLast()] > i) {
                isAdded[stack.removeLast()] = false;
            }
            stack.addLast(c);
            isAdded[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int c : stack) {
            sb.append((char)(c + 'a'));
        }
        return sb.toString();
    }
}
// [Editorial] 
//  Use monotonic stack with lastIdx of each char. 
//  If char already added, skip. 
//  If char in stack larger than curr and has larger lastIdx than current idx, pop out. 
//  **Remember compare lastIdx with i, rather than lastIdx[curr].
//  eg. "cdadabcc", this will cause first a can't pop first d, since last a is later than last d. 
//  The rule means, the poped char still have chance later. 


// [Editorial] recursive Solution
//  Very intuitive, find leftmost char that no duplicates on its right. 
//  eg. aabbccaabb, second c is the first leftmost. 
//  For such leftmost char, smaller char on its left should add to string now, 
//  since we need order to be small so smaller should be placed before the last one of this c.
//  After placed smallest char on the left, recursively run the program on the remain string on the 
//  right of the smallest char.
//  And the added char should be removed in the remaining string. 

// class Solution {
//     public String smallestSubsequence(String s) {
//         int[] count = new int[26];
//         int n = s.length();
//         if (n == 0) {
//             return "";
//         }
//         for (int i = 0; i < n; i++) {
//             count[s.charAt(i) - 'a']++;
//         }
//         int pos = 0;
//         for (int i = 0; i < n; i++) {
//             if (s.charAt(pos) > s.charAt(i)) {
//                 pos = i;
//             }
//             if (--count[s.charAt(i) - 'a'] == 0) {
//                 break;
//             }
//         }
//         return "" + s.charAt(pos) + smallestSubsequence(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
//     }
// }
