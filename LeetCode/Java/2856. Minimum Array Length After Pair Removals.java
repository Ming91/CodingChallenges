// Biweekly Contest 113 Q2
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int prev = nums.get(0);
        int count = 1;
        Queue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < n; i++) {
            if (nums.get(i) != prev) {
                prev = nums.get(i);
                p.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        p.add(count);
        while (p.size() > 1) {
            int first = p.poll();
            int second = p.poll();
            first--;
            second--;
            if (first > 0) {
                p.add(first);
            }
            if (second > 0) {
                p.add(second);
            }
        }
        return p.size() == 0 ? 0 : p.poll();
    }
}
