// Top Interview 150 Backtracking Q5
class Solution {
    int ans;
    boolean check(int[] res, int curr, int cand) {
        if (curr == 0) {
            return true;
        }
        // Rules below included in loop check. But runs faster if prechecked here.
        if (res[curr - 1] >= cand - 1 && res[curr - 1] <= cand + 1) {
            return false;
        }
        for (int i = 0; i < curr; i++) {
            if (cand == res[i] || Math.abs(cand - res[i]) == curr - i) {
                return false;
            }
        }
        return true;
    }
    void backtrack(int[] res, int curr) {
        if (curr == res.length) {
            ans++;
            // System.out.println(Arrays.toString(res));
            return;
        }
        for (int i = 0; i < res.length; i++) {
            if (check(res, curr, i)) {
                res[curr] = i;
                backtrack(res, curr + 1);
            }
        }
    }
    public int totalNQueens(int n) {
        int[] res = new int[n];
        ans = 0;
        backtrack(res, 0);
        return ans;
    }
}
