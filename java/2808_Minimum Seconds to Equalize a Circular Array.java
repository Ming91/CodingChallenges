// Biweekly Contest 110 Q3
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> numPos = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            List<Integer> l = numPos.getOrDefault(num, new ArrayList<>());
            if (!l.isEmpty()) {
                l.add(i);
                continue;
            }
            l.add(i);
            numPos.put(num, l);
        }
        int minMaxGap = nums.size();
        for (List<Integer> l : numPos.values()) {
            if (l.size() == 1) {
                continue;
            }
            int maxGap = 0;
            for (int i = 1; i < l.size(); i++) {
                maxGap = Math.max(maxGap, l.get(i) - l.get(i - 1));
            }
            maxGap = Math.max(maxGap, nums.size() - l.get(l.size() - 1) + l.get(0));
            minMaxGap = Math.min(minMaxGap, maxGap);
        }
        return minMaxGap >> 1;
    }
}
// 找每个数的max gap, 所有里面最小的max gap对应的数就该选为目标

// 自己的想法: 二分搜索, 每个待定值k, 可以通过看每个元素前后k个数组成的set,
//            这些set如果有共同元素, 则说明可以.
//            但是好像不是太好操作, 但是验证的这个过程, 可以向gap的方法靠近
