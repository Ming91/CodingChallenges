// Weekly Contest 367 Q3
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int minIdx = 0;
        int min = nums[0];
        int maxIdx = 0;
        int max = nums[0];
        int temp = 0;
        // [Lee] better structure
        for (int i = indexDifference; i < n; i++) {
            if (nums[minIdx] > nums[i - indexDifference]) {
                minIdx = i - indexDifference;
            }
            if (nums[maxIdx] < nums[i - indexDifference]) {
                maxIdx = i - indexDifference;
            }
            if (nums[maxIdx] - nums[i] >= valueDifference) {
                return new int[] {maxIdx, i};
            }
            if (nums[i] - nums[minIdx] >= valueDifference) {
                return new int[] {minIdx, i};
            }
        }
        // [Ming] naive impl
        // for (int i = 0; i < n - indexDifference; i++) {
        //     if (max < nums[i]) {
        //         max = nums[i];
        //         maxIdx = i;
        //     }
        //     if (min > nums[i]) {
        //         min = nums[i];
        //         minIdx = i;
        //     }
        //     temp = nums[i + indexDifference];
        //     if (max - temp >= valueDifference) {
        //         return new int[] {maxIdx, i + indexDifference};
        //     }
        //     if (temp - min >= valueDifference) {
        //         return new int[] {minIdx, i + indexDifference};
        //     }
        // }
        return new int[]{-1, -1};
    }
}
// [Lee]
//  One pass, O(1) space, just store minIdx and maxIdx dynamically. 

// [Ming] Store min and max indices for each indices. 
// class Solution {
//     public int[] findIndices(int[] nums, int idxDiff, int valDiff) {
//         int n = nums.length;
//         if (idxDiff >= n) {
//             return new int[] {-1, -1};
//         }
//         int[] min = new int[n];
//         int[] max = new int[n];
//         int[] minIdx = new int[n];
//         int[] maxIdx = new int[n];
//         min[0] = nums[0];
//         max[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             if (min[i - 1] > nums[i]) {
//                 min[i] = nums[i];
//                 minIdx[i] = i;
//             } else {
//                 min[i] = min[i - 1];
//                 minIdx[i] = minIdx[i - 1];
//             }
            
//             if (max[i - 1] < nums[i]) {
//                 max[i] = nums[i];
//                 maxIdx[i] = i;
//             } else {
//                 max[i] = max[i - 1];
//                 maxIdx[i] = maxIdx[i - 1];
//             }
//         }
//         for (int i = idxDiff; i < n; i++) {
//             int j = i - idxDiff;
//             if (Math.abs(nums[i] - min[j]) >= valDiff) {
//                 return new int[] {minIdx[j], i};
//             }
//             if (Math.abs(nums[i] - max[j]) >= valDiff) {
//                 return new int[] {maxIdx[j], i};
//             }
//         }
//         return new int[] {-1, -1};
//     }
// }
