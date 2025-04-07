// Top Interview 150 Hashmap Q7
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n > 1) {
            if (n == 1) {
                return true;
            }
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            int res = 0;
            while (n > 0) {
                int k = n % 10;
                res += k * k;
                n /= 10;
            }
            n = res;
        }
        return true;
    }
}
// 9 -> 81, 99 -> 162, 999 -> 243
// so, more than 3 digits always go down to no more than 243
// **can use hashset since will not go infinite

// if go through all 243, can be a map problem, detect the loop!

// can even use hard-coded loop, only one: 4-16-37-58-89-145-42-20
// **can just check n != 1 && n != 4, for simpler structure.
