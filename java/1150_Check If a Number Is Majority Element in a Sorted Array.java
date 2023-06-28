class Solution {
    private static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = (r + l) / 2;
            if (arr[mid] == x && (mid == 0 || arr[mid - 1] < x)) {
                return mid;
            }
            if (arr[mid] >= x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        int len = nums.length;
        int compareBase = len / 2;
        
        int firstIdx = binarySearch(nums, 0, len - 1, target);
        System.out.println(firstIdx);
        if (firstIdx < 0) {
            return false;
        }
        if (firstIdx + compareBase >= len || nums[firstIdx + compareBase] > target) {
            return false;
        }
        return true;
    }
}
