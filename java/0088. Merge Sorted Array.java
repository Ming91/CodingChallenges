// Top Interview 150 Array / String Q1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // for (int i = 0; i < n; i++) {
        //     nums1[m + i] = nums2[i];
        // }
        // Arrays.sort(nums1);
        int i = m - 1, j = n - 1, idx = m + n - 1;
        while (idx >= 0) {
            if (j < 0) {
                return ;
            }
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
        return ;
    }
}
