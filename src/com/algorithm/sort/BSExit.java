package com.algorithm.sort;

/**
 * 二分查找某个数是否存在
 */
public class BSExit {
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int middle = left + ((right - left) >> 1);
//            int middle = (left + right) >> 1;
            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 9, 15};
        boolean result = binarySearch(arr, 5);
        System.out.println(result);
    }
}
