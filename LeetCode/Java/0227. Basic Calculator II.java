// Mid version of 224. Basic Calculator and 772. Basic Calculator III
// Use the same method to solve all 3 problems.
class Solution {

    // static Map<Character, BiFunction<Integer, Integer, Integer>> OPERATIONS;
    // static {
    //     OPERATIONS = new HashMap<>();
    //     OPERATIONS.put('+', (a, b) -> a + b);
    //     OPERATIONS.put('-', (a, b) -> a - b);
    //     OPERATIONS.put('*', (a, b) -> a * b);
    //     OPERATIONS.put('/', (a, b) -> a / b);
    // }
    
    int idx = 0;
    int calc(char op, int x, int y) {
        switch (op) {
            case '+' -> {
                return x + y;
            }
            case '-' -> {
                return x - y;
            }
            case '*' -> {
                return x * y;
            }
            case '/' -> {
                return x / y;
            }
        }
        return 0;
    }
    public int calculate(String s) {
        int n = s.length();
        int res = 0;
        int prev = 0;
        int curr = 0;
        char op = '+';
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                curr = calculate(s);
                continue;
            }
            if (c == ')') {
                break;
            }
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
                continue;
            }
            prev = calc(op, prev, curr);
            if (c == '+' || c == '-') {
                res += prev;
                prev = 0;
            }
            curr = 0;
            op = c;
        }
        return res + calc(op, prev, curr);
    }
}
// [Beat 99%] 772 top1 submission
//  use no stack, just record res and prev. 
//  if currOp = + or -, just add prev to res and clear prev.
//  if currOp = * /, still need prev for later computation.
//  But that's all we need. That's all.

// [Editorial] 772. Basic Calculator III
//  Just use one stack, store result of + and -, compute if its * or /.

// class Solution {
//     static Map<Character, BiFunction<Integer, Integer, Integer>> OPERATIONS;
//     static {
//         OPERATIONS = new HashMap<>();
//         OPERATIONS.put('+', (a, b) -> a + b);
//         OPERATIONS.put('-', (a, b) -> a - b);
//         OPERATIONS.put('*', (a, b) -> a * b);
//         OPERATIONS.put('/', (a, b) -> a / b);
//     }
//     int n;
//     int idx;
//     String s;
//     int solve() {
//         Stack<Integer> stack = new Stack<>();
//         int curr = 0;
//         char prevOp = '+';
//         while (idx < n) {
//             char c = s.charAt(idx);
//             if(c == '(') {
//                 idx++;
//                 curr = solve();
//                 idx++;
//                 continue;
//             }
//             if (Character.isDigit(c)) {
//                 curr = curr * 10 + c - '0';
//             } else {
//                 if (prevOp == '*' || prevOp == '/') {
//                     int res = OPERATIONS.get(prevOp).apply(stack.pop(), curr);
//                     stack.push(res);
//                 } else {
//                     int res = OPERATIONS.get(prevOp).apply(0, curr);
//                     stack.push(res);
//                 }
//                 if (c == ')') {
//                     break;
//                 }
//                 prevOp = c;
//                 curr = 0;
//             }
//             idx++;
//         }
//         int ans = 0;
//         while (!stack.isEmpty()) {
//             ans += stack.pop();
//         }
//         return ans;
//     }
//     public int calculate(String str) {
//         s = str + ";";
//         n = s.length();
//         idx = 0;
//         return solve();
//     }
// }

// [Ming] Naive Impl, use two stacks.
//  But works! But still naive.
// class Solution {
//     static Map<Character, BiFunction<Integer, Integer, Integer>> OPERATIONS;
//     static {
//         OPERATIONS = new HashMap<>();
//         OPERATIONS.put('+', (a, b) -> a + b);
//         OPERATIONS.put('-', (a, b) -> a - b);
//         OPERATIONS.put('*', (a, b) -> a * b);
//         OPERATIONS.put('/', (a, b) -> a / b);
//     }
//     public int calculate(String s) {
//         int n = s.length();
//         Stack<Integer> v = new Stack<>();
//         Stack<Character> op = new Stack<>();
//         var sb = new StringBuilder();
//         boolean prevIsNumber = false;
//         for (int i = 0; i < n; i++) {
//             char c = s.charAt(i);
//             switch (c) {
//                 case '+' -> {
                    
//                     if (sb.length() > 0) {
//                         v.push(Integer.valueOf(sb.toString()));
//                         sb.setLength(0);
//                     }
//                     while (op.size() > 0 && op.peek() != '(') {
//                         int r = v.pop();
//                         int l = v.pop();
//                         char o = op.pop();
//                         int res = OPERATIONS.get(o).apply(l, r);
//                         v.push(res);
//                     }
//                     op.push(c);
//                     prevIsNumber = false;
//                 }
//                 case '-' -> {
//                     if (sb.length() > 0) {
//                         v.push(Integer.valueOf(sb.toString()));
//                         sb.setLength(0);
//                     }
//                     if (!prevIsNumber) {
//                         v.push(0);
//                     }
//                     while (op.size() > 0 && op.peek() != '(') {
//                         int r = v.pop();
//                         int l = v.pop();
//                         char o = op.pop();
//                         int res = OPERATIONS.get(o).apply(l, r);
//                         v.push(res);
//                     }
//                     op.push(c);
//                     prevIsNumber = false;
//                 }
//                 case '*' -> {
//                     if (sb.length() > 0) {
//                         v.push(Integer.valueOf(sb.toString()));
//                         sb.setLength(0);
//                     }
//                     while (op.size() > 0 && op.peek() != '(' 
//                      && op.peek() != '+' && op.peek() != '-') {
//                         int r = v.pop();
//                         int l = v.pop();
//                         char o = op.pop();
//                         int res = OPERATIONS.get(o).apply(l, r);
//                         v.push(res);
//                     }
//                     op.push(c);
//                     prevIsNumber = false;
//                 }
//                 case '/' -> {
//                     if (sb.length() > 0) {
//                         v.push(Integer.valueOf(sb.toString()));
//                         sb.setLength(0);
//                     }
//                     while (op.size() > 0 && op.peek() != '(' 
//                      && op.peek() != '+' && op.peek() != '-') {
//                         int r = v.pop();
//                         int l = v.pop();
//                         char o = op.pop();
//                         int res = OPERATIONS.get(o).apply(l, r);
//                         v.push(res);
//                     }
//                     op.push(c);
//                     prevIsNumber = false;
                    
//                 }
//                 case '(' -> {
//                     if (sb.length() > 0) {
//                         v.push(Integer.valueOf(sb.toString()));
//                         sb.setLength(0);
//                     }
//                     op.push(c);
//                     prevIsNumber = false;
//                 }
//                 case ')' -> {
//                     if (sb.length() > 0) {
//                         v.push(Integer.valueOf(sb.toString()));
//                         sb.setLength(0);
//                     }
//                     while (op.peek() != '(') {
                        
//                         int r = v.pop();
//                         int l = v.pop();
//                         char o = op.pop();
//                         int res = OPERATIONS.get(o).apply(l, r);
//                         v.push(res);
//                     }
//                     op.pop();
//                     prevIsNumber = true;
//                 }
//                 case ' ' -> {
//                     if (sb.length() > 0) {
//                         v.push(Integer.valueOf(sb.toString()));
//                         sb.setLength(0);
//                     }
//                 }
//                 default -> {
//                     sb.append(c);
//                     prevIsNumber = true;
//                 }
//             }
//         }
//         if (sb.length() > 0) {
//             v.push(Integer.valueOf(sb.toString()));
//             sb.setLength(0);
//         }
//         while (!op.isEmpty()) {
                        
//             int r = v.pop();
//             int l = v.pop();
//             char o = op.pop();
//             int res = OPERATIONS.get(o).apply(l, r);
//             v.push(res);
//         }
//         return v.pop();
//     }
// }
