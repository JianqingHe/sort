package com.algorithm.demo;

import java.util.Arrays;

/**
 * 桶排序
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 为了使桶排序更加高效，我们需要做到这两点：
 * 在额外空间充足的情况下，尽量增大桶的数量
 * 使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
 * 同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。
 * @author hejq
 * @date 2018-10-30 15:32
 */
public class BucketSort {

    public static int[] sort(int[] ints) {
        // 定义桶数量
        int buckNum = 5;
        return bucketSort(ints, buckNum);
    }

    private static int[] bucketSort(int[] ints, int buckNum) {
        if (ints.length == 0) {
            return ints;
        }
        int minValue = ints[0];
        int maxValue = ints[0];
        for (int value : ints) {
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / buckNum) + 1;
        int[][] buckets = new int[bucketCount][0];
        for (int i = 0; i < ints.length; i++ ) {
            int index = (int) Math.floor((ints[i] - minValue) / buckNum);
            buckets[index] = arrAppend(buckets[index], ints[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            bucket = insertSort(bucket);
            for (int value : bucket) {
                ints[arrIndex++] = value;
            }
        }
        return ints;
    }

    private static int[] insertSort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            int temp = ints[i];
            for (int j = i; j > 0 && temp < ints[j - 1]; j-- ) {
                ints[j] = ints[j - 1];
            }
        }
        return ints;
    }

    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
