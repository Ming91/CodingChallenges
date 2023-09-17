// LeetCode 75 Hash Map / Set Q2
// use array
// class Solution {
//     // range from -1000 to 1000;
//     static int BASE = 1_000;
//     static int RANGE = 2_000;
//     public boolean uniqueOccurrences(int[] arr) {
//         int n = arr.length;
//         int[] count = new int[RANGE + 1];
//         boolean[] notUni = new boolean[n + 1];
//         boolean[] visited = new boolean[RANGE + 1];
//         int[] set = new int[n];
//         int size = 0;
//         for (int a : arr) {
//             if (count[a + BASE] == 0) {
//                 set[size++] = a + BASE;
//             }
//             count[a + BASE]++;
//         }
//         for (int i = 0; i < size; i++) {
            
//             if (!visited[set[i]] && notUni[count[set[i]]]) {
//                 // System.out.printf("%d, %d, %b%n", set[i] - BASE, count[set[i]], notUni[count[set[i]]]);
//                 return false;
//             }
//             notUni[count[set[i]]] = true;
//             visited[set[i]] = true;
//         }
//         return true;
//     }
// }

// use arr w/ set, need to upgrade with range (min, max)
// class Solution {
//     // range from -1000 to 1000;
//     static int BASE = 1_000;
//     static int RANGE = 2_000;
//     public boolean uniqueOccurrences(int[] arr) {
//         int n = arr.length;
//         int[] count = new int[RANGE + 1];
//         for (int a : arr) {
//             count[a + BASE]++;
//         }
//         Set<Integer> set = new HashSet<>();
//         for (int i = 0; i < RANGE; i++) {
//             if (count[i] > 0 && set.contains(count[i])) {
//                 return false;
//             }
//             if (count[i] > 0) {
//                 set.add(count[i]);
//             }
//         }
//         return true;
//     }
// }

// use default collection
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        if (set.size() < map.size()) {
            return false;
        }
        return true;
//     }
    }
}

// use own obj to acc put()
// class Solution {
//     class MyInt{
//         int val;
//         MyInt(int val) {
//             this.val = val;
//         }
//     }
//     public boolean uniqueOccurrences(int[] arr) {
//         int n = arr.length;
//         Map<Integer, MyInt> map = new HashMap<>();
//         for (int num : arr) {
//             MyInt i = map.getOrDefault(num, new MyInt(0));
//             i.val++;
//             map.put(num, i);
//         }
//         Set<Integer> set = new HashSet<>();
//         for (MyInt i : map.values()) {
//             if (set.contains(i.val)) {
//                 return false;
//             }
//             set.add(i.val);
//         }
//         return true;
//     }
// }
