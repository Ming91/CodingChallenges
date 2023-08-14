# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
For `sum` bananas, Koko needs to eat at least `(sum + h - 1) / h` bananas in order to eat all bananas in `h` hours. It's an alternative version of `ceil()`.

Let `sum` be the sum of total bananas.

For the lower bound estimate, we select `(sum + h - 1) / h`. Since if we select any smaller number `x`, `h * x < sum`. Koko can't eat all bananas in `h` hours even though there is only one pile.

For the upper bound estimate, consider the **worst** situation which is: **we have `n - 1` piles with only `1` banana and the left one has `sum - n + 1` bananas.**

In this situation, Koko needs to eat `sum - n + 1` bananas in `h - n + 1` hours. Using the method above, we can see the upper bound is `(sum - n + 1 + (h - n + 1) - 1) / (h - n + 1)`, which is `(sum + h + 1 - (n << 1)) / (h - n + 1)`.

# Approach
<!-- Describe your approach to solving the problem. -->
Use binary search to check for all possible answers in the range `[l, r]`.

# Complexity
- Time complexity: $O(n \cdot logn)$ 
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $O(1)$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```Java
// LeetCode 75 Binary Search Q4
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long sum = 0L;
        for (int pile : piles) {
            sum += pile;
        }
        int l = (int) ((sum + h - 1) / h);
        // n piles need at least n hours, (h - n + 1) remaining hours for last pile
        // sum - n + 1 remaining bananas
        int r = (int) ((sum + h + 1 - (n << 1)) / (h - n + 1));    
        while (l < r) {
            int mid = (l + r) >> 1;
            // don't use function, same copy time
            int time = 0;
            for (int num : piles) {
                time += (num + mid - 1) / mid;
            }
            if (time > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
```
