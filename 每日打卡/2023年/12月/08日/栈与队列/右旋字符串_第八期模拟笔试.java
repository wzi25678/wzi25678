package 代码随想录.栈与队列;

import java.util.Scanner;

public class 右旋字符串_第八期模拟笔试 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println(rightRotateString(s, n));
    }

    /**
     * 给定一个字符串 s 和一个正整数 k
     *将字符串中的后面 k 个字符移到字符串的前面
     *
     * 即所有元素当做一个环，输入k，则所有元素向右移动k个位置
     *
     * 数据范围：
     * 1 <= k < 10000,
     * 1 <= s.length < 10000;
     *
     *
     * @param s
     * @param k
     */
    private static String rightRotateString(String s, int k) {
        /*
        解题思路：
            将所有数存储在一个数组中，然后通过取模运算，构造出一个循环数组
            然后也没有空间要求，就可以再构造一个辅助空间，来搞快点
         */
        char [] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt((i-k+s.length())% s.length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i]);
        }
        //System.out.println("傻逼？");
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
