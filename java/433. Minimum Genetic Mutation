// Top Interview 150 Graph BFS Q2
class Solution {
    boolean isMutation(String s, String t) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        int bankSize = bank.length;
        int n = bankSize + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Set<Integer> end = new HashSet<>();
        int end = -1;
        for (int i = 0; i < bankSize; i++) {
            if (isMutation(startGene, bank[i])) {
                adj.get(0).add(i + 1);
                adj.get(i + 1).add(0);
            }
            if (endGene.equals(bank[i])) {
                end = i + 1;
                continue;
            }
        }
        if (end < 0) {
            return -1;
        }
        for (int i = 0; i < bankSize; i++) {
            for (int j = i + 1; j < bankSize; j++) {
                if (isMutation(bank[i], bank[j])) {
                    adj.get(i + 1).add(j + 1);
                    adj.get(j + 1).add(i + 1);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            while (size > 0) {
                int curr = q.poll();
                visited[curr] = true;
                for (int next : adj.get(curr)) {
                    if (visited[next]) {
                        continue;
                    }
                    if (next == end) {
                        return ans;
                    }
                    q.add(next);
                }
                size--;
            }
        }
        return -1;
    }
}
