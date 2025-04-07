// Biweekly Contest 113 Q3
class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        
        int n = coordinates.size();
        Map<List<Integer>, Integer> dict = new HashMap<>();
        int ans = 0;
        for (List<Integer> c : coordinates) {
            int x1 = c.get(0);
            int y1 = c.get(1);
            for (int res = 0; res <= k; res++) {
                int x2 = x1 ^ res;
                int y2 = y1 ^ (k - res);
                ans += dict.getOrDefault(List.of(x2, y2), 0);
            }
            dict.put(List.of(x1, y1), dict.getOrDefault(List.of(x1, y1), 0) + 1);
        }
        return ans;

    }
}
