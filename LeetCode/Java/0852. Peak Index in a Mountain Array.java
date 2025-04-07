// Daily Challenge 07/25/2023
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}



// study binary search well
// class Solution {
//     private int search(int[] arr, int l, int r) {
//         while (l < r) {
//             int mid = (l + r) / 2;
//             if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
//                 l = mid + 1;
//                 continue;
//             }
//             if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
//                 r = mid;
//                 continue;
//             }
//             return mid;
//         }
//         return l;
//     }
//     public int peakIndexInMountainArray(int[] arr) {
//         int n = arr.length;
//         if (n == 3) {
//             return 1;
//         }
//         return search(arr, 1, n - 2);
//     }
// }
