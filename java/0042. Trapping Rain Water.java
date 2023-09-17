// Top Interview 150 Array / String Q16
// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int ans = 0;
//         // 2.1 Two loops
//         int[] left = new int[n];
//         int[] right = new int[n];
//         left[0] = height[0];
//         right[n - 1] = height[n - 1];
//         for (int i = 1; i < n; i++) {
//             left[i] = Math.max(left[i - 1], height[i]);
//         }
//         for (int i = n - 2; i >= 0; i--) {
//             right[i] = Math.max(right[i + 1], height[i]);
//         }
//         for (int i = 0; i < n; i++) {
//             ans += Math.min(left[i], right[i]) - height[i];
//         }
        
//         // 2.2 Monotonic Stack

//         // Stack<Integer> stack = new Stack<Integer>();
//         // int i = 0;
//         // while (i < n) {
//         //     while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
//         //         int idx = stack.pop();
//         //         if (stack.isEmpty()) {
//         //             break;
//         //         }
//         //         // for each idx, stack.peek() is left bar, i is right bar
//         //         // add water in left bar to right bar that height hight than height[idx]
//         //         // so can transfer state to water level at left bar
//         //         ans += (Math.min(height[stack.peek()], height[i]) - height[idx]) * (i - stack.peek() - 1);
//         //     }
//         //     stack.push(i++);
//         // }

//         return ans;
//     }
// }
// [Editorial] Idea:
//  Find the recent larger or equal on right
//  1. Brute Force:
//      For each point, find left and right bar, this point can store min(leftmax, rightmax) - height water. O(n^2)
//  2.1 Two Loops:
//      Use two loops find leftMax and rightMax, then use formula above get answer
//  2.1 Use monotonic stack

//  3. Use two pointers:
//      l = 0, r = n - 1, always update from smaller side

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int leftMax = height[0], rightMax = height[n - 1];
        int ans = 0;
        // self impl version
        // while (l < r) {
        //     // leftMax and rightMax is the lower bar.
        //     // when higher bar reached, it's in height[l] or [r], 
        //     // leftMax and rightMax update not reached in this situation.
        //     while (l < r && height[l] <= height[r]) {
        //         leftMax = Math.max(leftMax, height[l]);
        //         ans += leftMax - height[l];
        //         l++;
        //     }
        //     while (l < r && height[l] >= height[r]) {
        //         rightMax = Math.max(rightMax, height[r]);
        //         ans += rightMax - height[r];
        //         r--;
        //     }
        // }

        // beat 99% version
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > leftMax) {
                    leftMax = height[l];
                } else {
                    ans += leftMax - height[l];
                }
                l++;
            } else {
                if (height[r] > rightMax) {
                    rightMax = height[r];
                } else {
                    ans += rightMax - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}

// [Ming]Naive two points
//  if no larger or equal found on right, make left = remaining peak height
//  O(n^2)
// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int l = 0, r = 1;
//         int ans = 0;
//         while (r < n) {
//             int res = 0;
//             int h = height[l];
//             int max = height[r];
//             int maxIdx = r;
//             while (r < n && h > height[r]) {
//                 if (height[r] > max) {
//                     max = height[r];
//                     maxIdx = r;
//                 }
//                 res += h - height[r++];
//             }
//             if (r == n) {
//                 // System.out.println(l + "," + r + "," + res);
//                 // ans += res - (h - max) * (maxIdx - l);
//                 height[l] = max;
//                 // l = maxIdx;
//                 r = l + 1;
//             } else {
//                 ans += res;
//                 // System.out.println(l + "," + r + "," + res);
//                 l = r++;
//             }
//         }
//         return ans;
//     }
// }
