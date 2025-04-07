// Weekly Contest 356 Q1
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            count += hour >= target ? 1 : 0;
        }
        return count;
    }
}
