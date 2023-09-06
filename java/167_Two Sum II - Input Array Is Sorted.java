// Top Interview 150 Two Pointers Q3
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = numbers[l] + numbers[r];
            if (sum < target) {
                if (numbers[mid] + numbers[r] >= target) {
                    l++;
                } else {
                    l = mid + 1;
                }
            } else if (sum > target) {
                if (numbers[l] + numbers[mid] <= target) {
                    r--;
                } else {
                    r = mid - 1;
                }
            } else {
                return new int[] {l + 1, r + 1};
            }
        }
        return new int[] {l + 1, r + 1};
    }
}
// add binary search to accelerate

// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int n = numbers.length;
//         int l = 0, r = n - 1;
//         while (l < r) {
//             int sum = numbers[l] + numbers[r];
//             if (sum < target) {
//                 l++;
//             } else if (sum > target) {
//                 r--;
//             } else {
//                 return new int[] {l + 1, r + 1};
//             }
//         }
//         return new int[] {l + 1, r + 1};
//     }
// }
