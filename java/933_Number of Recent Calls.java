// LeetCode 75 Queue Q1
class RecentCounter {
    LinkedList<Integer> q;
    public RecentCounter() {
        q = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        // remove last 要找到倒数第二个
        // 还是addlast 和 removefirst更快
        // 然而这是错误的结论, jdk中用的双向链表, 都一样
        q.addLast(t);
        while (q.getFirst() < t - 3000) {
            q.removeFirst();
        }
        return q.size();
    }
}
// use linked list is faster

// class RecentCounter {
//     Queue<Integer> q;
//     public RecentCounter() {
//         q = new PriorityQueue<>();
//     }
    
//     public int ping(int t) {
//         q.offer(t);
//         while (q.peek() < t - 3000) {
//             q.poll();
//         }
//         return q.size();
//     }
// }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
