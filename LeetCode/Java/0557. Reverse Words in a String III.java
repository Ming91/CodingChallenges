// Daily Question 10/01/2023
class Solution {
    public String reverseWords(String s) {
        String[] seperated = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = seperated.length - 1; i >= 0; i--) {
            sb.append(seperated[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.reverse().toString();
    }
}
