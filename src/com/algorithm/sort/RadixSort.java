package com.algorithm.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 桶排序：基数排序——时间复杂度O(n)
 *  要求：十进制数，最好是正数
 *  思想：找到最大值，看有几位，将其他数高位补零；有0-9号桶（队列结构），先按照每个数个位进桶，再倒出；再按照
 *      每个数十位进桶，倒出。。。
 */
public class RadixSort extends PublicMethod {
    /**
     *
     * @param arr
     * @param L
     * @param R
     * @param digit 有几位十进制的数
     */
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int j = 0, i = 0;
        // 有几个数就创建多大的桶
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d ++) {
            // count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix];
            for (i = L; i <= R; i ++) {
                j = getDigit(arr[i], d);
                count[j] ++;
            }
            // count[i] 当前位(d位)小于等于(0~i)的数字有多少个
            for (i = 1; i < radix; i ++) {
                count[i] = count[i] + count[i-1];
            }
            for (i = R; i >= L; i --) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j] --;
            }
            for (j = 0, i = L; i <= R; i ++, j ++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int num, int digit) {
        return (num / (int)Math.pow(10, digit - 1)) % 10;
    }

    public static int getMaxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i ++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while(max != 0) {
            res ++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort2(int[] arr, int L, int R, int digit) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        final int radix = 10;
        for (int i = 0; i < radix; i ++) {
            map.put(i, new LinkedList<>());
        }

        for (int d = 1; d <= digit; d ++) {
            int i = 0, j = 0;
            for (j = L; j <= R; j ++) {
                map.get(getDigit(arr[j], d)).offer(arr[j]);
            }
            for (j = 0; j < radix; j ++) {
                Queue<Integer> tmpQueue= map.get(j);
                while(!tmpQueue.isEmpty() && i < arr.length) {
                    arr[i] = tmpQueue.poll();
                    i ++;
                }
            }
        }
    }

    @Override
    public void sort(int[] arr) {
//        radixSort2(arr, 0, arr.length - 1, getMaxBits(arr));
        radixSort(arr, 0, arr.length - 1, getMaxBits(arr));
    }

    public static void main(String[] args) {
        PublicMethod.isAlgorithmOK(new RadixSort());
    }
}
