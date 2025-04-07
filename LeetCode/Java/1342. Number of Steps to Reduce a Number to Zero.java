class Solution {
    public int numberOfSteps(int num) {
        if (num <= 1) {
            return num;
        } else {
            return numberOfSteps(num >> 1) + 1 + (num & 1);
        }
    }
}
