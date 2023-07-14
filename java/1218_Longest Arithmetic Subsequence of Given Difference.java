class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int ans = 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i : arr) {
            int d = dp.getOrDefault(i - difference, 0) + 1;
            // 官解改进：
            // 不用比较，从前到后，已存好最长，直接put
            dp.put(i, d);
            ans = Math.max(ans, d);
            // if (d > dp.getOrDefault(i, 0)) {
            //     dp.put(i, d);
            //     ans = ans < d ? d : ans;
            // }
        }
        return ans;
    }
}
// beat 99%的方法：
// 不用hashmap， 找到 arr的min max， 映射到数组，然后来做
