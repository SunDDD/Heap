package algorithms.heap;

/**
 * @author Carlos
 * @description 优先队列（最小优先，堆实现）
 * @Date 2019/9/11
 */

public class MinPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean more(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && more(k/ 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && more(j, j + 1)) {
                j++;
            }
            if (more(j, k)) {
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

    public Key delMin() {
        Key min = pq[1];

        exch(1, N--);
        pq[N + 1] = null;
        sink(1);

        return min;
    }

}
