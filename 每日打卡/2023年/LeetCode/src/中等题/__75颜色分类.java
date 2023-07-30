package 中等题;

public class __75颜色分类 {
    /**
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        /*
        常数空间排序的算法有很多：
            插入排序，希尔排序，冒泡排序、快速排序、推排序、
        */
        int num0 = 0,num1  = 0,num2 = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == 0){
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else{
                nums[num2++] = 2;
            }
        }
    }

}
