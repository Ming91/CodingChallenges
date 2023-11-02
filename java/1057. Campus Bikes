// Weekly Premium Nov 2023 W1

class Solution {
    int getDistance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int min = 1998;
        int max = 0;
        int[] workerStatus = new int[n];
        boolean[] bikeStatus = new boolean[m];
        for (int i = 0; i < n; i++) {
            workerStatus[i] = -1;
            for (int j = 0; j < m; j++) {
                int dist = getDistance(workers[i], bikes[j]);
                min = Math.min(min, dist);
                max = Math.max(max, dist);
            }
        }
        List<int[]>[] buckets = new ArrayList[max - min + 1];
        for (int i = 0; i < n; i++) {
            workerStatus[i] = -1;
            for (int j = 0; j < m; j++) {
                int dist = getDistance(workers[i], bikes[j]);
                if (buckets[dist - min] == null) {
                    buckets[dist - min] = new ArrayList<>();
                }
                buckets[dist - min].add(new int[] {i, j});
            }
        }
        int count = 0;
        for (int dist = 0; dist <= max - min; dist++) {
            if (buckets[dist] == null) {
                continue;
            }
            for (int[] pair : buckets[dist]) {
                if (workerStatus[pair[0]] >= 0 || bikeStatus[pair[1]]) {
                    continue;
                }
                workerStatus[pair[0]] = pair[1];
                bikeStatus[pair[1]] = true;
                count++;
                if (count == n) {
                    return workerStatus;
                }
            }
        }
        return workerStatus;
    }
}
// [Editorial]
//  NM + K
//  Bucket sorting, the adding order guarantees the order of worker and bike relations.
//  Redudant: add much more than n numbers in the bucket

// NM + NMlog(N)
// [Beat 99%][Missing Testcase] If curr worker min dist bike is ocupied, use O(M) to find next min. 
//  Complexity is not good, it uses the structure of testcase. 
//  I've construct a test case that this use 200+ms, and bucket use 18ms. 
//  Here is the code, it makes all workers has the same distance for the same bike.
//         for (int i = 0; i < 500; i++) {
//             bikes[i][0] = i;
//             bikes[i][1] = (i + k) % 500;
//         }
//         for (int i = 0; i < 500; i++) {
//             workers[i][0] = 499 + i;
//             workers[i][1] = 998 - i;
//         }
// class Solution {
//     int getDistance(int[] x, int[] y) {
//         return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
//     }
//     Comparator<int[]> workerBikeComparator
//         = new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                 for (int i = 2; i >= 0; i--) {
//                     if (a[i] != b[i]) {
//                         return Integer.compare(a[i], b[i]);
//                     }
//                 }
//                 return 0;
//             }
//         };
//     public int[] assignBikes(int[][] workers, int[][] bikes) {
//         int n = workers.length;
//         int m = bikes.length;
//         int[] workerStatus = new int[n];
//         boolean[] bikeStatus = new boolean[m];
//         Queue<int[]> pq = new PriorityQueue<>(workerBikeComparator);
//         for (int i = 0; i < n; i++) {
//             int min = 1999;
//             int minIdx = -1;
//             for (int j = 0; j < m; j++) {
//                 int dist = getDistance(workers[i], bikes[j]);
//                 if (min > dist) {
//                     min = dist;
//                     minIdx = j;
//                 }
//             }
//             pq.add(new int[] {minIdx, i, min});
//         }
//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             if (!bikeStatus[curr[0]]) {
//                 workerStatus[curr[1]] = curr[0];
//                 bikeStatus[curr[0]] = true;
//                 continue;
//             }
//             int min = 1999;
//             int minIdx = -1;
//             for (int j = 0; j < m; j++) {
//                 if (bikeStatus[j]) {
//                     continue;
//                 }
//                 int dist = getDistance(workers[curr[1]], bikes[j]);
//                 if (min > dist) {
//                     min = dist;
//                     minIdx = j;
//                 }
//             }
//             pq.add(new int[] {minIdx, curr[1], min});
//         }
//         return workerStatus;
//     }
// }
// [Editorial][Ming]
//  NM*log(N) + Nlog(N)*Nlog(N) clearing one PQ is Nlog(N), we have inner and outer ones. 
//  For each worker, maintain a n size TreeSet, which could be much smaller than m. 
//  And a main prority queue, to track current smallest choice. 
//  TreeSet can easily implement the n size `queue`, but PriorityQueue can only pop from one end.

// class Solution {
//     int getDistance(int[] x, int[] y) {
//         return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
//     }
//     Comparator<int[]> workerBikeComparator
//         = new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                 for (int i = 2; i >= 0; i--) {
//                     if (a[i] != b[i]) {
//                         return Integer.compare(a[i], b[i]);
//                     }
//                 }
//                 return 0;
//             }
//         };
//     public int[] assignBikes(int[][] workers, int[][] bikes) {
//         int n = workers.length;
//         int m = bikes.length;
//         int[] workerStatus = new int[n];
//         boolean[] bikeStatus = new boolean[m];
//         // Queue<int[]>[] currWorkersPQ = new PriorityQueue[n];
//         // List<int[]>[] currWorkersList = new ArrayList[n];
//         // int[][][] currWorkersArr = new int[n][n][3];
//         TreeSet<int[]>[] currWorkersTree = new TreeSet[n];
//         // int[] currWorkersListIdx = new int[n];
//         Queue<int[]> pq = new PriorityQueue<>(workerBikeComparator);
//         for (int i = 0; i < n; i++) {
//             // currWorkersPQ[i] = new PriorityQueue<>(workerBikeComparator.reversed());
//             currWorkersTree[i] = new TreeSet<int[]>(workerBikeComparator);
//             workerStatus[i] = -1;
//             for (int j = 0; j < m; j++) {
//                 // [PQ]
//                 // currWorkersPQ[i].add(new int[] {
//                 //     j, i, getDistance(workers[i], bikes[j])
//                 // });
//                 // if (currWorkersPQ[i].size() > n) {
//                 //     currWorkersPQ[i].poll();
//                 // }

//                 // [TreeSet]
//                 int[] pair = new int[] {j, i, getDistance(workers[i], bikes[j])};
//                 if (currWorkersTree[i].size() < n ||
//                     workerBikeComparator.compare(currWorkersTree[i].last(), pair) > 0) {

//                     currWorkersTree[i].add(pair);
//                 }
//                 if (currWorkersTree[i].size() > n) {
//                     currWorkersTree[i].pollLast();
//                 }
//             }
//             // [PQ wrong]
//             // System.out.print(i + ":");
//             // for (int[] j : currWorkersPQ[i]) {
//             //     System.out.print("{" + j[0] + "," + j[1] + "," + j[2]+ "}");
//             // }
//             // System.out.println();
//             // The order of the prority queue is arbitrary here, so are the lines above. 
//             // currWorkersList[i] = new ArrayList<>(currWorkersPQ[i]);

//             // [PQ correct] using list
//             // for (int j = n - 1; j >= 0; j--) {
//             //     currWorkersArr[i][j] = currWorkersPQ[i].poll();
//             // }
//             // pq.offer(currWorkersArr[i][0]);
//             // currWorkersListIdx[i] = 1;
            
//             // [TreeSet]
//             pq.offer(currWorkersTree[i].pollFirst());
//         }
//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             if (!bikeStatus[curr[0]]) {
//                 workerStatus[curr[1]] = curr[0];
//                 bikeStatus[curr[0]] = true;
//                 continue;
//             }
//             // pq.offer(currWorkersArr[ curr[1] ][ currWorkersListIdx[ curr[1] ] ]);
//             // currWorkersListIdx[curr[1]]++;
//             pq.offer(currWorkersTree[curr[1]].pollFirst());
//         }
//         return workerStatus;
//     }
// }

// [Ming]
//  Sorting all n*m pairs. 
//  NM*log(NM)
// class Solution {
//     int getDistance(int[] x, int[] y) {
//         return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
//     }
//     public int[] assignBikes(int[][] workers, int[][] bikes) {
//         int n = workers.length;
//         int m = bikes.length;
//         int[][] q = new int[n * m][3];
//         int curr = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 q[curr][1] = i;
//                 q[curr][0] = j;
//                 q[curr][2] = getDistance(workers[i], bikes[j]);
//                 curr++;
//             }
//         }
//         Arrays.sort(q, (a, b) -> {
//             for (int i = 2; i >= 0; i--) {
//                 if (a[i] != b[i]) {
//                     return a[i] - b[i];
//                 }
//             }
//             return 0;
//         });
//         // System.out.println(Arrays.deepToString(q));
//         Set<Integer> w = new HashSet<>();
//         Set<Integer> b = new HashSet<>();
//         int[] ans = new int[n];
//         int count = 0;
//         for (int[] qq : q) {
//             if (w.contains(qq[1]) || b.contains(qq[0])) {
//                 continue;
//             }
//             ans[qq[1]] = qq[0];
//             w.add(qq[1]);
//             b.add(qq[0]);
//             count++;
//             if (count == n) {
//                 return ans;
//             }
//         }
//         return ans;
//     }
// }
