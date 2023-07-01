class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int smallI = Integer.MAX_VALUE;
        int smallJ = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= smallI) {
                smallI = i;
            } else {
                if (i <= smallJ) {
                    smallJ = i;
                } else {
                    return true;
                }
            }
        }
        // for (int k = 1; k < n; k++) {
        //     if (nums[k] < smallI) {
        //         smallI = nums[k];
        //     }
        //     if ((smallI < nums[k]) && (nums[k] < smallJ)) {
        //         smallJ = nums[k];
        //         continue;
        //     }
        //     if ((nums[k] > smallI) && (nums[k] > smallJ)) {
        //         return true;
        //     }
        // }
        return false;
    }
}
/**
    要求O(n)时间和O(1)空间:
    一点数学,
    只记录最小和次小的, 次小的不是inf时,说明其左侧有个曾经的最小小于它,
    因此,只要当前大于这俩数,就说明满足条件.
    例如
    10 20 3 2 50
    到3时, 最小更新为3, 次小是20, 次小不是inf, 表示左侧有比其小的(此时是10),
    比次小大, 也保证比左侧比其小的大.


    简单想法:
        记录左侧最小,右侧最大,两个数组,两次遍历
 */
