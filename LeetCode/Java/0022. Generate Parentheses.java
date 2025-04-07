// Top Interview 150 Backtracking Q6
class Solution {
    int n;
    void backtrack(int left, int right, List<String> ans, char[] res) {
        if (left == 0 && right == 0) {
            ans.add(new String(res));
            return;
        }
        if (right > left) {
            res[2 * n - left - right] = ')';
            backtrack(left, right - 1, ans, res);
        }
        if (left > 0) {
            res[2 * n - left - right] = '(';
            backtrack(left - 1, right, ans, res);
        }
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        List<String> ans = new ArrayList<>();
        backtrack(n, n, ans, new char[n * 2]);
        return ans;
    }
}
