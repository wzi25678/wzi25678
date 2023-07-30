package sanke赛克;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        //int distances[] = new int[n];
        //int prices[] = new int[n];
        int[] nums = {10, 20, 5};  // 指定的数

        boolean result = canGetAllNumbers(nums);

        if (result) {
            //System.out.println("所有自然数可以通过指定的几个数的任意倍数的加减求和得到。");
        } else {
            System.out.println(-1);
        }
    }

    public static boolean canGetAllNumbers(int[] nums) {
        int gcd = nums[0];  // 初始值为第一个数

        // 计算最大公约数
        for (int i = 1; i < nums.length; i++) {
            gcd = calculateGCD(gcd, nums[i]);
        }

        // 判断最大公约数是否为1
        return gcd == 1;
    }

    //java设计一个算法，判断所有整数能否被指定的几个数的任意倍数的结果加减求和得到。如果能，返回是哪几个数实现的。
    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return calculateGCD(b, a % b);
    }
}

