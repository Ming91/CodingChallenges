class Solution {
    public int maximumWealth(int[][] accounts) {
        // m*n i,j, i c in j bank
        int wealth_max = -1;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            wealth_max = wealth > wealth_max ? wealth : wealth_max;
        }
        return wealth_max;
    }
}
