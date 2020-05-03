package com.cnicg.lemon.demo.suanfa.paixu;

import java.util.Arrays;

public class MaoPaoSort {

    private static int[] lemon = new int[]{1, 3, 5, 2, 6};

    public static void main(String[] args) {

//        maoPao(lemon);
//        chaRu(lemon);
//        xuanZe(lemon);
//        mergeSort(lemon, 0, lemon.length - 1);
        kuaiPai(lemon, 0, lemon.length -1);





        System.out.println(Arrays.toString(lemon));

        int index = erfenFind(lemon, 4, 0, lemon.length -1);
        System.out.println(index);

    }

    private static int erfenFind(int[] arr, int target, int start, int end) {
        if (start >= end) {
            if (arr[start] == target) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end)/2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            return erfenFind(arr, target, start, mid - 1);
        }
        return erfenFind(arr, target, mid +1, end);
    }

    private static void kuaiPai(int[] lemon, int start, int end) {
        if (start >= end){
            return;
        }
        int pivot = lemon[end];
        int i = start;
        int j = start;
        for (;j < end; j++) {
            if (lemon[j] < pivot) {
                swap(lemon, j, i);
                i++;
            }
        }
        swap(lemon, end, i);

        kuaiPai(lemon, start, i - 1);
        kuaiPai(lemon, i + 1, end);
    }

    private static void mergeSort(int[] lemon, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(lemon, start, mid);
        mergeSort(lemon, mid +1, end);
        merge(lemon, start, mid, end);
    }

    private static void merge(int[] lemon, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid || j <= end) {
            if (i > mid) {
                temp[index] = lemon[j];
                j++;
                index++;
            } else if (j > end) {
                temp[index] = lemon[i];
                i++;
                index++;
            } else if (lemon[i] > lemon[j]) {
                temp[index] = lemon[i];
                i++;
                index++;
            } else {
                temp[index] = lemon[j];
                j++;
                index++;
            }
        }
        int len = end - start + 1;
        for (int n = 0;n < len;n++) {
            lemon[start + n] = temp[n];
        }

    }

    private static void xuanZe(int[] lemon) {
        for (int i = 0; i < lemon.length; i++) {
            int targetIndex = i;
            for (int j = i; j < lemon.length;j++) {
                if (lemon[j] > lemon[targetIndex]) {
                    targetIndex = j;
                }
            }
            swap(lemon, i, targetIndex);
        }
    }

    private static void chaRu(int[] lemon) {
        for (int i = 0; i < lemon.length; i++) {
            for (int j = i-1; j >= 0;j--) {
                if (lemon[j+1] > lemon[j]) {
                    swap(lemon, j,j+1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] lemon, int a, int b) {
        int temp = lemon[a];
        lemon[a] = lemon[b];
        lemon[b] = temp;
    }

    private static void maoPao(int[] lemon) {
        for (int i = 0; i < lemon.length; i++) {
            boolean notOk = false;
            for (int j = 0; j< lemon.length-i-1;j++) {
                if (lemon[j] < lemon[j+1]) {
                    swap(lemon, i,i+1);
                    notOk = true;
                }
            }
            if (!notOk){
                break;
            }
        }
    }





}
