// Biweekly Contest 115 Q1
class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        int n = words.size();
        int[] stack = new int[n];
        int len = 0;
        int curr = -1;
        List<Integer> ans = new ArrayList<>();
        for (String word : words) {
            if (word.equals("prev")) {
                ans.add(curr < 0 ? -1 : stack[curr--]);
            } else {
                stack[len++] = Integer.valueOf(word);
                curr = len - 1;
            }
        }
        return ans;
    }
}
