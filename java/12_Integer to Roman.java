// Top Interview 150 Array / String Q18
class Solution {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
// [Ming]
// class Solution {
//     static final String[][] DICT = new String[][] {
//         {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
//         {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
//         {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
//         {"", "M", "MM", "MMM"},
//     };
//     public String intToRoman(int num) {
//         StringBuilder sb = new StringBuilder();
//         int digits = 0;
//         while (num > 0) {
//             sb.insert(0, DICT[digits++][num % 10]);
//             num /= 10;
//         }
//         return sb.toString();
//     }
// }

