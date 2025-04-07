// Top Interview 150 Linked List Q11
 class LRUCache {
    int capacity;
    int count;
    Node head;
    Node tail;
    Node[] dict;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node() {

        }
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next= tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        dict = new Node[10_001];
    }
    
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return;
    }

    public void add(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        return;
    }
    public int get(int key) {
        if (dict[key] != null) {
            Node node = dict[key];
            remove(node);
            add(node);
            return dict[key].val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (dict[key] != null) {
            Node node = dict[key];
            remove(node);
            add(node);
            node.val = value;
            // 不能用下面的,需要在原来的node上维护
            // 新node不在list里面
            // dict[node.key] = new Node(key, value);
        } else {
            Node node = new Node(key, value);
            dict[key] = node;
            if (count < capacity) {
                count++;
            } else {
                Node t = tail.prev;
                remove(t);
                dict[t.key] = null;
            }
            add(node);
        }
        //     if (count == capacity) {
        //         Node node = tail.prev;
        //         remove(node);
        //         dict[node.key] = null;
        //         count--;
        //     }
        //     count++;
        //     Node node = new Node(key, value);
        //     add(node);
        //     dict[key] = node;
        // }
    }
}

// 用node[]作为hashmap来存key->node的pair
// 用hashmap好像更慢
// 更新只用找到dict[key],remove再add一下,并且更新一下val就行

// Top Interview 150 09/21/2023 Impl
// Not good, should use head.next and tail.prev;
// class LRUCache {
//     class Node {
//         int val;
//         int key;
//         Node prev;
//         Node next;
//         Node() {}
//         Node(int k, int v) {
//             val = v;
//             key = k;
//         }
//         public String toString() {
//             String s = "";
//             s += " key:" + key;
//             s += " val:" + val;
//             s += " prev:" + (prev == null ? "null" : prev.key);
//             s += " next:" + (next == null ? "null" : next.key);
//             return s;
//         }
//     }
//     Map<Integer, Node> map;
//     Node head;
//     Node tail;
//     int capacity;
//     int count;

//     public LRUCache(int capacity) {
//         map = new HashMap<>();
//         this.capacity = capacity;
//         count = 0;
//         head = null;
//     }
    
//     public int get(int key) {
//         if (!map.containsKey(key)) {
//             return -1;
//         }
//         Node curr = map.get(key);
//         // System.out.println("Curr noed" + curr.toString());
//         // System.out.println("Tail Before:" + tail.key + "," + tail.val);
//         update(curr);
//         // System.out.println("Tail After:" + tail.key + "," + tail.val);
//         return curr.val;
//     }
    
//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             Node curr = map.get(key);
//             curr.val = value;
//             update(curr);
//             return ;
//         }
//         if (count == capacity) {
//             // System.out.println("Remove:" + tail.key + "," + tail.val);
//             remove();
//         }
//         Node curr = new Node(key, value);
//         insert(curr);
//     }
//     private void insert(Node curr) {
//         count++;
//         map.put(curr.key, curr);
//         if (count == 1) {
//             head = curr;
//             tail = curr;
//             return ;
//         }
//         curr.next = head;
//         curr.prev = null;
//         head.prev = curr;
//         head = curr;
//     }
//     private void update(Node curr) {
//         if (head == curr) {
//             return ;
//         }
//         if (tail == curr) {
//             tail = tail.prev;
//         } else {
//             curr.next.prev = curr.prev;
//         }
//         curr.prev.next = curr.next;
//         curr.next = head;
//         curr.prev = null;
//         head.prev = curr;
//         head = curr;
//     }

//     private void remove() {
//         count--;
//         map.remove(tail.key);
//         tail = tail.prev;
//         if (tail == null) {
//             head = null;
//         } else {
//             tail.next = null;
//         }
//     }
// }

 
// use linkedlist, the cost of find a existing key and update tooo large
// TLE
// class LRUCache {
//     int capacity;
//     LinkedList<Integer> cache;
//     int[] pairs = new int[100_000];
//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         cache = new LinkedList<>();
//     }
    
//     public int get(int key) {
//         //boolean found = cache.remove(Integer.valueOf(key));
//         if (pairs[key] != 0) {
//             cache.addLast(key);
//             return pairs[key] - 1;
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         boolean found = cache.remove(Integer.valueOf(key));
//         if (cache.size() == capacity) {
//             Integer idx = cache.removeFirst();
//             pairs[idx] = 0;
//         }
//         cache.addLast(key);
//         pairs[key] = 0;
//         pairs[key] = value + 1;
//     }
// }
// built in linkedhashmap
// class LRUCache {
//     Map<Integer, Integer> cache;
//     public LRUCache(int capacity) {
//         cache = new LinkedHashMap<>(5, 0.75f, true) {
//             @Override
//             protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                 return size() > capacity;
//             }
//         };
//     }
    
//     public int get(int key) {
//         return cache.getOrDefault(key, -1);
//     }
    
//     public void put(int key, int value) {
//         cache.put(key, value);
//     }
// }
