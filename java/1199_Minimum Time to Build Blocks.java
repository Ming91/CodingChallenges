// Weekly Premium W1 Sep/2023

// Totally No Idea!

// [Editorial]

// 1. DP
//      dp[blocks, workers] = 
//      Min of :
//          work : max of:
//                  latter work time: dp[blocks + 1, workers - 1], 
//                  this block time : blocks[i];

//          split: dp[blocks, min(n - blocks, workers * 2)] + split

//      workers > n - blocks, means no more split, just need blocks[i] time
//      workers == 0, need inf time
//      blocks = n, finished, need 0 time

// 1.1 Reduce to 1D, work option get from under row [blocks + 1], 
//      split option gets from column on right (workers <= n - blocks).

// class Solution {
//     public int minBuildTime(int[] blocks, int split) {
//         int n = blocks.length;
//         if (n == 1) {
//             return blocks[0];
//         }
//         Arrays.sort(blocks);
//         for (int i = 0; i < n / 2; i++) {
//             int temp = blocks[i];
//             blocks[i] = blocks[n - i - 1];
//             blocks[n - i - 1] = temp;
//         }
//         int[] dp = new int[n + 1];
//         dp[0] = Integer.MAX_VALUE;
//         for (int i = n - 1; i >= 0; i--) {
//             for (int workers = n; workers >= 1; workers--) {
//                 if (workers >= n - i) {
//                     dp[workers] = blocks[i];
//                     continue;
//                 }
//                 int work = Math.max(blocks[i], dp[workers - 1]);
//                 int sep = split + dp[Math.min(n - i, workers << 1)];
//                 dp[workers] = Math.min(work, sep);
//             }
//         }
//         return dp[1];
//     }
// }
// 2. Heap/Huffman Tree
//  Consider it as assign blocks to n workers. Each worker split as a tree structure.
//  Each split cost is equavilent to add a split degree to the edge.
//  What we need is to assign blocks[] to each nodes, so the longest path from root
//  is minimized.

//  Clearly, we need to assign smaller nodes to deeper level. Aka, larger blocks need 
//  more time to build and use time from smaller blocks worker to split.

//  So, just combine two smallest nodes and add split cost recursively.

// class Solution {
//     public int minBuildTime(int[] blocks, int split) {
//         int n = blocks.length;
//         if (n == 1) {
//             return blocks[0];
//         }
//         Queue<Integer> pq = new PriorityQueue<>();
//         for (int block : blocks) {
//             pq.add(block);
//         }
//         while (pq.size() > 1) {
//             int x = pq.poll();
//             // y is larger, only take split + max(x, y) time
//             pq.add(split + pq.poll());
//         }
//         return pq.poll();
//     }
// }

// 3. Binary Search (Safety Belt Methods)
//  L: max(blocks[]), R: split * log2(n) + max(blocks[])
//  isValid: for blocks, use workers and time to track

class Solution {
    boolean isValid(int[] blocks, int split, int limit) {
        int n = blocks.length;
        int workers = 1;
        for (int i = 0; i < n; i++) {
            int time = blocks[i];
            if (workers == 0 || time > limit) {
                return false;
            }
            // while can, split as many as possible,
            // just left block[i] for building,
            // later blocks are smaller than block[i].
            while (time + split <= limit) {
                limit -= split;
                workers <<= 1;
                if (workers >= n - i) {
                    return true;
                }
            }
            workers--;
        }
        return true;
    }
    public int minBuildTime(int[] blocks, int split) {
        int n = blocks.length;
        if (n == 1) {
            return blocks[0];
        }
        Arrays.sort(blocks);
        for (int i = 0; i < n / 2; i++) {
            int temp = blocks[i];
            blocks[i] = blocks[n - i - 1];
            blocks[n - i - 1] = temp;
        }
        int l = blocks[0];
        int r = split * (int)Math.ceil(Math.log(n) / Math.log(2)) + l;

        while (l < r) {
            int mid = (l + r) >> 1;
            // Find left most valid time
            // eg. [F, F,... F, T, T...]
            if (!isValid(blocks, split, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
