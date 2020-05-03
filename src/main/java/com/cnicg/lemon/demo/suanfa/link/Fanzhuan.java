package com.cnicg.lemon.demo.suanfa.link;

import org.omg.CORBA.NO_IMPLEMENT;

public class Fanzhuan {

    public static void main(String[] args) {
        Node node0 = new Node("0");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        node0.next = node1;
        node1.next = node2;

        printMyNode(node0);

//        printMyNode(fanZhuan(node0));
        printMyNode(fanZhuan2(node0));



    }

    private static Node fanZhuan2(Node node0) {
        if (null == node0 || node0.next == null) return node0;

        Node prev = fanZhuan2(node0.next);
        node0.next.next = node0;
        node0.next = null;


        return prev;
    }

    private static Node fanZhuan(Node node0) {
        if (null == node0 || node0.next == null) return node0;
        Node newHead = null;
        Node curr = node0;
        while (curr != null) {
            Node temp = curr.next;

            curr.next = newHead;
            newHead = curr;

            curr = temp;

        }
        return newHead;
    }

    private static void printMyNode(Node node0) {
        Node curr = node0;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }

}
