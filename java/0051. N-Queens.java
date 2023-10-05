// Related Problem of 52. N-Queens II
class Solution {
    boolean check(int[] res, int curr, int cand) {
        if (curr == 0) {
            return true;
        }
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
    List<String> decode(int[] res) {
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.setLength(0);
            sb.append(".".repeat(i)).append("Q").append(".".repeat(res.length - i - 1));
            l.add(sb.toString());
        }
        return l;
    }
    void backtrack(int[] res, int curr, List<List<String>> ans) {
        if (curr == res.length) {
            // System.out.println(Arrays.toString(res));
            ans.add(decode(res));
            return;
        }
        for (int i = 0; i < res.length; i++) {
            if (check(res, curr, i)) {
                res[curr] = i;
                backtrack(res, curr + 1, ans);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(new int[n], 0, ans);
        return ans;
    }
}
