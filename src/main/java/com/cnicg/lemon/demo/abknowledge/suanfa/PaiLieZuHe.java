package com.cnicg.lemon.demo.abknowledge.suanfa;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PaiLieZuHe {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,22,23};
//        int[] arr = new int[]{0,0,24};

        System.out.println(baoLiChaiJie(arr));
//        System.out.println(diGUI(arr));
    }


    private static int diGUI(int[] arr) {
        Node node = new Node();
        for (int i : arr) {
            node.leftV.add(i);
        }
        List<Node> ret = new ArrayList<>();
        diGuiFenLie(node, ret);
        int index = 0;
        for (Node node1: ret) {
            if (node1.value == 0) {
                index++;
            }
        }
        System.out.println(index);
        System.out.println(ret.size());
        return index;
    }

    private static void diGuiFenLie(Node node, List<Node> currL) {
        if (node.leftV.size() == 0) {
            return ;
        }

        int currS = node.leftV.size();
        for (int j =0 ;j<currS;j++) {
            Node nodeCurr = new Node();
            nodeCurr.value = node.value - node.leftV.get(j);
            for (int m= j + 1;m<node.leftV.size();m++) {
                nodeCurr.leftV.add(node.leftV.get(m));
            }
            currL.add(nodeCurr);
            diGuiFenLie(nodeCurr, currL);
        }
    }

    private static class Node {
        public Integer value = 24;
        public List<Integer> leftV = new ArrayList<>();
    }




    private static int baoLiChaiJie(int[] arr) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        int size = 0;
        for (int i = 0;i<arr.length;i++) {

            int currS = size;
            for (int j =0 ;j<currS;j++){
                if (list.get(j) <= 24) {
                    list.add(size, list.get(j) + arr[i]);
                    size++;
                }
            }

            list.add(size, i);
            size++;
        }

        int count = 0;
        for (Integer tar: list) {
            if(tar == 24) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(list.size());

        return count;
    }




}
