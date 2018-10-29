package com.algorithm.demo;

/**
 * 冒泡排序
 *
 * @author hejq
 * @date 2018-10-29 15:38
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * <pre>
     *     它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果他们的顺序（如从大到小、首字母从A到Z）
     *     错误就把他们交换过来。走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素已经排序完成。
     *     这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端（升序或降序排列），
     *     就如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”。
     * </pre>
     * <note>
     *     1、 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *     2、 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
     *     3、 这步做完后，最后的元素会是最大的数。针对所有的元素重复以上的步骤，除了最后一个。
     *     4、 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * </note>
     * @param ints 待排序数组
     * @return 排序结果
     */
    public static int[] sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++ ) {
            for (int j = 0; j < ints.length - 1 - i; j++ ) {
                if (ints[j] > ints [j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        return ints;
    }
}
