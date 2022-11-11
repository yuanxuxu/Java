package JavaBasic.algo;

import org.checkerframework.checker.units.qual.A;

public class MinPQTest {
    public static void main(String[] args) {
        String t = "/a/b/c/d";
        String[] s = t.split("/");
        for (String a : s) {
            System.out.println(a);
        }
    }

    class MinPQ<Key extends Comparable<Key>> {
        private Key[] pq;
        private int n;

        public MinPQ(int capacity) {
            n = 0;
            pq = (Key[]) new Comparable[capacity + 1];
        }

        public void add(Key v) {
            pq[++n] = v;
            swim(n);
        }

        private void swim(int k) {
            while (k > 1 && !less(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (k * 2 <= n && !less(k, k * 2)) {
                int j = k * 2;
                if (j < n && !less(j, j + 1))
                    exch(j, j + 1);
                if (less(k, j))
                    break;
                exch(k, j);
                k = j;
            }
        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) <= 0;
        }

        private void exch(int i, int j) {
            Key key = pq[i];
            pq[i] = pq[j];
            pq[j] = key;
        }

    }
}
