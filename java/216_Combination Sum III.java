// LeetCode 75 Backtracking Q2
class Solution {
    boolean[] used;
    void backtrack(List<List<Integer>> ans, int k, int n, int start, int[] curr) {
        if (k == 0 && n == 0) {
            List<Integer> res = new ArrayList<>();
            for (int i : curr) {
                res.add(i);
            }
            ans.add(res);
            return ;
        }
        if (k == 0 && n > 0) {
            return ;
        }
        for (int i = start; i <= 9 && i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                curr[curr.length - k] = i;
                backtrack(ans, k - 1, n - i, i + 1, curr);
                used[i] = false;
            }
        }
        return ;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        used = new boolean[10];
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, k, n, 1, new int[k]);
        return ans;
    }
}
