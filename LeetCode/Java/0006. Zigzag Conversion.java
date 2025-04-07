// Top Interview 150 Array / String Q22
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int len = numRows * 2 - 2;
        int step = len;
        int curr = 0;
        // while (curr < n) {
        //     sb.append(s.charAt(curr));
        //     curr += step;
        // }
        // step -= 2;
        for (int i = 0; i < numRows; i++) {
            curr = i;
            while (curr < n) {
                // [Ming] version 1
                // sb.append(s.charAt(curr));
                // if (i != 0 && i != numRows - 1) {
                //     if (curr + step < n) {
                //         sb.append(s.charAt(curr + step));
                //     }
                // }
                // curr += len;

                // [Beat 99%] version 2
                // See it as two n - 1 lines, each start point i left i % (n - 1) length.
                // Add this length twice to i is the next point. 
                sb.append(s.charAt(curr));
                curr += len - ((curr % (numRows - 1)) << 1);
            }
            
            // step -= 2;
        }
        // curr = numRows - 1;
        // while (curr < n) {
        //     sb.append(s.charAt(curr));
        //     curr += len;
        // }
        return sb.toString();
    }
}
// [Ming] ugly sim
// class Solution {
//     public String convert(String s, int numRows) {
//         if (numRows == 1) {
//             return s;
//         }
//         int n = s.length();
//         int unitLen = (numRows << 1) - 2;
//         int unitWid = numRows - 1;
//         // int unitCount = n / unitLen;
//         // int remain = n % unitLen;
//         // int remainWid = remain == 0 ? 0 : 1;
//         // if (remain > numRows) {
//         //     remainWid += remain - numRows;
//         // } 
//         // int col = remainWid + unitWid * unitCount;

//         // approximate col estimate
//         int col = (n + unitLen - 1) / unitLen * unitWid;
//         // System.out.println(numRows + "," + col);
//         char[][] ch = new char[numRows][col];
//         int c = 0;
//         int i = 0;
//         while (i < n) {
//             int zig = Math.min(numRows, n - i);
//             int r = 0;
//             while (r < zig) {
//                 ch[r++][c] = s.charAt(i++);
//             }
//             int zag = Math.min(numRows - 2, n - i);
//             r = Math.max(0, numRows - 2);
//             c++;
//             while (r >= numRows - 1 - zag) {
//                 ch[r--][c++] = s.charAt(i++);
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for (i = 0; i < numRows; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (ch[i][j] > 0) {
//                     sb.append(ch[i][j]);
//                 }   
//             }
//         }
//         return sb.toString();
//     }
// }
