// Daily Challenge 08/10/2023
class Solution {
    boolean binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return false;
        }
        if (nums[l] == target || nums[r] == target) {
            return true;
        }
        int mid = (l + r) >> 1;
        // if (nums[mid] == target) {
        //     return true;
        // }
        if (target < nums[mid]) {
            if (target > nums[r]) {
                // mid > target > r
                // * means the spot l or r can only be there
                //   5 |         m
                //   4 |       t
                //   3 | l*
                //   2 |           r
                //     +--------------
                //      0  1  2  3
                return binarySearch(nums, l, mid - 1, target);
            } else {
                //   5 |         
                //   4 |        m      r
                //   3 |    t1      t2
                //   2 | l*         
                //     +--------------
                //      0  1  2  3
                return binarySearch(nums, l, mid - 1, target) | binarySearch(nums, mid + 1, r, target);
            }
            
        }
        if (target > nums[mid]) {
            if (target < nums[l]) {
                // mid < target < l
                //   5 | l        
                //   4 |            r*
                //   3 |         t
                //   2 |      m     
                //     +--------------
                //      0  1  2  3
                return binarySearch(nums, mid + 1, r, target);
            } else {
                //   5 |         
                //   4 |               r*
                //   3 |    t1      t2
                //   2 | l      m   
                //     +--------------
                //      0  1  2  3
                return binarySearch(nums, l, mid - 1, target) | binarySearch(nums, mid + 1, r, target);
            }
        }

        return true;
    }
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}
// 不是严格上升了, 差的情况二分决策不了
