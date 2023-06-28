class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans;
        ans = new ArrayList<String>();
        HashMap<Integer, String> dict;
        dict = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        List<Integer> divisors = Arrays.asList(3, 5);
        for (int i = 1; i < n + 1; i++) {
            String ansStr = "";
            for (Integer key : divisors) {
                if (i % key == 0) {
                    ansStr += dict.get(key);
                }
            }
            if (ansStr.length() == 0) {
                ansStr = Integer.toString(i);
            }
            ans.add(ansStr);
        }
        return ans;
    }
}
