package com.it.easyexcal.algorithm;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.StopWatch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author WQC
 * @Date 2022/6/27 22:23
 * @Version 1.0
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 *
 * 针对所有的元素重复以上的步骤，除了最后一个。
 *
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {

    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length-1; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }
            System.out.println("第"+i+"趟："+Arrays.toString(arr));

            if (flag) {
                break;
            }
        }
        return arr;
    }
    public int[] sortV1(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length-1; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }
            System.out.println("第"+i+"趟："+Arrays.toString(arr));
            if (flag) {
                break;
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
//        int[] ints = {3,-1,9,-2,10};
        int[] ints = {3, 9, -1, 20, 10,-2};
        BubbleSort bubbleSort = new BubbleSort();
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
//        System.out.println("冒泡排序前:"+Arrays.toString(ints));
        System.out.println("冒泡排序后:"+Arrays.toString(bubbleSort.sort(ints)));
        sw.stop();
//        System.out.println(sw.prettyPrint());
//        StopWatch sw = new StopWatch("test");
        sw.start("task2");
//        System.out.println("冒泡排序前:"+Arrays.toString(ints));
//        System.out.println("冒泡排序后:"+Arrays.toString(bubbleSort.sortV1(ints)));
        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getTotalTimeSeconds());
    }
}
