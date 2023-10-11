// Daily Question 10/11/2023
class Solution {
    int binarySearch(int target, int[] nums, int l) {
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int[] ans = new int[n];
        int m = flowers.length;
        int[] start = new int[m];
        int[] end = new int[m];
        int[][] sortedPeople = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedPeople[i][0] = people[i];
            sortedPeople[i][1] = i;
        }
        Arrays.sort(sortedPeople, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < m; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startBefore = 0;
        int endBefore = 0;
        for (int[] p : sortedPeople) {
            while (startBefore < m && start[startBefore] <= p[0]) {
                startBefore++;
            }
            while (endBefore < m && end[endBefore] < p[0]) {
                endBefore++;
            }
            // binary search is slower, maybe because of the payload. 
            // startBefore = binarySearch(p[0] + 1, start, startBefore);
            // endBefore = binarySearch(p[0], end, endBefore);
            ans[p[1]] = startBefore - endBefore;
        }
        return ans;
    }
}
// [Beat 99%] Use sorted people and linear search to find startBefore and endBefore. 

// class Solution {
//     int binarySearch(int target, int[] nums) {
//         int l = 0;
//         int r = nums.length;
//         while (l < r) {
//             int mid = l + (r - l) / 2;
//             if (nums[mid] < target) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
//     public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//         int n = people.length;
//         int[] ans = new int[n];
//         int m = flowers.length;
//         int[] start = new int[m];
//         int[] end = new int[m];
//         for (int i = 0; i < m; i++) {
//             start[i] = flowers[i][0];
//             end[i] = flowers[i][1];
//         }
//         Arrays.sort(start);
//         Arrays.sort(end);
//         for (int i = 0; i < n; i++) {
//             int startBefore = binarySearch(people[i] + 1, start);
//             int endBefore = binarySearch(people[i], end);
//             ans[i] = startBefore - endBefore;
//         }
//         return ans;
//     }
// }
// [Editorial] Use start and end array with binary search.
//  search(p + 1, start) is the index of p+1 in start, which is #elements<=p in start.
//  search(p, end) is the index of p in end, which is #elements<=p-1 in end.
// [Editorial] Use heap to track valid flowers. 
// class Solution {
//     public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//         int n = people.length;
//         int[][] sortedPeople = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             sortedPeople[i][0] = people[i];
//             sortedPeople[i][1] = i;
//         }
//         Arrays.sort(sortedPeople, (a, b) -> Integer.compare(a[0], b[0]));
//         int l = 0;
//         int[] ans = new int[n];
//         // Filter the unnecessary flowers
//         List<int[]> sortedFlowers = new ArrayList<>();
//         for (int[] flower : flowers) {
//             if (flower[1] < sortedPeople[0][0] || flower[0] > sortedPeople[n - 1][0]) {
//                 continue;
//             }
//             sortedFlowers.add(flower);
//         }
//         sortedFlowers.sort((a, b) -> {
//             if (Integer.compare(a[0], b[0]) == 0) {
//                 return Integer.compare(a[1], b[1]);
//             }
//             return Integer.compare(a[0], b[0]);
//         });
//         sortedFlowers.sort((a, b) -> Arrays.compare(a, b));
//         int m = sortedFlowers.size();
//         Queue<Integer> q = new PriorityQueue<>();
//         for (int[] p : sortedPeople) {
//             while (l < m && sortedFlowers.get(l)[0] <= p[0]) {
//                 q.offer(sortedFlowers.get(l++)[1]);
//             }
//             while (!q.isEmpty() && q.peek() < p[0]) {
//                 q.poll();
//             }
//             ans[p[1]] = q.size();
//         }
//         // Not filter the unnecessary flowers. No big difference. 
//         // Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
//         // int m = flowers.length;
//         // Queue<Integer> q = new PriorityQueue<>();
//         // for (int[] p : sortedPeople) {
//         //     while (l < m && flowers[l][0] <= p[0]) {
//         //         q.offer(flowers[l++][1]);
//         //     }
//         //     while (!q.isEmpty() && q.peek() < p[0]) {
//         //         q.poll();
//         //     }
//         //     ans[p[1]] = q.size();
//         // }
//         return ans;
//     }
// }

// [Wrong❌][Ming] Try to use sort and sliding window, but consider this:
//  [1, 5] [3, 4] and query is 2. 
//  Here are two modifications:
//  1. we don't use sliding window but a heap/PriorityQueue to store valid flowers, 
//     if flower[0] <= p, add, if flower[1] < p, remove. 
//  2. We need to go through from left and right each, which goes to binary search solution. 
// class Solution {
//     public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//         int n = people.length;
//         int[][] sortedPeople = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             sortedPeople[i][0] = people[i];
//             sortedPeople[i][1] = i;
//         }
//         Arrays.sort(sortedPeople, (a, b) -> Integer.compare(a[0], b[0]));
//         // Queue<int[]> q = new PriorityQueue<>();
//         List<int[]> q = new ArrayList<>();
//         for (int[] flower : flowers) {
//             if (flower[1] < sortedPeople[0][0] || flower[0] > sortedPeople[n - 1][0]) {
//                 continue;
//             }
//             q.add(flower);
//         }
//         q.sort((a, b) -> {
//             if (Integer.compare(a[0], b[0]) == 0) {
//                 return Integer.compare(a[1], b[1]);
//             }
//             return Integer.compare(a[0], b[0]);
//         });
//         int m = q.size();
//         int l = 0, r = 0;
//         int[] ans = new int[n];
//         for (int[] p : sortedPeople) {
//             while (l < m && q.get(l)[1] < p[0]) {
//                 l++;
//             }
//             r = Math.max(l, r);
//             while (r < m && q.get(r)[0] <= p[0]) {
//                 r++;
//             }
//             ans[p[1]] = r - l;
//         }
//         return ans;
//     }
// }
