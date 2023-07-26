// Weekly Contest 355 Q4
class Solution {
    int getMap(List<Integer> parent, String s, int[] dp, int idx) {
        if (dp[idx] < 0) {
            dp[idx] = 0;
            dp[idx] = getMap(parent, s, dp, parent.get(idx)) ^ (1 << (s.charAt(idx) - 'a'));
        }
        return dp[idx];
    }
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        int dp[] = new int[n];
        long ans = 0;
        Map<Integer, Integer> mapCount = new HashMap<>();
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int currMap = getMap(parent, s, dp, i);
            // if map are same, two points can form a path;
            int evenCount = mapCount.getOrDefault(currMap, 0);
            ans += evenCount;
            for (int j = 0; j < 26; j++) {
                // if two points have at exact one diff, can form a path
                ans += mapCount.getOrDefault(currMap ^ (1 << j), 0);
            }
            mapCount.put(currMap, evenCount + 1);
        }
        return ans;
    }
}

// totally no idea, just learn solutions
//  1. count parity of char in path root -> current
//  2. add ans if any pair of path has at most 1 odd char

// notice:
//  1. 结果要的是"重组"后回文,即至多有1个odd的char就行
//  2. 是边上的char,不是点上有char,因此root->lca 与lca->child没有重复
//      如果是点上,还要考虑lca自己的问题

// approach
//  1. 用26bitmap存各点的奇偶情况
//  2. 然后将bitmap存到hashmap里面, 方便计数
//  3. 例如到了点i, 计算其bitmap,可以回溯根据其parent来找,这样可以将parent的bitmap存为dp[],减少计算
//  4. 点i的bitmap得出, 如果hashmap里面此map有count个, 则点i和这些点均可以组成, 因此+count
//  5. 对于点i的, 如果与点j至多有1位不同, 即一个char奇偶的奇偶不同,则组成的也至多有1个odd,符合, 也要加上
