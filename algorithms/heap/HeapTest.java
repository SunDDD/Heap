package algorithms.heap;

import edu.princeton.cs.algs4.*;

/**
 * @author Carlos
 * @description 堆测试
 * @Date 2019/9/11
 */

public class HeapTest {

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
//        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
//        MaxPQ<Transaction> pq = new MaxPQ<>(M + 1);
        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                pq.delMin();
            }
        }
        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push(pq.delMin());
        }
        for (Transaction transaction : stack) {
            System.out.println(transaction);
        }
    }

}
