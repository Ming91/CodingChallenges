// Top Interview 150 Heap Q1
// LeetCode 75 Heap / Priority Queue Q1
// Daily Challenge 08/14/2023
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20_001];
        for (int num : nums) {
            count[num + 10_000]++;
        }
        for (int i = 20_000; i >= 0; i--) {
            k -= count[i];
            if (k <=0) {
                return i - 10_000;
            }
        }
        return -1;
    }
}
// fastest way is count sort/ bucket sort

// QuickSelect Array Impl
// class Solution {

//     int qs(int[] nums, int len, int k) {
//         int[] left = new int[len];
//         int[] right = new int[len];
//         int[] mid = new int[len];
//         int l = 0, r = 0, m = 0;
//         int pIdx = new Random().nextInt(len);
//         int p = nums[pIdx];
//         for (int i = 0; i < len; i++) {
//             if (nums[i] > p) {
//                 left[l++] = nums[i];
//                 continue;
//             }
//             if (nums[i] < p) {
//                 right[r++] = nums[i];
//                 continue;
//             }
//             mid[m++] = nums[i];
//         }
//         if (l >= k) {
//             return qs(left, l, k);
//         }
//         if (l + m < k) {
//             return qs(right, r, k - l - m);
//         }
//         return p;
//     }

//     public int findKthLargest(int[] nums, int k) {
//         return qs(nums, nums.length, k);
//     }
// }
// failed impl
// class Solution {
//     int[] nums;

//     int qs(int l, int r, int k) {
//         if (l == r) {
//             return nums[l];
//         }
//         int pIdx = new Random().nextInt(r - l);
//         pIdx += l;
//         int p = nums[pIdx];
//         int ll = l, rr = r;
//         while (ll < rr) {
//             while (nums[ll] > p && ll < rr) {
//                 ll++;
//             }
//             while (nums[rr] <= p && ll < rr) {
//                 rr--;
//             }
//             int temp = nums[ll];
//             nums[ll] = nums[rr];
//             nums[rr] = temp;
//         }
//         if (ll - l > k) {
//             return qs(l, ll - 1, k);
//         }
//         return qs(rr + 1, r, k - ll + l);
//     }

//     public int findKthLargest(int[] numss, int k) {
//         nums = numss;
//         return qs(0, nums.length - 1, k);
//     }
// }

// Queue good practice
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Queue<Integer> q = new PriorityQueue<>();
//         for (int num : nums) {
//             q.offer(num);
//             if (q.size() > k) {
//                 q.poll();
//             }
//         }
//         return q.poll();        
//     }
// }
// TLE queue usage
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Queue<Integer> q = new PriorityQueue<>();
//         for (int num : nums) {
//             if (q.size() < k) {
//                 q.offer(num);
//                 continue;
//             }
//             for (int e : q) {
//                 if (e < num) {
//                     q.poll();
//                     q.offer(num);
//                     break;
//                 }
//             }
//         }
//         return q.poll();
//     }
// }
