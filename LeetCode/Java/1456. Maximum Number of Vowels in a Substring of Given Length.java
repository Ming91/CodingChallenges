// LeetCode 75 Sliding Window Q2
class Solution {
    // static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    static int[] DICT = new int[128];
    static {
        DICT['a'] = 1;
        DICT['e'] = 1;
        DICT['i'] = 1;
        DICT['o'] = 1;
        DICT['u'] = 1;
    } 
    public int maxVowels(String s, int k) {
        byte[] ch = s.getBytes();
        int n = ch.length;
        // boolean[] p = new boolean[n];
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += DICT[ch[i]];            
        }
        int max = count;
        for (int i = k; i < n; i++) {
            count += DICT[ch[i]] - DICT[ch[i - k]];
            // 不加更快...
            // if (count == k) {
            //     return k;
            // }
            max = Math.max(max, count);
        }
        return max;
    }
}
