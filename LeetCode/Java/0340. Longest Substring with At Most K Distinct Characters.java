class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        if (s.length() <= 1 || s.length() <= k) {
            return s.length();
        }
        int left = 0;
        int right = left + 1;
        int ans = 1;
        char[] cArr = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        // just use map to save mem
        // Set<Character> dist = new HashSet<>();
        freq.put(cArr[left], 1);
        while (left <= right && right < cArr.length) {
            Character c = cArr[right];
            ad(c, freq);
            right++;
            // shift left to size 'ans'
            // no need to shrink to size that is valid
            while (ans < right - left && freq.size() > k) {
                Character r = cArr[left];
                rm(r, freq);
                left++;
            }
            if (freq.size() <= k) {
                ans = right - left;
            }
        }
        return ans;
    }
    private void ad(Character c, Map<Character, Integer> freq) {
        int f = freq.getOrDefault(c, 0) + 1;
        freq.put(c, f);
        //dist.add(c);
    }
    private void rm(Character c, Map<Character, Integer> freq) {
        int f = freq.get(c) - 1;
        if (f == 0) {
            freq.remove(c);
        } else {
            freq.put(c, f);
        }
    }
}
// 上面是自己写的官解思路,已经有ans长度的答案了
// 不用左边缩到valid sub为止,只用缩到ans长度,不valid也无所谓,如果left到right大于ans且valid,更新ans

// beat 99%的:
// 用char[]和int[]来存, 替代map

// naive sliding window O(n) with O(n)
// class Solution {
//     public int lengthOfLongestSubstringKDistinct(String s, int k) {
//         if (k == 0) {
//             return 0;
//         }
//         if (s.length() <= 1 || s.length() <= k) {
//             return s.length();
//         }
//         int left = 0;
//         int right = left + 1;
//         int ans = 1;
//         char[] cArr = s.toCharArray();
//         Map<Character, Integer> freq = new HashMap<>();
//         Set<Character> dist = new HashSet<>();
//         freq.put(cArr[left], 1);
//         dist.add(cArr[left]);
//         while (left <= right && right < cArr.length) {
//             Character c = cArr[right];
//             ad(c, freq, dist);
//             //right++;
//             if (dist.contains(c) || dist.size() < k) {
//                 dist.add(c);
//                 right++;
//                 if (right - left > ans) {
//                     ans = right - left;
//                 }
//                 continue;
//             }
//             while (left <= right && dist.size() >= k) {
//                 Character r = cArr[left];
//                 rm(r, freq, dist);
//                 left++;
//             }
//             dist.add(c);
//             right++;
//             if (right - left > ans) {
//                 ans = right - left;
//             }
//         }
//         return ans;
//     }
//     private void ad(Character c, Map<Character, Integer> freq, Set<Character> dist) {
//         int f = freq.getOrDefault(c, 0) + 1;
//         freq.put(c, f);
//         //dist.add(c);
//     }
//     private void rm(Character c, Map<Character, Integer> freq, Set<Character> dist) {
//         int f = freq.get(c) - 1;
//         freq.put(c, f);
//         if (f == 0) {
//             dist.remove(c);
//         }
//     }
// }
