package 中等题;

public class __215数组中的第K个最大元素__自己创建一个插入排序 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSort(nums,0,n-1);
        return nums[n-k];
    }

    /**
     *
     * @param nums
     * @param low
     * @param high
     */
    private void quickSort(int[] nums, int low, int high) {
        if (low <high){          //partitionArr负责排序，同时要返回中间的pivot
            int partitionIndex = partitionArr(nums,low,high);
            //当前排完之后，再拍左边右边
            quickSort(nums,low,partitionIndex-1);
            quickSort(nums,partitionIndex+1,high);
        }
    }

    /**
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partitionArr(int[] nums, int low, int high) {
        int pivot = nums[high];
        int index = low -1; //记录起始的位置
        for (int i=low;i<high;i++){
            if (nums[i] <= pivot){
                index++;
                Myswap(nums,i,index);
            }
        }
        Myswap(nums,index+1,high);
        return index+1;
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     */
    private void Myswap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
