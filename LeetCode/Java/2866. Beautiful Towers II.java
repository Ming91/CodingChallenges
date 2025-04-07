// Weekly Contest 364 Q3
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] prev = new long[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            long curr = maxHeights.get(i);
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > curr) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prev[i] = curr * (i + 1);
            } else {
                int p = stack.peek();
                prev[i] = prev[p] + curr * (i - p);
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(prev));
        long ans = 0;
        long[] succ = new long[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            long curr = maxHeights.get(i);
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > curr) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                succ[i] = curr * (n - i);
            } else {
                int p = stack.peek();
                succ[i] = succ[p] + curr * (p - i);
            }
            stack.push(i);
            ans = Math.max(ans, prev[i] + succ[i] - curr);
        }
        return ans;
    }
}
