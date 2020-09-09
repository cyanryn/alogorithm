package com.algorithm.sort;

/**
 * 荷兰国旗问题：一个数组arr，一个数num，小于num的数放数组左边，等于num的数放数组中间，大于num的数放数组右边
 *  要求空间复杂度O(1),时间复杂度O(n)
 */
public class NetherlandsFlag {
    public static int[] partition(int[] arr, int L, int R, int P) {
        int less = L - 1;
        int more = R + 1;
        while(L < more) {
            if (arr[L] < P) {
                swap(arr, ++ less, L ++);
            } else if (arr[L] > P) {
                swap(arr, -- more, L);
            } else {
                L ++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 5, 3, 8, 10, 2, 1, 5};
        PublicMethod.printArr(partition(arr, 0, arr.length - 1, 5));
    }
}
