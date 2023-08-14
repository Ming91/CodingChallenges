// LeetCode 75 Heap / Priority Queue Q2
class SmallestInfiniteSet {

    TreeSet<Integer> s;
    // Queue<Integer> s;
    int min;

    public SmallestInfiniteSet() {
        s = new TreeSet<>();
        // s = new PriorityQueue<>();
        min = 1;
    }
    
    public int popSmallest() {
        int res = 0;
        if (!s.isEmpty()) {
            res = s.pollFirst();
            // res = s.poll();
        } else {
            res = min++;
        }
        return res;
    }
    
    public void addBack(int num) {
        if (num < min) {
            s.add(num);
        }
        return ;
    }
}
// use TreeSet to achieve real 'infinite' size
// can't use priority queue, it has duplicate elements

// use boolean[1_001] to impl the operations
// fast, but kind of tricky, not a good practice
// class SmallestInfiniteSet {

//     boolean[] count;
//     int min;

//     public SmallestInfiniteSet() {
//         count = new boolean[1_001];
//         // Arrays.fill(count, false);
//         min = 1;
//     }
    
//     public int popSmallest() {
//         count[min] = true;
        
//         for (int i = min + 1; i < 1_001; i++) {
//             if (!count[i]) {
//                 int temp = min;
//                 min = i;
//                 return temp;
//             }
//         }
//         return min;
//     }
    
//     public void addBack(int num) {
//         count[num] = false;
//         min = Math.min(min, num);
//         return ;
//     }
// }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
