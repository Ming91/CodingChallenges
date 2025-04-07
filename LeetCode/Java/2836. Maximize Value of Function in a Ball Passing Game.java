// Weekly Contest 360 Q4
class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int upper =(int) Math.floor(Math.log(k) / Math.log(2));
        int n = receiver.size();
        int[][] next = new int[n][upper + 1];
        long[][] res = new long[n][upper + 1];
        
        int[] kBit = new int[upper + 1];
        long currK = k;
        for (int x = 0; x < n; x++) {
            next[x][0] = receiver.get(x);
            res[x][0] = receiver.get(x);
        }
        for (int i = 0; i <= upper; i++) {
            kBit[i] = (int)(currK & 1);
            currK = currK >> 1;
        }
        // System.out.println(Arrays.toString(kBit));
        for (int i = 1; i <= upper; i++) {
            for (int x = 0; x < n; x++) {
                int nxt = next[x][i - 1];
                next[x][i] = next[nxt][i - 1];
                res[x][i] = res[x][i - 1] + res[nxt][i - 1];
                // System.out.printf("x = %d, i = %d, next = %d, res = %d%n", x, i, next[x][i], res[x][i]);
            }
        }
        long ans = 0;
        for (int x = 0; x < n; x++) {
            long sum = x;
            int i = 0;
            int curr = x;
            while (i <= upper) {
                if (kBit[i] == 0) {
                    i++;
                    continue;
                }
                sum += res[curr][i];
                curr = next[curr][i];
                i++;
            }
            // System.out.println(x + "," + sum);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

// TLE simulation count circle
// class Solution {
//     public long getMaxFunctionValue(List<Integer> receiver, long k) {
//         int n = receiver.size();
//         int[] position = new int[n];
//         long[] prefix = new long[n];
//         long[] re = new long[n];
//         long ans = 0;
//         for (int i = 0; i < n; i++) {
//             int curr = i;
//             // int last = i;
//             long res = 0;
//             int count = 0;
//             boolean[] visited = new boolean[n];
//             while (!visited[curr] && count - 1 < k) {
//                 res += curr;
//                 prefix[curr] = res;
//                 visited[curr] = true;
//                 position[curr] = count++;
//                 // last = curr;
//                 curr = receiver.get(curr);
//             }
//             if (count - 1 < k) {
//                 int loopStart = curr;
//                 int loopLen = count - position[loopStart];
//                 long loopSum = res - prefix[loopStart] + loopStart;
//                 // System.out.println(loopStart + "," + loopLen + "," + loopSum);
//                 long div = (k - count + 1) / loopLen;
//                 long remain = (k - count + 1) % loopLen;
//                 res += loopSum * div;
//                 // System.out.println(div + "," + remain + "," + res);
//                 while (remain > 0) {
//                     res += curr;
//                     curr = receiver.get(curr);
//                     remain--;
//                 }
//                 // System.out.println(div + "," + remain + "," + res);
//                 int idx = 0;
//                 int head = i;
//                 int tail = curr;
//                 while (idx < count) {
//                     // System.out.println(head + "," + res);
//                     ans = Math.max(ans, res);
//                     res += tail - head;
//                     head = receiver.get(head);
//                     tail = receiver.get(tail);
//                     idx++;
//                 }
//             }
//             ans = Math.max(ans, res);
//         }
//         return ans;
//     }
// }
