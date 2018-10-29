package com.algorithm.demo;

/**
 * 插入排序
 *
 * @author hejq
 * @date 2018-10-29 15:30
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     * @param ints  待排序数组
     * @return 排序结果
     */
    public static int[] sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            int temp = ints[i];
            for (int j = i; j > 0 && temp < ints[j - 1]; j-- ) {
                ints[j] = ints[j - 1];
            }
        }
        return ints;
    }
}
