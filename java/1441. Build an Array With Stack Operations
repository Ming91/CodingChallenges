// Daily Question 11/03/2023
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int prev = 0;
        for (int num : target) {
            for (int i = prev + 1; i < num; i++) {
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
            prev = num;
        }
        return ans;
    }
}
