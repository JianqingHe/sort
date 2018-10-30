package com.algorithm.demo;

/**
 * 计数排序
 * 计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 *
 * @author hejq
 * @date 2018-10-30 15:24
 */
public class CountSort {

    public static int[] sort(int[] ints) {
        int maxValue = getMaxValue(ints);
        return CountIngSort(ints, maxValue);
    }

    private static int[] CountIngSort(int[] ints, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] buck = new int[bucketLen];
        for (int value : ints) {
            buck[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++ ) {
            while (buck[j] > 0) {
                ints[sortedIndex++] = j;
                buck[j]--;
            }
        }
        return ints;
    }

    private static int getMaxValue(int[] ints) {
        int maxValue = ints[0];
        for (int value : ints) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
