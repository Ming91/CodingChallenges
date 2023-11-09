// Top Interview 150 Heap Q2
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int minCap = Integer.MAX_VALUE;
        int maxCap = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minCap = Math.min(minCap, capital[i]);
            maxCap = Math.max(maxCap, capital[i]);
            // pairs[i][0] = profits[i];
            // pairs[i][1] = capital[i];
        }
        if (minCap > w) {
            return w;
        }
        if (w >= maxCap) {
            if (k == n) {
                return w + Arrays.stream(profits).sum();
            }
            Queue<Integer> pq = new PriorityQueue<>();
            for (int profit : profits) {
                pq.add(profit);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            return w + pq.stream().mapToInt(Integer::intValue).sum();
        }
        
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = profits[i];
            pairs[i][1] = capital[i];
        }
        Arrays.sort(pairs, (a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[0], a[0]);
        });
        int idx = n - 1;
        for (; idx >= 0 && pairs[idx][1] <= w; idx--) {
            pq.add(pairs[idx]);
        }
        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            w += curr[0];
            k--;
            for (; idx >= 0 && pairs[idx][1] <= w; idx--) {
                pq.add(pairs[idx]);
            }
        }
        return w;
    }
}
// [Ming] Order by capital first, and add valid capital corresponding profit to pq ordered by profit,
//  select max profit, loop until k reaches or no valid remain. 
// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//         int n = profits.length;
//         int[][] pairs = new int[n][2];
//         int minCap = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++) {
//             minCap = Math.min(minCap, capital[i]);
//             pairs[i][0] = profits[i];
//             pairs[i][1] = capital[i];
//         }
//         if (minCap > w) {
//             return w;
//         }
//         Arrays.sort(pairs, (a, b) -> {
//             // if (Integer.compare(a[0], b[0]) == 0) {
//             //     return Integer.compare(a[1], b[1]);
//             // }
//             return Integer.compare(b[1], a[1]);
//         });
//         Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
//             // if (Integer.compare(a[0], b[0]) == 0) {
//             //     return Integer.compare(a[1], b[1]);
//             // }
//             return Integer.compare(b[0], a[0]);
//         });
//         int i = n - 1;
//         for (; i >= 0 && pairs[i][1] <= w; i--) {
//             pq.add(pairs[i]);
//         }
//         while (k > 0 && !pq.isEmpty()) {
//             int[] curr = pq.poll();
//             w += curr[0];
//             k--;
//             for (; i >= 0 && pairs[i][1] <= w; i--) {
//                 pq.add(pairs[i]);
//             }
//         }
//         return w;
//     }
// }
