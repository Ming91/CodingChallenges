// Top Interview 150 Intervals Q1
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int l = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            sb.append(l);
            if (l != nums[i]) {
                sb.append("->")
                  .append(nums[i]);
            }
            ans.add(sb.toString());
            sb.setLength(0);
            i++;
        }
        return ans;
    }
}
