// Daily Question 11/05/2023
class Solution {
    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                count = 1;
            } else {
                count++;
            }
            if (count == k) {
                return max;
            }
        }
        return max;
    }
}
// [Beat 99%]
//  If no winner get k wins in the end, the max one will be kept until k wins. 

// [Ming] Ugly Sim
// class Solution {
//     public int getWinner(int[] arr, int k) {
//         if (k > arr.length) {
//             int max = 0;
//             for (int a : arr) {
//                 max = Math.max(max, a);
//             }
//             return max;
//         }
//         Deque<Integer> dq = new ArrayDeque<>();
//         for (int a : arr) {
//             dq.addLast(a);
//         }
//         int max = dq.removeFirst();
//         int count = 0;
//         int next = dq.removeFirst();
//         while (count < k) {
//             if (next > max) {
//                 dq.addLast(max);
//                 max = next;
//                 count = 1;
//             } else {
//                 dq.addLast(next);
//                 count++;
//             }
//             next = dq.removeFirst();
//         }
//         return max;
//     }
// }
