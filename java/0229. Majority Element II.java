// Daily Question 10/05/2023
// class Solution {
//     int a, b, aCount, bCount;
//     boolean isValid(int[] nums, int target) {
//         int n = nums.length;
//         int count = 0;
//         for (int i = 0; i < n && count * 3 <= n; i++) {
//             if (nums[i] == target) {
//                 count++;
//             }
//         }
//         return count * 3 > n;
//     }
//     public List<Integer> majorityElement(int[] nums) {
//         a = Integer.MIN_VALUE;
//         b = Integer.MIN_VALUE;
//         aCount = 0;
//         bCount = 0;
//         for (int num : nums) {
//             if (aCount == 0 && num != b) {
//                 a = num;
//                 aCount = 1;
//                 continue;
//             }
//             if (a == num) {
//                 aCount++;
//                 continue;
//             }
//             if (bCount == 0) {
//                 b = num;
//                 bCount = 1;
//                 continue;
//             }
//             if (b == num) {
//                 bCount++;
//                 continue;
//             }
//             aCount--;
//             bCount--;
//         }
//         List<Integer> ans = new ArrayList<>();
//         if (isValid(nums, a)) {
//             ans.add(a);
//         }
//         if (isValid(nums, b)) {
//             ans.add(b);
//         }
//         return ans;
//     }
// }
// [Editorial] version

// [Ming] Boyer-Moore Impl. 
class Solution {
    int a, b, aCount, bCount;
    boolean isValid(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n && count * 3 <= n; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count * 3 > n;
    }
    void swap() {
        int temp = a;
        a = b;
        b = temp;
        temp = aCount;
        aCount = bCount;
        bCount = temp;
    }
    public List<Integer> majorityElement(int[] nums) {
        a = Integer.MIN_VALUE;
        b = Integer.MIN_VALUE;
        aCount = 0;
        bCount = 0;
        for (int num : nums) {
            if (a == Integer.MIN_VALUE || a == num) {
                a = num;
                aCount++;
                continue;
            }
            if (b == Integer.MIN_VALUE || b == num) {
                b = num;
                bCount++;
                continue;
            }
            // if (aCount > bCount) {
            //     swap();
            // }
            if (aCount == 0) {
                a = num;
                aCount = 1;
                continue;
            }
            if (bCount == 0) {
                b = num;
                bCount = 1;
                continue;
            }
            
            aCount--;
            bCount--;
        }
        List<Integer> ans = new ArrayList<>();
        if (isValid(nums, a)) {
            ans.add(a);
        }
        if (isValid(nums, b)) {
            ans.add(b);
        }
        return ans;
    }
}
