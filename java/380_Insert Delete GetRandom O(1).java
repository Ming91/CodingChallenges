// Top Interview 150 Array / String Q12
class RandomizedSet {
    Map<Integer, Integer> dict;
    static final int INIT_CAPACITY = 16;
    // List<Integer> arr;
    int[] data;
    int capacity;
    int len;
    Random rand;
    public RandomizedSet() {
        dict = new HashMap<>();
        // arr = new ArrayList<>();
        data = new int[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
        len = 0;
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        // dict.put(val, arr.size());
        // arr.add(val);
        dict.put(val, len);
        data[len++] = val;
        if (len == capacity) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
        return true;
    }
    
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        
        int idx = dict.get(val);
        // int temp = arr.get(arr.size() - 1);
        // arr.set(idx, temp);
        // arr.remove(arr.size() - 1);
        int temp = data[len - 1];
        data[idx] = temp;
        len--;
        dict.put(temp, idx);
        dict.remove(val);
        return true;
    }
    
    public int getRandom() {
        // return arr.get(rand.nextInt(arr.size()));
        return data[rand.nextInt(len)];
    }
}

// learn from editorial
// make a list and hashmap, when insert(not added before) add to end, map value->idx
// when remove, swap the target with the last element, and remove last element
// try to impl list by self

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
