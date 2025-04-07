// Top Interview 150 Backtracking Q4
class Solution {
    void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> res, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            res.add(candidates[i]);
            backtrack(candidates, target - candidates[i], ans, res, i);
            res.remove(res.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
}
