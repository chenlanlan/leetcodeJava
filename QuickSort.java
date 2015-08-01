
public class QuickSort {
    public int[] QuickSort(int[] nums, int low, int high) {
        if (low < high){
            int j = partition(nums, low, high);
            QuickSort(nums, low, j - 1);
            QuickSort(nums, j + 1, high);
        }
        if (low == 0 && high == 4){
            System.out.printf("%d, %d, %d, %d, %d\n", nums[0], nums[1],nums[2], nums[3], nums[4]);
        }
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
        int[] nums = {1, 5, 6, 3, 7};
        System.out.printf("%d, %d, %d, %d, %d\n", nums[0], nums[1],nums[2], nums[3], nums[4]);
        test.QuickSort(nums, 0, 4);
    }
}
