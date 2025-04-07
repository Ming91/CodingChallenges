// Top Interview 150 Array / String Q14
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int subSum = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            subSum += gas[i] - cost[i];
            if (subSum < 0) {
                idx = i + 1;
                subSum = 0;
            }
        }
        return sum < 0 ? -1 : idx;
    }
}
// classic greedy problem, but forget...

// ugly sim
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n = gas.length;
//         int sum = 0;
//         int min = 0;
//         int minIdx = 0;
//         for (int i = 0; i < n; i++) {
//             sum += gas[i] - cost[i];
//             if (min > sum) {
//                 min = sum;
//                 minIdx = i;
//             }
//         }
//         if (min >= 0) {
//             return 0;
//         }
//         sum = 0;
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 0; i < n; i++) {
//             sum += gas[i] - cost[i];
//             if (sum == min) {
//                 q.add((i + 1) % n);
//             }
//         }
//         // System.out.println(q.size());
//         while (!q.isEmpty()) {
//             sum = 0;
//             int start = q.poll();
//             int curr = start;
//             int i = 0;
//             while (i < n && sum >= 0) {
//                 sum += gas[curr] - cost[curr];
//                 curr = (curr + 1) % n;
//                 i++;
//             }
//             if (i == n && sum >= 0) {
//                 return start;
//             }
//         }
//         return -1;
//     }
// }
