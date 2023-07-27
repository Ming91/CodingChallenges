// LeetCode 75 Two Pointers Q3
class Solution {
    public int maxArea(int[] height) {
        // int n = height.length;
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while (l < r) {
            int min = height[l] < height[r] ? height[l] : height[r];
            // int max = height[l] + height[r] - min;
            int currArea = (r - l) * min;
            area = area < currArea ? currArea : area;
            while (l < r && height[l] <= min) {
                l++;
            }
            while (l < r && height[r] <= min) {
                r--;
            }
        }
        return area;
    }
}

// awful impl
// class Solution {
//     public int maxArea(int[] height) {
//         int n = height.length;
//         if (n == 2) {
//             return Math.min(height[0], height[1]);
//         }
//         int l, h, lDir, hDir;
//         boolean[] visited = new boolean[n];
//         Arrays.fill(visited, false);
//         if (height[0] <= height[n - 1]) {
//             l = 0;
//             h = n - 1;
//             lDir = 1;
//             hDir = -1;
//         } else {
//             l = n - 1;
//             h = 0;
//             lDir = -1;
//             hDir = 1;
//         }
//         visited[h] = true;
//         int area = (n - 1) * height[l];
//         int idx = l;
//         //System.out.println(lDir + "," + hDir);
//         while (!visited[idx]) {
//             // System.out.println(height[l] + "," + height[h]);
//             while (idx >= 0 && idx < n && !visited[idx] && height[idx] <= height[l]) {
//                 // System.out.println(idx);
//                 visited[idx] = true;
//                 idx += lDir;
//             }
//             if (idx < 0 || idx >= n || visited[idx]) {
//                 return area;
//             }
//             int currArea = 0;
//             int currHeightMin = Math.min(height[h], height[idx]);
//             int currMin = Math.min(h, idx);
//             currArea = currHeightMin * (idx + h - (currMin << 1));
//             if (currArea > area) {
                
//                 // System.out.println(height[idx] + "," + height[h] + "," + area);
//                 area = currArea;
//             } 
//             l = height[h] == currHeightMin ? h : idx;
//             h = idx + h - l;
//             if (l < h) {
//                 lDir = 1;
//                 hDir = -1;
//             } else {
//                 lDir = -1;
//                 hDir = 1;
//             }
//             idx = l + lDir;
//         }
//         return area;
//     }
// }

// TLE
// class Solution {
//     public int maxArea(int[] height) {
//         int n = height.length;
//         int max = -1;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int curr = (j - i) * Math.min(height[i], height[j]);
//                 max = max < curr ? curr : max; 
//             }
//         }
//         return max;
//     }
// }
