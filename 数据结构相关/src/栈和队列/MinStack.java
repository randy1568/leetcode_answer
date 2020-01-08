package 栈和队列;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 155. 最小栈
 */

public class MinStack {

    private PriorityQueue<Integer> priorityQueue  = null;
    LinkedList<Integer> list = null;
    /** initialize your data structure here. */
    public MinStack() {
        priorityQueue = new PriorityQueue<>();
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.addFirst(x);
        priorityQueue.add(x);
    }

    public void pop() {
        Integer pop = list.pop();
        priorityQueue.remove(pop);
    }

    public int top() {
        return list.get(0);
    }

    public int getMin() {
        return priorityQueue.peek();
    }

}
