// Daily Question 09/08/2023
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> l1 = new ArrayList<>();
            l1.add(List.of(1));
            return l1;
        }
        List<List<Integer>> ans = generate(numRows - 1);
        List<Integer> prev = ans.get(numRows - 2);
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        // simple version
        // for (int i = 1; i < numRows - 1; i++) {
        //     curr.add(prev.get(i - 1) + prev.get(i));
        // }
        // faster version: only calc half of row
        int mid = (numRows + 1) / 2;
        for (int i = 1; i < mid; i++) {
            curr.add(prev.get(i) + prev.get(i - 1));
        }
        for (int i = mid + 1; i <= numRows - 1; i++) {
            curr.add(curr.get(numRows - i));
        }
        curr.add(1);
        ans.add(curr);
        return ans;
    }
}
