package com.algorithm.sort;

/**
 * 桶排序：计数排序. 稳定
 *   - 时间复杂度：O(n)
 *   - 空间复杂度： O(n)
 *      问题：数据状况处在比较窄的范围
 *      思想：比如年龄0-200，用一个bucket[201]去计数，比如17岁就在bucket[17]=1做标记。
 *          计数完再将bucket[i]不等于0数依次倒出排列
 */
public class CountSort extends PublicMethod {
    public static void countSortMethod(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i ++) {
            max = Math.max(max, arr[i]);
        }
        int[] buckets = new int[max + 1];
        for (int i = 0; i < arr.length; i ++) {
            buckets[arr[i]] ++;
        }
        int i = 0;
        for (int j = 0; j < buckets.length; j ++) {
            while(buckets[j] -- > 0) {
                arr[i ++] = j;
            }
        }
    }

    @Override
    public void sort(int[] arr) {
        countSortMethod(arr);
    }

    public static void main(String[] args) {
        PublicMethod.isAlgorithmOK(new CountSort());
    }
}
