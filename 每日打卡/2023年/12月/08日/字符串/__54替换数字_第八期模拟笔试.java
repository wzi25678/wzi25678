package 代码随想录.字符串;

import java.util.Scanner;

public class __54替换数字_第八期模拟笔试 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                str+="number";
            }else{
                str+=s.charAt(i);
            }
        }
        System.out.println(str);
    }
}
