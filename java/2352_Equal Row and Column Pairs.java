// LeetCode 75 Hash Map / Set Q4
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        List<int[]> row = new ArrayList<>();
        List<int[]> col = new ArrayList<>();
        for (int[] r : grid) {
            row.add(r);
            // 熟练使用Arrays.toString();
            // 用hashmap的方法也用得上
            // System.out.println(Arrays.toString(r));
        }
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j ++) {
                temp[j] = grid[j][i];
            }
            col.add(temp);
            // System.out.println(Arrays.toString(temp));
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // object.equals() 错误用法
                // if (row.get(i).equals(col.get(j))) {
                if (Arrays.equals(row.get(i), col.get(j))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
// 用list和arrays.equal来替代hashmap, 

// 还有很多更快的方法用自己的prime base来算hashcode
//  (即把prime当作base, 例如将数堪称29进制然后展开, 靠integer的范围来做mod)
// 再用于hashmap

// use String as key
// can upgrade by using Arrays.toString(grid[]);

// class Solution {
//     public int equalPairs(int[][] grid) {
//         int n = grid.length;
//         Map<String, Integer> row = new HashMap<>();
//         Map<String, Integer> col = new HashMap<>();

//         StringBuilder r = new StringBuilder();
//         StringBuilder c = new StringBuilder();
//         String rs = "";
//         String cs = "";
//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             r.setLength(0);
//             c.setLength(0);
//             for (int j = 0; j < n; j++) {
//                 r.append(grid[i][j]);
//                 r.append(",");
//                 c.append(grid[j][i]);
//                 c.append(",");
//             }
//             rs = r.toString();
//             cs = c.toString();
//             int temp = col.getOrDefault(rs, 0);
//             ans += temp;
//             row.put(rs, row.getOrDefault(rs, 0) + 1);
//             temp = row.getOrDefault(cs, 0);
//             ans += temp;
//             col.put(cs, col.getOrDefault(cs, 0) + 1);
//         }
//         return ans;
//     }
// }
