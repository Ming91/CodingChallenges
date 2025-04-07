class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }
        // dp[i] = <diff, len>
        Map<Integer, Integer>[] dp = new HashMap[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap();
            dp[i].put(0, 1);
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                if (max < len) {
                    max = len;
                }
                dp[i].put(diff, len);
            }
        }

        return max;

    }
}
/**
    dp[i] i处的各个diff的串的长度的map
    因为nums[i] <=500, 可行
 */
    
//
/*  以下想法错误，每个nums[i]的任意长度的串都有可能是结果的子串。
    只存i处的最优并不正确。
    //last[i] last element of longest arith subseq
    prev[i] prev ele list of ~
    ans[i] len of ~

    n[i] - n[j] == n[j] - prev[j]
        ans[i] < ans[j] + 1
            prev[j].clear()
            prev[i].add(j);
            ans[i] = ans[j]+1;
        ans[i] == ans[j] + 1
            prev[i].add(j);

 */
