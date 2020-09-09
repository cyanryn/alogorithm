package com.algorithm.sort;

/**
 * 异或运算
 */
public class EvenTimesOddTimes {
    // 数组中，一个数出现奇数次，其他数都出现偶数次，找到这一个数
    public static int printOddTimesNum(int[] arr) {
        int num = 0;
        for (int cur : arr) {
            num ^= cur;
        }
        return num;
    }

    // 数组中，两个数出现奇数次，其他数都出现偶数次，找到这两个数
    public static int[] printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        // eor = a ^ b;
        // eor != 0
        // eor上必然有一个位置是1
        int rightOne = eor & (~eor + 1);// 提取出最右的1
        int onlyOne = 0; // eor'
        for (int cur : arr) {
            if ((cur & rightOne) == 1) {
                onlyOne ^= cur;
            }
        }
        return new int[]{onlyOne, eor ^ onlyOne};
    }

    public static void main(String[] args) {
        int[] arr = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        int result = printOddTimesNum(arr);
        System.out.println(result);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        int[] result2 = printOddTimesNum2(arr2);
        System.out.println(result2[0] + " " + result2[1]);
    }
}
