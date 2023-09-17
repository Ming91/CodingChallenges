// LeetCode 75 Monotonic Stack Q2
class StockSpanner {
    Stack<int[]> stack;
    int n = 0;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            int[] prev = stack.pop();
            ans += prev[1];
        }
        stack.add(new int[] {price, ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
