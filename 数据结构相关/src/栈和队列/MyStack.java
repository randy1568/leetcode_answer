package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用一个队列即可实现
 */
public class MyStack {
    Queue<Integer> queue = null;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    /**
     * 临时创建一个新队列，将待push的值push到临时队列中，再将原始队列的值全部push到临时队列中，将原始队列的引用指向临时队列
     * @param x
     */
    public void push(int x) {
        if (queue.isEmpty()){
            queue.add(x);
        }else {
            Queue<Integer> queueTemp = new LinkedList<>();
            queueTemp.add(x);
            while (!queue.isEmpty()){
                queueTemp.add(queue.poll());
            }
            queue = queueTemp;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
