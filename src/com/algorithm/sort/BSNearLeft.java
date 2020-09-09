package com.algorithm.sort;

/**
 * 在有序数组中，查找>=某个数最左侧的位置
 */
public class BSNearLeft {
    public static int binarySearchNearLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] >= target) {
                index = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 2, 4, 4, 5, 6, 6, 7};
        int result = binarySearchNearLeft(arr, 2);
        System.out.println(result);
    }
}
