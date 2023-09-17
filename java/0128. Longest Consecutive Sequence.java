// Top Interview 150 Hashmap Q10
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int k = num;
            int res = 0;
            while (set.contains(k)) {
                res++;
                k++;
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
// [Editorial]
// if (set.contains(num - 1)) continue;
// brilliant idea!
