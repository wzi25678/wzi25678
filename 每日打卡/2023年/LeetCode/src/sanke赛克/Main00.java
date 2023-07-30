package sanke赛克;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Main00 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};  // 指定的数

        List<Integer> result = getNumbers(nums);

        if (!result.isEmpty()) {
            System.out.println("所有整数可以通过指定的几个数的任意倍数的加减求和得到。");
            System.out.print("使用的数为：");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("存在整数无法通过指定的几个数的任意倍数的加减求和得到。");
        }
    }

    public static List<Integer> getNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int target = nums[0];

        if (helper(nums, target, 0, result)) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private static boolean helper(int[] nums, int target, int index, List<Integer> result) {
        if (target == 0) {
            return true;  // 已经得到目标数
        }
        if (index >= nums.length) {
            return false;  // 超出数组范围，无法得到
        }

        // 尝试加上当前数
        result.add(nums[index]);
        if (helper(nums, target - nums[index], index, result)) {
            return true;
        }
        result.remove(result.size() - 1);  // 回溯

        // 尝试减去当前数
        result.add(-nums[index]);
        if (helper(nums, target + nums[index], index, result)) {
            return true;
        }
        result.remove(result.size() - 1);  // 回溯

        // 不使用当前数，尝试下一个数
        if (helper(nums, target, index + 1, result)) {
            return true;
        }

        return false;  // 无法得到目标数
    }
}







