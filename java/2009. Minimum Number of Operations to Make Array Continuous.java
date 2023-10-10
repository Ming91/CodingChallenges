// Daily Question 10/10/2023
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        int ans = n;
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < m && nums[j] < nums[i] + n) {
                j++;
            }
            int len = j - i;
            ans = Math.min(ans, n - len);
            if (n - m + i >= ans) {
                break;
            }
        }
        return ans;
    }
}
// [Beat 99%]
//  Use original array to remove duplicates. 

// [Editorial] Use HashSet to process unique array. 
// class Solution {
//     public int minOperations(int[] nums) {
//         // Arrays.sort(nums);
//         int n = nums.length;
//         Set<Integer> unique = new HashSet<>();
//         for (int num : nums) {
//             unique.add(num);
//         }
//         int m = unique.size();
//         int[] uniqueNum = new int[m];
//         int idx = 0;
//         for (int u : unique) {
//             uniqueNum[idx++] = u;
//         }
//         Arrays.sort(uniqueNum);
//         int ans = nums.length;
//         int j = 0;
//         for (int i = 0; i < m; i++) {
//             // int j = i;
//             // while (j < m - 1 && uniqueNum[j + 1] == uniqueNum[j] + 1) {
//             //     j++;
//             // }
//             while (j < m && uniqueNum[j] < uniqueNum[i] + n) {
//                 j++;
//             }
//             int len = j - i;
//             ans = Math.min(ans, n - len);
//             if (n - m + i >= ans) {
//                 break;
//             }
//         }
//         return ans;
//     }
// }
