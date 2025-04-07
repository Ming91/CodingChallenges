// Daily Question 10/20/2023
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    Deque<Iterator> stack;
    Integer peeked;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        peeked = null;
        stack.addLast(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer res = peeked;
        peeked = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        setPeeked();
        return peeked != null;
    }

    void setPeeked() {
        if (peeked != null) {
            return;
        }
        while (!stack.isEmpty()) {
            if (!stack.peekLast().hasNext()) {
                stack.removeLast();
                continue;
            }
            // we need to process the newest iterator,
            // but it's a iterator, we can't remove it unless !hasNext()
            // which is in the previous check. 
            NestedInteger nt = (NestedInteger)(stack.peekLast().next());
            if (nt.isInteger()) {
                peeked = nt.getInteger();
                return;
            }
            stack.addLast(nt.getList().iterator());
        }
    }
}

// [Editorial] Flatten the list with recursion. 
// public class NestedIterator implements Iterator<Integer> {
//     List<Integer> data = new ArrayList<>();
//     int idx = 0;
//     public NestedIterator(List<NestedInteger> nestedList) {
//         flattenList(nestedList);
//     }
//     public void flattenList(List<NestedInteger> nestedList) {
//         for (NestedInteger nt : nestedList) {
//             if (nt.isInteger()) {
//                 data.add(nt.getInteger());
//             } else {
//                 flattenList(nt.getList());
//             }
//         }
//     }
//     @Override
//     public Integer next() {
//         if (!hasNext()) {
//             // throw new NoSuchElementException();
//             return null;
//         }
//         return data.get(idx++);
//     }

//     @Override
//     public boolean hasNext() {
//         return idx < data.size();
//     }
// }
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
