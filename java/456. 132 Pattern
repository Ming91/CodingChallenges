// Daily Question 09/30/2023
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int p = n;
        int min = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (min > nums[i]) {
                return true;
            }
            while (p < n && nums[p] < nums[i]) {
                min = nums[p++];
            }
            nums[--p] = nums[i];
        }
        return false;
    }
}
// [Beat 99%] 
//  Keep a decreasing monotonic stack, min is the largest min that is smaller than nums[i],
//  So when reach nums[i - 1] and nums[i - 1] < min, then nums[i - 1] nums[i] min is a 132 pattern. 

// [Editorial] use min[] and decreasing monotonic(like top: 0, 3, 4) stack from the end. 
// nums: 3, 5, 0, 3, 4
// min:  3, 3, 0, 0, 0
// when reach 5, min[i] < element 4 in the stack, so return true. 
// class Solution {
//     public boolean find132pattern(int[] nums) {
//         // Deque<Integer> stack = new ArrayDeque<>();
//         int n = nums.length;
//         int[] min = new int[n];
//         min[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             min[i] = Math.min(min[i - 1], nums[i]);
//         }
//         int p = n;
//         for (int i = n - 1; i >= 0; i--) {
//             // while (!stack.isEmpty() && nums[stack.getFirst()] < nums[i]) {
//             //     if (nums[stack.removeFirst()] > min[i]) {
//             //         return true;
//             //     }
//             // }
//             // stack.addFirst(i);
//             while (p < n && nums[p] < nums[i]) {
//                 if (nums[p++] > min[i]) {
//                     return true;
//                 }
//             }
//             nums[--p] = nums[i];
//         }
//         return false;
//     }
// }
