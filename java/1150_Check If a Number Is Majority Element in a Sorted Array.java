class Solution {
    private static int binarySearch(int[] arr, int l, int r, int x) {
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= x) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        //System.out.println(l + "," + r);
        if (ans >= 0 && arr[ans] == x) {
            return ans;
        }
        return -1;
    }
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        int len = nums.length;
        int compareBase = len / 2;
        
        int firstIdx = binarySearch(nums, 0, len - 1, target);
        //System.out.println(firstIdx);
        if (firstIdx < 0) {
            return false;
        }
        if (firstIdx + compareBase >= len || nums[firstIdx + compareBase] > target) {
            return false;
        }
        return true;
    }
}

// frequency count works here
