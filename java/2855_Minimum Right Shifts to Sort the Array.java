// Biweekly Contest 113 Q1
class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int[] nn = new int[n * 2];
        int idx = 0;
        for (int num : nums) {
            nn[idx + n] = num;
            nn[idx++] = num;
        }
        idx = 1;
        while (idx < n * 2) {
            if (nn[idx] <= nn[idx - 1]) {
                break;
            }
            idx++;
        }
        int l = idx++;
        while (idx < n * 2) {
            if (nn[idx] <= nn[idx - 1]) {
                break;
            }
            idx++;
        }
        // System.out.println(l + "," + idx);
        return idx - l == n ? n - l : -1;
    }
}
