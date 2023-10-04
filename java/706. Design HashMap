// Daily Question 10/04/2023
class MyHashMap {
    int capacity;
    List<List<Integer>>[] entry;
    public MyHashMap() {
        capacity = 16;
        entry = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            entry[i] = new ArrayList<>();
        }
    }

    void expand() {
        int oldCap = capacity;
        capacity <<= 1;
        
        List<List<Integer>>[] newEntry = new ArrayList[capacity];
        for (int i = 0; i < oldCap; i++) {
            List<List<Integer>> high = new ArrayList<>();
            List<List<Integer>> low = new ArrayList<>();

            for (List<Integer> pair : entry[i]) {
                if ((pair.get(0) & (capacity - 1)) == i) {
                    low.add(pair);
                } else {
                    high.add(pair);
                }
            }
            newEntry[i] = low;
            newEntry[i + oldCap] = high;
        }
        entry = newEntry;
    }
    
    public void put(int key, int value) {
        int idx = key & (capacity - 1);

        for (List<Integer> pair : entry[idx]) {
            if (pair.get(0) == key) {
                pair.set(1, value);
                return;
            }
        }
        
        entry[idx].add(new ArrayList<>(Arrays.asList(key, value)));

        if (entry[idx].size() > 7) {
            expand();
        }

    }
    
    public int get(int key) {
        int idx = key & (capacity - 1);
        if (entry[idx] == null) {
            return -1;
        }
        for (List<Integer> pair : entry[idx]) {
            if (pair.get(0) == key) {
                return pair.get(1);
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        
        int idx = key & (capacity - 1);
        for (List<Integer> pair : entry[idx]) {
            if (pair.get(0) == key) {
                entry[idx].remove(pair);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
