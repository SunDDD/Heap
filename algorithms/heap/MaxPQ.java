package algorithms.heap;

/**
 * @author Carlos
 * @description 优先队列（堆实现）
 * @Date 2019/9/11
 */

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int MaxN) {
        pq = (Key[]) new Comparable[MaxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2 , k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (less(j, k)) {
                break;
            }
            exch(j, k);
            k = j;
        }
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key Max = pq[1];

        exch(1, N--);
        pq[N + 1] = null;
        sink(1);

        return Max;
    }



}
