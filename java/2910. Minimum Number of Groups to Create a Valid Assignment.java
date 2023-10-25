// Weekly Contest 368 Q3
class Solution {
    // [jeffreyhu8]
    int groupBySize(Map<Integer, Integer> countFreq, int size) {
        int group = 0;
        for (Map.Entry<Integer, Integer> e : countFreq.entrySet()) {
            int len = e.getKey();
            int rem = len % (size + 1);
            int g = len / (size + 1);
            
            // len = g * (size + 1)
            if (rem == 0) {
                group += g * e.getValue();
                continue;
            }

            // len = g * (size + 1) + rem;
            //     = g * size + g + rem
            //     = g * size + g + rem - size + size;
            //     = (g + rem - size) * (size + 1) + (size - rem + 1) * size
            int need = size - rem;
            if (g >= need) {
                group += (g + 1) * e.getValue();
                continue;
            }
            return -1;
        }
        return group;
    }
    // [Unknown]
    //  Another iteative validation. 
    //  Split by size+1 if possible. if not, minus size if possible. 
    int partition(Map<Integer, Integer> countFreq, int size) {
        int group = 0;
        for (Map.Entry<Integer, Integer> e : countFreq.entrySet()) {
            int len = e.getKey();
            int v = e.getValue();
            while (len > 0) {
                if (len % (size + 1) == 0) {
                    group += len / (size + 1) * v;
                    break;
                }
                if (len >= size) {
                    group += v;
                    len -= size;
                } else {
                    return -1;
                }
            }

        }
        return group;
    }
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> countFreq = new HashMap<>();
        for (int c : count.values()) {
            countFreq.merge(c, 1, Integer::sum);
        }
        for (int c : countFreq.keySet()) {
            min = Math.min(min, c);
        }
        for (int size = min; size >= 1; size--) {
            // int group = groupBySize(countFreq, size);
            int group = partition(countFreq, size);
            if (group > 0) {
                return group;
            }
        }
        return -1;
    }
}
// [jeffreyhu8]
//  I didn't solve this. 
//  Since I couldn't find a suitable way to validate a partition size. 
//  Here is jeffreyhu8's way, which I found clear and simple:
//      Len % (size + 1) == 0 => just split with size+1 
//  rem=Len % (size + 1)      => we need size-rem more items to make the `rem` to be a `size`.
//  if size - rem <= len / (size + 1), we have what we need. 
//  or we can't split. 

//  If using sort rather than map, 

//  ** not possible to use binary search,
//  because maybe k-1 and k+1 are valid but k is not. 
//  [2, 2, 2, 3, 3, 3], can be 2 or 4 groups, but not 3. 
