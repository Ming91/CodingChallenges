// Daily Question 09/11/2023
class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        int ans = 0;
        int maxAllowed = count[25] - 1;
        // System.out.println(Arrays.toString(count));

        // [editorial] clear structure.
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            if (count[i] > maxAllowed) {
                ans += count[i] - maxAllowed;
                count[i] = maxAllowed;
            }
            maxAllowed = Math.max(0, count[i] - 1);
        }

        // [Ming] self impl version.
        // for (int i = 24; i >= 0 && count[i] > 0; i--) {
        //     if (count[i] == prev) {
        //         ans += prev;
        //         len++;
        //     } else {
        //         for (int j = prev - 1; j > count[i] && len > 0; j--) {
        //             ans -= j;
        //             len--;
        //         }
        //         prev = count[i];
        //     }
        // }
        // for (int j = prev - 1; j > 0 && len > 0; j--) {
        //     ans -= j;
        //     len--;
        // }
        return ans;
    }
}
