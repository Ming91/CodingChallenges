// Top Interview 150 Binary Search Q7
// 11/08/2023 Impl
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m;
        //                    index                 count
        // even    [(m+n)/2-1]    [(m+n)/2]    (m+n)/2, (m+n)/2
        // odd                    [(m+n)/2]    (m+n-1)/2,  1, (m+n-1)/2
        // so we keep total left half (m+n+1)/2 numbers,
        int med = (m + n + 1) / 2;
        while (true) {
            //  max([mid1-1], [mid2-1]) <= min([mid1], [mid2]) then found
            int mid1 = (l + r) / 2;
            int mid2 = med - mid1;
            int midLeft1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int midLeft2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int midRight1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int midRight2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
            if (midLeft1 > midRight2) {
                r = mid1 - 1;
                continue;
            }
            if (midLeft2 > midRight1) {
                l = mid1 + 1;
                continue;
            }
            if (((m + n) & 1) == 1) {
                return Math.max(midLeft1, midLeft2);
            } else {
                return ((Math.max(midLeft1, midLeft2) + Math.min(midRight1, midRight2)) / 2.0);
            }
        }
        // return 0.0;
    }
}
// [Editorial] Need to consider how many numbers to keep at each half. 

// Daily Question 09/21/2023
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         if (nums1.length > nums2.length) {
//             return findMedianSortedArrays(nums2, nums1);
//         }
//         int m = nums1.length;
//         int n = nums2.length;
//         int l = 0;
//         int r = m;
//         int half = (m + n + 1) / 2;
//         while (true) {
//             int idx1 = (l + r) / 2;
//             int idx2 = half - idx1;
//             int midLeft1 = idx1 == 0 ? Integer.MIN_VALUE : nums1[idx1 - 1];
//             int midLeft2 = idx2 == 0 ? Integer.MIN_VALUE : nums2[idx2 - 1];
//             int midRight1 = idx1 == m ? Integer.MAX_VALUE : nums1[idx1];
//             int midRight2 = idx2 == n ? Integer.MAX_VALUE : nums2[idx2];
//             if (midLeft1 > midRight2) {
//                 r = idx1 - 1;
//                 continue;
//             }
//             if (midLeft2 > midRight1) {
//                 l = idx1 + 1;
//                 continue;
//             }
//             if (((m + n) & 1) == 1) {
//                 return Math.max(midLeft1, midLeft2);
//             } else {
//                 return (Math.max(midLeft1, midLeft2) + 
//                         Math.min(midRight1, midRight2)) / 2.0;
//             }
//         }
//         // return -1;
//     }
// }
