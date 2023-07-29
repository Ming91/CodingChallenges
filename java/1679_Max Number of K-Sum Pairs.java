// LeetCode 75 Two Pointers Q4
class Solution {
    class MyNumber {
        int val = 0;
        MyNumber(int i) {
            this.val = i;
        }
    }
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, MyNumber> numbers = new HashMap<Integer, MyNumber>();
        Integer operations = 0;
        MyNumber value, complement;

        for(int i=0; i < nums.length; i++) {
            if(nums[i] >= k) {
                continue;
            } else {
                complement = numbers.get(k-nums[i]);
                if(complement != null && complement.val != 0) {
                    //complement.getAndDecrement();
                    complement.val--;
                    operations++;
                } else {
                    value = numbers.get(nums[i]);
                    if(value != null) {
                        //value.getAndIncrement();
                        value.val++;
                    } else {
                        numbers.put(nums[i], new MyNumber(1));
                    }    
                }                
            }
        }
        
        return operations;
    }
}
// beat 99% idea:
//   make map value as an object, update the object value after each retrive
//   人家用的已有的atomicinteger, 自己写一个更快

// map.put cost too much time
// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         Map<Integer, Integer> map  = new HashMap<>();
//         int ans = 0;
//         for (int num : nums) {
//             if (num >= k) {
//                 continue;
//             }
//             // int v = map.getOrDefault(num, 0);
//             if (map.getOrDefault(k - num, 0) > 0) {
//                 ans++;
//                 map.put(k - num, map.get(k - num) - 1);
//             } else {
//                 map.put(num, map.getOrDefault(num, 0) + 1);
//             }
//         }
//         return ans;
//     }
// }

// TLE
// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         Map<Integer, Integer> map  = new HashMap<>();
//         for (int num : nums) {
//             // int v = map.getOrDefault(num, 0);
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//         int ans = 0;
//         for (int i = 1; i <= (k >> 1); i++) {
//             ans += Math.min(map.getOrDefault(i, 0), map.getOrDefault(k - i, 0));
//         }
//         if ((k & 1) == 0) {
//             ans -= (map.getOrDefault(k >> 1, 0) + 1) >> 1;
//         }
//         return ans;
//     }
// }
