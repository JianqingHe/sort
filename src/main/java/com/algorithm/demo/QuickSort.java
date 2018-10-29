package com.algorithm.demo;

/**
 * 快速排序
 *
 * @author hejq
 * @date 2018-10-29 15:46
 */
public class QuickSort {

    /**
     * 快速排序
     * <pre>
     *     快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要 Ο(nlogn) 次比较。
     *     在最坏状况下则需要 Ο(n2) 次比较，但这种状况并不常见。
     *     事实上，快速排序通常明显比其他 Ο(nlogn) 算法更快，因为它的内部循环（inner loop）
     *     可以在大部分的架构上很有效率地被实现出来。
     *     快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
     *     快速排序又是一种分而治之思想在排序算法上的典型应用。
     *     快速排序高效原因：
     *          快速排序的最坏运行情况是 O(n²)，比如说顺序数列的快排。
     *          但它的平摊期望时间是 O(nlogn)，且 O(nlogn) 记号中隐含的常数因子很小，
     *          比复杂度稳定等于 O(nlogn) 的归并排序要小很多。
     *          所以，对绝大多数顺序性较弱的随机数列而言，快速排序总是优于归并排序。
     * </pre>
     * <note>
     *     1、 从数列中挑出一个元素，称为 “基准”（pivot）;
     *     2、 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面
     *         （相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     *     3、 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
     *     4、 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。
     *         虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，
     *         它至少会把一个元素摆到它最后的位置去。
     * </note>
     *
     * @param ints 待排序数组
     * @return 排序结果
     */
    public static int[] sort(int[] ints, int left, int right) {
        int base = ints[left], start = left, end = right;
        while (start < end) {
            // 从后向前
            while (start < end && ints[end] >= base) {
                end--;
            }
            if (ints[end] < base) {
                int temp = ints[end];
                ints[end] = base;
                base = temp;
            }
            // 从前向后
            while (start < end && ints[start] <= base) {
                start++;
            }
            if (ints[start] > base) {
                int temp = ints[start];
                ints[start] = base;
                base = temp;
            }
            if (start > left) {
                sort(ints, left, start);
            }
            if (end < right) {
                sort(ints, end + 1, right);
            }
        }
        return ints;
    }
}
