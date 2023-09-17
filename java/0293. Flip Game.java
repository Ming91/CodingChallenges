class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        int n = currentState.length();
        if (n < 2) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                StringBuilder curr = new StringBuilder(currentState);
                curr.setCharAt(i, '-');
                curr.setCharAt(i + 1, '-');
                ans.add(curr.toString());
            }
        }
        return ans;
    }
}
