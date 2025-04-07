// Top Interview 150 Stack Q3
class MinStack {
    int[] data;
    int len;
    int capacity;
    int[] min;

    public MinStack() {
        data = new int[16];
        min = new int[16];
        capacity = 16;
        len = 0;
    }

    public void push(int val) {
        if (len == capacity) {
            capacity <<= 1;
            data = Arrays.copyOf(data, capacity);
            min = Arrays.copyOf(min, capacity);
        }

        if (len == 0) {
            min[0] = val;
        } else {
            min[len] = Math.min(min[len - 1], val);
        }
        data[len++] = val;
    }

    public void pop() {
        len--;
    }

    public int top() {
        return data[len - 1];
    }

    public int getMin() {
        return min[len - 1];
    }
}
// min[] can be improved by using smaller size.
// just record the curr [min, count], count means this min used how many times in this place

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
