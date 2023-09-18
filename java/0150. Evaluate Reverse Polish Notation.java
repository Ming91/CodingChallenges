// Top Interview 150 Stack Q4
// 09/18/2023 Impl
class Solution {
    String[] tokens;
    int idx;
    int eval() {
        String str = tokens[idx--];
        switch (str) {
            case "+" -> {
                int r = eval();
                int l = eval();
                return l + r;
            }
            case "-" -> {
                int r = eval();
                int l = eval();
                return l - r;
                
            }
            case "*" -> {
                int r = eval();
                int l = eval();
                return l * r;
                
            }
            case "/" -> {
                int r = eval();
                int l = eval();
                return l / r;
                
            }
            default -> {
                return Integer.valueOf(str);
            }
        }
    }
    public int evalRPN(String[] tokens) {
        this.tokens = tokens;
        idx = tokens.length - 1;
        return eval();
    }
}
// Recall for Solving 439. Ternary Expression Parser
// class Solution {
//     String[] tokens;
//     int idx;
//     private int eval() {
//         String tk = tokens[idx--];
//         int r, l;
//         switch (tk) {
//             case ("+"):
//                 r = eval();
//                 l = eval();
//                 return l + r;
//             case ("-"):
//                 r = eval();
//                 l = eval();
//                 return l - r;
//             case ("*"):
//                 r = eval();
//                 l = eval();
//                 return l * r;
//             case ("/"):
//                 r = eval();
//                 l = eval();
//                 return l / r;
//             default:
//                 return Integer.valueOf(tk);
//         }
//     }
//     public int evalRPN(String[] tokens) {
//         this.tokens = tokens;
//         this.idx = tokens.length - 1;
//         return eval();
//     }
// }
// beat 99%:
//  no stack, just recursive from end
//  beautiful use of index, no duplicate calls

// use lambda and BiFunction<Integer, Integer, Integer>
// class Solution {
//     private static final 
//         Map<
//             String, 
//             BiFunction<Integer, Integer, Integer>
//         > OPERATIONS = new HashMap<>();
//     static {
//         OPERATIONS.put("+", (a, b) -> a + b);
//         OPERATIONS.put("-", (a, b) -> a - b);
//         OPERATIONS.put("*", (a, b) -> a * b);
//         OPERATIONS.put("/", (a, b) -> a / b);
//     }
    
//     public int evalRPN(String[] tokens) {
//         Stack<Integer> v = new Stack<Integer>();
//         for (String tk : tokens) {
//             if (!OPERATIONS.containsKey(tk)) {
//                 v.push(Integer.valueOf(tk));
//                 continue;
//             }
//             int r = v.pop();
//             int l = v.pop();
//             BiFunction<Integer, Integer, Integer> func = OPERATIONS.get(tk);
//             v.push(func.apply(l, r));
//         }
//         return v.pop();
//     }
// }


// use string.contains()

// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<Integer> v = new Stack<Integer>();
//         for (String tk : tokens) {
//             if (!"+-*/".contains(tk)) {
//                 v.push(Integer.valueOf(tk));
//                 continue;
//             }
//             int r = v.pop();
//             int l = v.pop();
//             switch (tk) {
//                 case "+":
//                     v.push(l + r);
//                     break;
//                 case "-":
//                     v.push(l - r);
//                     break;
//                 case "*":
//                     v.push(l * r);
//                     break;
//                 case "/":
//                     v.push(l / r);
//                     break;
//             }
//         }
//         return v.pop();
//     }
// }

// intuition
// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<Integer> v = new Stack<Integer>();
//         int l, r;
//         for (String tk : tokens) {
//             switch (tk) {
//                 case ("+"):
//                     r = v.pop();
//                     l = v.pop();
//                     v.push(l + r);
//                     break;
//                 case ("-"):
//                     r = v.pop();
//                     l = v.pop();
//                     v.push(l - r);
//                     break;
//                 case ("*"):
//                     r = v.pop();
//                     l = v.pop();
//                     v.push(l * r);
//                     break;
//                 case ("/"):
//                     r = v.pop();
//                     l = v.pop();
//                     v.push(l / r);
//                     break;
//                 default:
//                     v.push(Integer.valueOf(tk));
//                     break;
//             }
//         }
//         return v.pop();
//     }
// }
