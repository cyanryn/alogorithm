package com.algorithm.sort;

/**
 * 小和问题：一个数组中，每个数左边比当前数小的数累加起来
 */
public class SmallSum {
    public static int getSamllSum(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int middle = L + ((R - L) >> 1);
        return process(arr, L, middle) +
                process(arr, middle + 1, R) +
                merge(arr, L, middle, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int sum = 0;
        while(p1 <= M && p2 <= R) {
            sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= M) {
            help[i++] = arr[p1++];
        }
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(int j = 0; j < help.length; j ++) {
            arr[L + j] = help[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(getSamllSum(arr));
    }
}
