class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>();
        for (int c : candies) {
            if (c > max) {
                max = c;
            }
        }
        max -= extraCandies;
        for (int c : candies) {
            result.add(c >= max);
        }
        return result;
    }
}
