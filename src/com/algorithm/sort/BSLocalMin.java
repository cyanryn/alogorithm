package com.algorithm.sort;

/**
 * 局部最小值
 */
public class BSLocalMin {
    public static int getLocalMinimun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int middle = 0;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (arr[middle] > arr[middle - 1]) {
                right = middle - 1;
            } else if (arr[middle] > arr[middle + 1]) {
                left = middle + 1;
            } else {
                return  middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 1, -4, 9};
        int index = getLocalMinimun(arr);
        System.out.println(index);
    }
}
