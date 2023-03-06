package Array;

import java.util.Random;

/*
implemented quick Sort to solve it

time: O(nlogn)
 */

public class lc912_SortArray {
    class Solution {
        Random random = new Random();
        public int[] sortArray(int[] nums) {
            //coner case
            if (nums == null || nums.length == 0){
                return new int[]{0};
            }
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }
        private void quickSort(int[] nums, int left, int right){
            //base case
            if (left >= right){
                return;
            }
            //every recursion call, there is a new pivot
            int pivot = left + random.nextInt(right - left + 1);//offset + 1
            int i = left;
            int j = right - 1; //nums.length - 2

            swap(nums, pivot, right);//let pivoit put to the last index

            //compare with the number
            while (i <= j){
                if (nums[i] < nums[right]){  //compare the value at the last index, pivot index did not change, so its not compare with pivot
                    i++;
                } else{
                    swap(nums, i, j); //if j is smaller, swap to i index
                    j--;
                }
            }
            //remember to swap back
            //because >= still go into the loop, so when loop terminated, i > j, so swap i
            swap(nums, i, right);
            quickSort(nums, left, i - 1); //*the range is importatn to consider
            quickSort(nums, i + 1, right);

        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}
