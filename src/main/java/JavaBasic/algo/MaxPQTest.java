package JavaBasic.algo;

// Princeton Algorithms, Page 315

/**
 * In computer science, a heap is a specialized tree-based data structure which
 * is essentially an almost complete tree that satisfies the heap property:
 * in a max heap, for any given node C, if P is a parent node of C, then the key
 * (the value) of P is greater than or equal to the key of C.
 */
public class MaxPQTest {
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(100);
        pq.insert(10);
        pq.insert(5);
        pq.insert(15);
        pq.insert(20);
        pq.insert(30);
        pq.insert(25);
        System.out.println(pq.peekMax());
        pq.delMax();
        System.out.println(pq.peekMax());
    }
}

class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key peekMax() {
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1))
                exch(j, j + 1);
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public void sink(int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1))
                exch(j, j + 1);
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    // Page 323
    // Rearranges the array in ascending order
    // The for loop constructs the heap;
    // then the while loop exchanges the largest element a[1] with a[N]
    // and then repairs the heap, continuing until the heap is empty.
    public void sort(Key[] pq) {
        for (int k = N / 2; k >= 1; k--) {
            sink(k, N);
        } // once complete, pq[1] is the max
        int k = N;
        while (k > 1) {
            exch(1, k--);
            sink(1, k);
        }
    }

    public void add(Key v) {
        pq[++N] = v;
    }

}
