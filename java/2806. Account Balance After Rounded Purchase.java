// Biweekly Contest 110 Q1
class Solution {
    public int accountBalanceAfterPurchase(int p) {
        return 100 - (int)Math.round((double)p / 10) * 10;
    }
}
