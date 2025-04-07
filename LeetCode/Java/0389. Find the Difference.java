// Dailly Question 09/24/2023
class Solution {
    public char findTheDifference(String s, String t) {
        int a = 0;
        for (char c : s.toCharArray()) {
            a = a ^ c;
        }
        for (char c : t.toCharArray()) {
            a = a ^ c;
        }
        return (char) a;
    }
}
