// Biweekly Contest 114 Q1
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        boolean[] isAdded = new boolean[k];
        int n = nums.size();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums.get(i) > k || isAdded[nums.get(i) - 1]) {
                continue;
            }
            isAdded[nums.get(i) - 1] = true;
            count++;
            if (count == k) {
                return n - i;
            }
        }
        return n;
    }
}

// [Ming] Ugly O(n^2)
// class Solution {
//     public int minOperations(List<Integer> nums, int k) {
//         boolean[] added = new boolean[51];
//         for (int i = nums.size() - 1; i >= 0; i--) {
//             added[nums.get(i)] = true;
//             boolean r = true;
//             for (int j = 1; j <= k; j++) {
//                 if (added[j] == false) {
//                     r = false;
//                     break;
//                 }
//             }
//             if (r) {
//                 return nums.size() - i;
//             }
//         }
//         return nums.size();
//     }
// }
