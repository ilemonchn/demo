package com.cnicg.lemon.demo.abknowledge.suanfa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LeftSee {
    public static void main(String[] args) throws Exception {

        Object global = new Object();
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        List<String> list = new ArrayList<>();

        try {
            lock.lock();
            while (list.size() == 5){
                notFull.wait();
            }
            list.add("lemon");
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }

        System.out.println(list);

        Node a= new Node("A");
        Node b= new Node("B");
        Node c= new Node("C");
        Node d= new Node("D");
        a.left = b;
        a.right = c;
        c.left = d;

        printLeftSee(a);

    }

    //输出左视图
    private static void printLeftSee(Node a) {
        if (a == null) {
            return;
        }

        ArrayDeque<Node> queue1 = new ArrayDeque<>();
        ArrayDeque<Node> queue2 = new ArrayDeque<>();
        queue1.addLast(a);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            ArrayDeque<Node> queue3 = queue1.isEmpty() ? queue2 : queue1;
            Node poll = queue3.poll();
            System.out.println(poll.name);
            queue3.addFirst(poll);
            ArrayDeque<Node> queue4 = queue1.isEmpty() ? queue1 : queue2;
            findChild(queue3, queue4);
        }
    }

    private static void findChild(ArrayDeque<Node> queue3, ArrayDeque<Node> queue4) {
        while (!queue3.isEmpty()) {
            handlf(queue3.poll(), queue4);
        }
    }

    private static void handlf(Node poll, ArrayDeque<Node> queue4) {
        if (null != poll.left) {
            queue4.addLast(poll.left);
        }
        if (null != poll.right) {
            queue4.addLast(poll.right);
        }
    }

    public static class Node{
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
        }

    }
}
