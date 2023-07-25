// Biweekly Contest 109 Q3

class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[] score = new long[2];         // dp score for even and odd
        int curr = nums[0] & 1;             // Parity identifier 0: even 1: odd
        long seqSum = 0;                    // Sum of consecutive series of the same parity
        long ans = 0;
        score[curr] = nums[0];
        score[1 - curr] = nums[0] - x;
        for (int i = 1; i < n + 1; i++) {
            if (i < n && (nums[i] & 1) == curr) {
                // if same parity, add to seqSum
                seqSum += nums[i];
            } else {
                // if parity changed, compare two scores
                score[curr] = Math.max(score[curr] + seqSum, score[1 - curr] + seqSum - x);
                ans = Math.max(ans, score[curr]);
                curr = 1 - curr;
                if (i < n) {
                    seqSum = nums[i];
                }
                
            }
        }
        return ans;
    }
}
