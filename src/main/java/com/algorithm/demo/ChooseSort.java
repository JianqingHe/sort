package com.algorithm.demo;

/**
 * 选择排序
 *
 * @author hejq
 * @date 2018-10-29 15:13
 */
public class ChooseSort {

    /**
     * 选择排序
     * <pre>
     *     选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。
     *     所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
     * </pre>
     * <note>
     *     1、 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     *     2、 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     *     3、 重复第二步，直到所有元素均排序完毕。
     * </note>
     *
     * @param ints 传入的数组
     * @return 排序后的数组
     */
    public static int[] sort(int[] ints) {
        int min, i, j;
        for (i = 0; i < ints.length - 1; i++ ) {
            min = i;
           for (j = i + 1; j < ints.length; j++ ) {
               if (ints[j] < ints[min]) {
                   min = j;
               }
           }
            if (i != min) {
                int temp = ints[i];
                ints[i] = ints[min];
                ints[min] = temp;
            }
        }
        return ints;
    }
}
