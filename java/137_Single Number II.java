class Solution {
    public int singleNumber(int[] nums) {
        int[] bucket = new int[32];
        int ans = 0;
        final int k = 3;
        Arrays.fill(bucket, 0);
        for (int i : nums) {
            int number = i;
            for (int j = 31; j >=0; j--) {
                bucket[j] += (number & 1);
                number = number >>> 1;
            }
        }
        for (int j = 0; j < 32; j++) {
            ans =ans | ((bucket[j] % k == 1 ? 1 : 0) << (31 - j));
        }
        return ans;
    }
}
