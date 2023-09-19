// Daily Challenge 08/30/2023
class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int prev = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // if (nums[i] <= nums[i + 1]) {
            //     continue;
            // }
            // long k = (long)(nums[i] + nums[i + 1] - 1) / nums[i + 1];
            // nums[i] = (int)(nums[i] / k);

            // forget about the quantity relationship, combine to same calculation
            int k = nums[i] / prev;
            if (nums[i] % prev != 0) {
                k++;
                prev = nums[i] / k;
            }
            sum += k - 1;
        }
        return sum;
    }
}

// a > b, and make a to k segments no larger than b
// can think of the problem this way:
//  split a into k cells, each is at max b. 
//  so we need (a + (b - 1)) / b cells, since a / b * b < a is possible.
//  (a + (b - 1)) / b is the smallest number that guaranteed k * b >= a


// solved after hints,
// make last element umoved, because if make x->y that y < x, the array[0, n - 2] satisfied y still satisfied x. No need to split last element.
// For [i] > [i + 1], split [i] to k segments.
//  a / k + 1(?) <= b, k >= a / b, so start a/b

// slow, but works, but still slow

// class Solution {
//     long dfs(int[] nums, int curr) {
//         if (curr == -1) {
//             return 0;
//         }
//         if (nums[curr] <= nums[curr + 1]) {
//             return dfs(nums, curr - 1);
//         }
//         // make smaller part maximum
//         // a / k + 1(?) <= b
//         long k = Math.max(2, nums[curr] / nums[curr + 1]);
//         while (true) {
//             long remainder = nums[curr] % k;
//             long max = (nums[curr] / k) + (remainder > 0 ? 1 : 0);
//             if (max <= nums[curr + 1]) {
//                 nums[curr] = (int)(nums[curr] / k);
//                 return dfs(nums, curr) + k - 1;
//             }
//             k++;
//         }
//         // return dfs(nums, curr) + k - 1;
//     }
//     public long minimumReplacement(int[] nums) {
//         int n = nums.length;
//         return dfs(nums, n - 2);
//     }
// }
