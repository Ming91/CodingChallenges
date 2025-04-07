// Daily Question 10/12/2023
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    int getPeak(MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    int search(int target, MountainArray mountainArr, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return mountainArr.get(l) == target ? l : -1;
    }
    int reverseSearch(int target, MountainArray mountainArr, int l, int r) {
        
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return mountainArr.get(l) == target ? l : -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = getPeak(mountainArr);
        System.out.println(peak);
        int l = search(target, mountainArr, 0, peak);
        return l == -1 ? reverseSearch(target, mountainArr, peak, mountainArr.length() - 1) : l;
    }
}
// [Ming][Basic] Find peak and find in two search.  

// [Wrong❌] we need to find first index of target, this can find, but there is no guarantee that it is the first one.
// class Solution {
//     int search(int target, MountainArray mountainArr, int l, int r) {
//         while (l < r) {
//             int mid = (l + r) / 2;
//             if (mountainArr.get(mid) < target) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return mountainArr.get(l) == target ? l : -1;
//     }
//     int reverseSearch(int target, MountainArray mountainArr, int l, int r) {
        
//         while (l < r) {
//             int mid = (l + r) / 2;
//             if (mountainArr.get(mid) > target) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return mountainArr.get(l) == target ? l : -1;
//     }
//     public int findInMountainArray(int target, MountainArray mountainArr) {
//         int n = mountainArr.length();
//         if (target < mountainArr.get(0) && target < mountainArr.get(n - 1)) {
//             return -1;
//         }
//         int l = 0;
//         int r = n - 1;
//         while (l < r) {
//             int mid = (l + r) / 2;
//             // 1. mid in [l, peak]
//             int midNum = mountainArr.get(mid);
//             int midNext = mid == n - 1 ? Integer.MAX_VALUE : mountainArr.get(mid + 1);
//             if (midNum < midNext) {
//                 if (midNum < target) {
//                     l = mid + 1;
//                 } else {
//                     r = mid;
//                 }
//                 continue;
//             }
//             // 2. mid in [peak, r]
//             int midPrev = mountainArr.get(mid - 1);
//             if (midNum < midPrev) {
//                 if (midNum > target) {
//                     l = mid + 1;
//                 } else {
//                     r = mid;
//                 }
//                 continue;
//             }
//             int left = search(target, mountainArr, l, mid);
//             return left == -1 ? reverseSearch(target, mountainArr, mid, r) : left;

//         }
//         return mountainArr.get(l) == target ? l : -1;
//     }
// }
