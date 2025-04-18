// LeetCode 75 Binary Search Q1
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (guess(mid) > 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
// simple binary search, care about overflow mid
