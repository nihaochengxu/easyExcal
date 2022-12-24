package com.it.easyexcal.algorithm;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @Author WQC
 * @Date 2022/6/28 23:12
 * @Version 1.0
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *从无序序列中的第一个元素（target）与有序序列从右到左进行比较，
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertSort {
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 0; i < arr.length-1; i++) {

            // 记录要插入的数据
            int tmp = arr[i+1];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i+1;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];//这步是关键，自己实现时没考虑到
                j--;
            }

            // 存在比其小的数，插入
            if (j != i+1) {
                arr[j] = tmp;
            }
            System.out.println("第"+i+"趟："+Arrays.toString(arr));

        }
        return arr;
    }

    public int[] sortV1(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
//            while (j > 0 && arr[j] < arr[j - 1]) {//错误示范，因为现有条件下，j会自减
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }
    public static void main(String[] args) throws Exception {
//        List<Integer> list = Arrays.stream(new int[]{3, 38, 5, 15, 36, 26, 27, 2, 44}).boxed().collect(Collectors.toList());
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        int[] ints = {3, 9, -1, 20, 10,-2};
//        int[] ints = {3, 38, 5, 15, 36, 26, 26, 2, 44};
        InsertSort insertSort = new InsertSort();
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
//        System.out.println("插入排序前:"+Arrays.toString(ints));
        System.out.println("插入排序后:"+Arrays.toString(insertSort.sort(ints)));
        sw.stop();
//        System.out.println(sw.prettyPrint());
//        StopWatch sw = new StopWatch("test");
//        sw.start("task2");
//        System.out.println("插入排序前:"+Arrays.toString(ints));
//        System.out.println("插入排序后:"+Arrays.toString(insertSort.sortV1(ints)));
//        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getTotalTimeSeconds());
    }
}
