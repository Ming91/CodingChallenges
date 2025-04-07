// Biweekly Contest 112 Q4
class Solution {
    
    public static long calculate(int n, int k) {
        if (k < 0 || k > n) {
            return 0; // Invalid input
        }

        if (k == 0 || k == n) {
            return 1; // nC0 and nCn are both 1
        }

        k = Math.min(k, n - k); // Use smaller k value for efficiency
        long result = 1;

        for (int i = 1; i <= k; i++) {
            result = (result * (n - i + 1)) % 1_000_000_007;
            result = (result / i) % 1_000_000_007;
        }

        return result;
    }
    
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        long[] count = new long[26];
        if (k > 26) {
            return 0;
        }
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        long ans = 1;
        long end = count[26 - k];
        int n = 0, m = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[i] > end) {
                ans = (ans * count[i]) % 1_000_000_007;
                m++;
            } else {
                if (count[i] == end) {
                    n++;
                } else {
                    break;
                }
            }
        }
        // n choese k - m
        long reps = calculate(n, k - m);
        for (int i = 0; i < k - m; i++) {
            ans = (ans * end) % 1_000_000_007;
        }
        ans = (ans * reps) % 1_000_000_007;
        return (int)ans;
    }
}
