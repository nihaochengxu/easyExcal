package com.it.easyexcal.algorithm;

import java.util.Arrays;

/**
 * @Author WQC
 * @Date 2022/7/19 23:15
 * @Version 1.0
 */
//希尔排序
public class shellSort {

    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] a = Arrays.copyOf(sourceArray, sourceArray.length);

       for(int step = a.length/2; step >= 1 ; step/=2){
           for (int i = step; i < a.length; i++) {
               int temp = a[i];
               int j = i-step;
               while(j>=0 && temp < a[j]){
//               while(j>=0 && temp < a[j]){ 将temp < a[j] 改为 temp > a[j]就能实现从大到小排序
                   a[j + step] = a[j];
                   j -= step;
               }
               a[j + step] = temp;
           }
       }
        return a;
    }

    public static void main(String[] args) throws Exception {
        int[] ints = {3, 9, -1, 20, 10,-2};
        shellSort shellSort = new shellSort();
        System.out.println(Arrays.toString(
        shellSort.sort(ints)));

    }
}
