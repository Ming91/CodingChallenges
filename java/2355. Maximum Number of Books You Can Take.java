// Weekly Premium Oct 2023 W3
class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        int[] idx = new int[n];
        idx[0] = -1;
        for (int i = 1; i < n; i++) {
            if (books[i] > books[i - 1] + 1) {
                idx[i] = i - 1;
                continue;
            }
            // books[i - 1] >= books[i] - 1, => 1 >= books[i] - books[i-1]
            // so we can skip j = i - 1 and go to the next which is idx[i-1]. 
            int j = idx[i - 1];
            // prev version: " i - j > books[i] - books[j] "
            //  >= version is better, 
            //  can have real prev idx that not belongs to curr Trapezoid.
            while (j >= 0 && i - j >= books[i] - books[j]) {
                j = idx[j];
            }
            idx[i] = j;
        }
        // System.out.println(Arrays.toString(idx));
        long[] dp = new long[n];
        long ans = books[0];
        dp[0] = books[0];
        for (int i = 1; i < n; i++) {
            int prevIdx = idx[i];
            int len = Math.min(books[i], i - prevIdx);
            long prev = ((long)books[i] + books[i] - len + 1) * len / 2;
            if (prevIdx >= 0) {
                dp[i] = dp[prevIdx] + prev;
            } else {
                dp[i] = prev;
            }
            ans = Math.max(ans, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return ans;
    }
}
// [Editorial] 
//  A complex DP. 
//  dp[i] is the value that take book[i] as end. 
//  The key point is how to find the suitable dp[j] to transfer. 
//  The idea is to divide the shelf into multiple trapezoids, 
//      we only need to find the last trapezoid end index j, 
//      then [j+1 ~ i] is a trapezoid that we can use function to calculate. 

//  Either use monotonic stack or pre calculated array, 
//  the key point is to keep index j that i - j >= books[i] - books[j],
//  which means j have enough books to be as the start of the trapezoid that end at i. 

// class Solution {
//     long calc(int end, int len) {
//         len = Math.min(end, len);
//         return ((long)end + end - len + 1) * len / 2;
//     }
//     public long maximumBooks(int[] books) {
//         int n = books.length;
//         long[] dp = new long[n + 1];
//         Deque<Integer> stack = new ArrayDeque<>();
//         long max = 0;
//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && books[stack.peek()] >= books[i] - (i - stack.peek())) {
//                 stack.pop();
//             }
//             int top = stack.isEmpty() ? -1 : stack.peek();
//             long prev = dp[top + 1];
//             dp[i + 1] = prev + calc(books[i], i - top);
//             max = Math.max(max, dp[i + 1]);
//             stack.push(i);
//         }
//         // System.out.println(Arrays.toString(dp));
//         return max;
//     }
// }
