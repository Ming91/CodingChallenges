// Weekly Contest 360 Q3
class Solution {
    public int minOperations(List<Integer> nums, int tt) {
        int[] t = new int[32];
        int target = tt;
        int[] count = new int[32];
        int upper = 31;
        int i = 0;
        while (target > 0) {
            t[i++] = target & 1;
            target = target >> 1;
        }
        for (int num : nums) {
            int curr = num;
            int k = -1;
            while (curr > 0) {
                curr = curr >> 1;
                k++;
            }
            if (num >= tt && num < (1L << upper)) {
                upper = k;
            }
            count[k]++;
        }
        // Collections.sort(nums);
        // System.out.println(nums);
        // for (i = 0; i < 31; i++) {
        //     System.out.println(count[i]);
        // }
        int ans = 0;
        int remain = 0;
        int left = 32;
        int right = -1;
        for (i = 0; i < 31; i++) {
            if (t[i] == 1) {
                if (count[i] == 0) {
                    left = i;
                    if (right < 0) {
                        right = i;
                    }
                } else {
                    t[i] = 0;
                    count[i]--;
                }
            }
            if (count[i] > 0 && left < i) {
                count[i + 1] += (count[i] - 1) >> 1;
                count[i] = 1;
                left = 32;
            } else {
                count[i + 1] += count[i] >> 1;
            }
        }
        if (right < 0) {
            return 0;
        }
        if (left < 32 && upper == 31) {
            return -1;
        }
        int f = upper;
        for (i = upper; i >= right; i--) {
            if (t[i] == 1) {
                ans += f - i;
                f = i;
            }
            if (count[i] > 0) {
                f = i;
            }
        }
        return ans;
    }
}
