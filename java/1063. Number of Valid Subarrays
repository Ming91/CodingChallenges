// Weekly Premium Sep 2023 W4
class Solution {
    public int validSubarrays(int[] nums) {
        int top = 0;
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            while (top > 0 && curr < nums[top - 1]) {
                top--;
            }
            nums[top++] = curr;
            ans += top;
        }
        return ans;
    }
}
// [Beat 99%]
//  Use the original array as the stack.
//  Top is the top pointer of the stack, pop all elements that larger than curr. 
//  Each remaining element i can assure that all j in i~curr has nums[j] >= nums[i], 
//  Aka, i~curr is a valid subarray. so, ans += stack size, which is top. 

// class Solution {
//     public int validSubarrays(int[] nums) {
//         Stack<Integer> stack = new Stack<>();
//         int n = nums.length;
//         int ans = 0;
//         for (int i = n - 1; i >= 0; i--) {
//             int curr = nums[i];
//             while (!stack.isEmpty() && curr <= nums[stack.peek()]) {
//                 stack.pop();
//             }
//             int res = stack.isEmpty() ? n - i : stack.peek() - i;
//             ans += res;
//             stack.push(i);
//         }
//         return ans;
//     }
// }
