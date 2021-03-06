package com.algorithm.demo;

import java.util.Arrays;

/**
 * 基数排序
 * 基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。
 * 1. 基数排序 vs 计数排序 vs 桶排序
 * 基数排序有两种方法：
 * 这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：
 * 基数排序：根据键值的每位数字来分配桶；
 * 计数排序：每个桶只存储单一键值；
 * 桶排序：每个桶存储一定范围的数值；
 *
 * @author hejq
 * @date 2018-10-30 15:59
 */
public class RadixSort {

    public static int[] sort(int[] ints) {
        int maxDigit = getMaxDigit(ints);
        return radixSort(ints, maxDigit);
    }

    private static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    private static int getMaxDigit(int[] ints) {
        int maxValue = getMaxValue(ints);
        return getNumLenght(maxValue);
    }

    private static int getNumLenght(int maxValue) {
        if (maxValue == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = maxValue; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

}
