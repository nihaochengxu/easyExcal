package com.it.easyexcal.algorithm;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @Author WQC
 * @Date 2022/6/27 23:55
 * @Version 1.0
首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。

再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。

重复第二步，直到所有元素均排序完毕。
 */

public class SelectionSort {
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            System.out.println("第"+i+"趟："+Arrays.toString(arr));

        }
        return arr;
    }
    public int[] sortV1(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    // 记录目前能找到的最小值元素的下标
                    max = j;
                }
            }

            // 将找到的最大值和i位置所在的值进行交换
            if (i != max) {
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
            }

        }
        return arr;
    }
    public static void main(String[] args) throws Exception {
//        List<Integer> list = Arrays.stream(new int[]{3, 38, 5, 15, 36, 26, 27, 2, 44}).boxed().collect(Collectors.toList());
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        int[] ints = {3, 38, 5, 15, 36, 26, 26, 2, 44};
        int[] ints = {3, 9, -1, 20, 10,-2};
        SelectionSort selectionSort = new SelectionSort();
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
//        System.out.println("选择排序前:"+Arrays.toString(ints));
        System.out.println("选择排序后:"+Arrays.toString(selectionSort.sort(ints)));
        sw.stop();
//        System.out.println(sw.prettyPrint());
//        StopWatch sw = new StopWatch("test");
//        sw.start("task2");
//        System.out.println("选择排序前:"+Arrays.toString(ints));
//        System.out.println("选择排序后:"+Arrays.toString(selectionSort.sortV1(ints)));
//        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getTotalTimeSeconds());
    }
}
