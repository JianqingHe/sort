package com.algorithm.demo;

/**
 * 堆排序
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：
 * 即子结点的键值或索引总是小于（或者大于）它的父节点。堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：
 * 大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
 * 小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
 * 1. 算法步骤
 * 创建一个堆 H[0……n-1]；
 * 把堆首（最大值）和堆尾互换；
 * 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
 * 重复步骤 2，直到堆的尺寸为 1。
 *
 * @author hejq
 * @date 2018-10-30 15:06
 */
public class HeapSort {

    public static int[] sort(int[] ints) {
        // 创建一个堆
        int len = ints.length;
        buildMaxHeap(ints, len);
        for (int i = len - 1; i > 0; i-- ) {
            swap(ints, 0, i);
            len--;
            heapify(ints, 0, len);
        }
        return ints;
    }

    /**
     * 创建一个最大堆
     *
     * @param ints 数组
     * @param length 长度
     */
    private static void buildMaxHeap(int[] ints, int length) {
        for (int i = (int) Math.floor(length / 2); i >= 0; i-- ) {
            heapify(ints, i, length);
        }
    }

    private static void heapify(int[] ints, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && ints[left] > ints[largest]) {
            largest = left;
        }
        if (right < length && ints[right] > ints[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(ints, i, largest);
            heapify(ints, largest, length);
        }
    }

    private static void swap(int[] ints, int i, int largest) {
        int temp = ints[i];
        ints[i] = ints[largest];
        ints[largest] = temp;
    }
}
