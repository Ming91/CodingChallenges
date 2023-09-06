// LeetCode 75 Monotonic Stack Q1
class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        int max = t[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int curr = t[i];
            if (curr >= max) {
                max = curr;
                continue;
            }
            int dist = 1;
            while (t[i + dist] <= curr) {
                dist += ans[i + dist];
            }
            ans[i] = dist;
        }
        return ans;
    }
}

// monotonic stack
// class Solution {
//     public int[] dailyTemperatures(int[] t) {
//         Stack<Integer> stack = new Stack<>();
//         int n = t.length;
//         int[] ans = new int[n];
//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && t[stack.peek()] < t[i]) {
//                 int prev = stack.pop();
//                 ans[prev] = i - prev;
//             }
//             stack.add(i);
//         }
//         return ans;
//     }
// }
