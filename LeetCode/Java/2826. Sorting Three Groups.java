// Biweekly Contest 111 Q3
class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[]{n, n, n, n};
        for (int num : nums) {
            // initialize with all n to skip add
            // dp[1]++;
            // dp[2]++;
            // dp[3]++;
            dp[num]--;
            // if make all 1 is easier, then choose make all 1
            dp[2] = Math.min(dp[2], dp[1]);
            // if make all smaller than 2(or 1) and ordered is easier, then choose that
            dp[3] = Math.min(dp[2], dp[3]);
        }
        return dp[3];
    }
}
// dp[k] means all ops needed to make all number<=k and ordered before current(including current)

// dp[i][1] = dp[i - 1][1] + if n[i] != 1
// dp[i][2] = min(dp[i - 1][2] + if n[i] != 2, dp[i - 1][1] + if n!= 1)
// dp[i][3] = min(dp[i - 1][3] + if n[i] != 3, dp[i - 1][2] + if n[i] != 2, dp[i - 1][1] + if n!= 1)

// O(n^3) loops, i and j are split point, k loops for calc ops in whole array
// class Solution {
//     public int minimumOperations(List<Integer> nums) {
//         int n = nums.size();
//         int ans = n;
//         for (int i = 0; i <= n; i++) {
//             for (int j = i; j <= n; j++) {
//                 int res = n;
//                 for (int k = 0; k < n; k++) {
//                     if (k < i) {
//                         res -= nums.get(k) == 1 ? 1 : 0;
//                     } else {
//                         if (k < j) {
//                             res -= nums.get(k) == 2 ? 1 : 0;
//                         } else {
//                             res -= nums.get(k) == 3 ? 1 : 0;
//                         }
//                     }
//                 }
//                 ans = Math.min(ans, res);
//             }
//         }
//         return ans;
//     }    
// }

// ugly simulation
// just try every point as the divide point, like 1 and 2, 1 and 3 or 2 and 3
// or 1 and 2 and 3

// class Solution {
//     public int minimumOperations(List<Integer> nums) {
//         int n = nums.size();
//         int[][] left = new int[n][4], right = new int[n][4];
//         left[0][1] = 1;
//         left[0][2] = 1;
//         left[0][3] = 1;
//         left[0][nums.get(0)] = 0;
//         left[0][0] = nums.get(0);
//         // System.out.printf("left[%d]: %d %d %d %d%n", 0, left[0][0], left[0][1], left[0][2], left[0][3]);
//         boolean ordered = true;
//         for (int i = 1; i < n; i++) {
//             left[i][0] = nums.get(i);
//             left[i][1] = left[i - 1][1] + 1;
//             left[i][2] = left[i - 1][2] + 1;
//             left[i][3] = left[i - 1][3] + 1;
//             left[i][left[i][0]]--;
//             // System.out.printf("left[%d]: %d %d %d %d%n", i, left[i][0], left[i][1], left[i][2], left[i][3]);
//             if (ordered && left[i][0] < left[i - 1][0]) {
//                 ordered = false;
//             }
//         }
//         if (ordered) {
//             return 0;
//         }
//         right[n - 1][1] = 1;
//         right[n - 1][2] = 1;
//         right[n - 1][3] = 1;
//         right[n - 1][nums.get(n - 1)] = 0;
//         right[n - 1][0] = nums.get(n - 1);
//         for (int i = n - 2; i >= 0; i--) {
//             right[i][0] = nums.get(i);
//             right[i][1] = right[i + 1][1] + 1;
//             right[i][2] = right[i + 1][2] + 1;
//             right[i][3] = right[i + 1][3] + 1;
//             right[i][right[i][0]]--;
//             // System.out.printf("right[%d]: %d %d %d %d%n", i + 1, right[i + 1][0], right[i + 1][1], right[i + 1][2], right[i + 1][3]);
//         }
        
//         // System.out.printf("right[%d]: %d %d %d %d%n", 0, right[0][0], right[0][1], right[0][2], right[0][3]);
//         int ans = 100;
//         for (int i = 0; i < n; i++) {
//             // left to 1, right to 2
//             int res = left[i][1] + right[i][2] - (right[i][0] == 2 ? 0 : 1);
//             ans = Math.min(ans, res);
            
//             // left to 2 or 1, right to 3
//             res = Math.min(left[i][1], left[i][2]);
//             res = res + right[i][3] - (right[i][0] == 3 ? 0 : 1);
//             ans = Math.min(ans, res);
            
//             // left to 3
//             if (right[i][3] == (right[i][0] == 3 ? 0 : 1)) {
//                 res = left[i][3];
//                 ans = Math.min(ans, res);
//             }
//         }
//         if (ans == 1) {
//             return 1;
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int res = left[i][1] + (left[j][2] - left[i][2]) + right[j][3] - (right[j][0] == 2 ? 0 : 1);
//                 ans = Math.min(ans, res);
//             }
//             // System.out.println("ans: " + ans);
//         }
        
//         return ans;
//     }
// }
