
public class QuickSort {
    public int[] QuickSort(int[] nums, int low, int high) {
        if (low < high){
            int j = partition(nums, low, high);
            QuickSort(nums, low, j - 1);
            QuickSort(nums, j + 1, high);
        }
        System.out.println(nums[9]);
        return nums;
    }
    public int partition(int[] nums, int low, int high){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] > temp){
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < temp){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
    public static void main(String[] args){
        QuickSort test = new QuickSort();
        int[] nums = {1,2,3,4,5,6,8,9,10,7};
        test.quickSort(nums, 0, 9);
    }
}
