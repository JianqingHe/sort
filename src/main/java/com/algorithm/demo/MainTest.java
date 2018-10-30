package com.algorithm.demo;

import com.alibaba.fastjson.JSON;

/**
 * 测试类
 *
 * @author hejq
 * @date 2018-10-29 15:21
 */
public class MainTest {

    public static void main(String[] args) {
        int[] ints = new int[] {5, 3, 2, 6, 7, 9, 1};
        System.out.println(JSON.toJSONString(RadixSort.sort(ints)));
    }
}
