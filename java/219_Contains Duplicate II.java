// Top Interview 150 Hashmap Q8

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                // when i = k+1, remove 0, since k + 1 - 0 > k
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
// [Beat 99%]
// Just maintain a k + 1 length set, if collision, return true;

// use hashmap to store last inedex of each number
// can impl using a k length TreeMap/BinarySearchTree

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         Map<Integer, Integer> lastIdx = new HashMap<>();
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             if (lastIdx.containsKey(nums[i]) && lastIdx.get(nums[i]) >= i - k) {
//                 return true;
//             }
//             lastIdx.put(nums[i], i);
//         }
//         return false;
//     }
// }
