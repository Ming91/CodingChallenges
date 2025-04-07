// Daily Challenge 08/28/2023
class MyStack {
    Queue<Integer> stack;
    int top;
    public MyStack() {
        stack = new LinkedList<>();
        top = -1;
    }
    
    public void push(int x) {
        int sz = stack.size();
        stack.add(x);
        top = x;
        while (sz > 0) {
            stack.add(stack.remove());
            sz--;
        }
        return ;
    }
    
    public int pop() {
        int res = stack.remove();
        if (stack.size() == 0) {
            top = -1;
            return res;
        }
        top = stack.remove();
        int sz = stack.size();
        stack.add(top);
        while (sz > 0) {
            stack.add(stack.remove());
            sz--;
        }
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return stack.size() == 0;
    }
}
// One queue,

// peek allowed, can be simpler.

// Two queue, push O(1), pop O(n)
// class MyStack {
//     Queue<Integer> curr;
//     Queue<Integer> prev;
//     Queue<Integer> temp;
//     int top;
//     public MyStack() {
//         curr = new LinkedList<>();
//         prev = new LinkedList<>();
//         temp = new LinkedList<>();
//         top = -1;
//     }
    
//     public void push(int x) {
//         // while (!prev.isEmpty()) {
//         //     curr.add(prev.poll());
//         // }
//         curr.add(x);
//         top = x;
//     }
    
//     public int pop() {
//         if (curr.size() < 1) {
//             return -1;
//         }
//         while (curr.size() > 1) {
//             top = curr.poll();
//             prev.add(top);
//         }
//         int res = curr.poll();
//         temp = curr;
//         curr = prev;
//         prev = temp;
//         return res;
//     }
    
//     public int top() {
//         return top;
//     }
    
//     public boolean empty() {
//         return curr.size() == 0;
//     }
// }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
