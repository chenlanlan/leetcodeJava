
public class MergeSort {
    public int[] MergeSort(int[] nums, int low, int high) {
        if (low < high){
            int mid = (low + high) / 2;
            MergeSort(nums, low, mid);
            MergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        if (low == 0 && high == 4){
            System.out.printf("%d, %d, %d, %d, %d\n", nums[0], nums[1],nums[2], nums[3], nums[4]);
        }
        return nums;
    }
    public void merge(int[] nums, int low, int mid, int high){
        int[] aux = nums.clone();
        int left = low;
        int right = mid + 1;
        int cur = low;
        while (left <= mid ||right <= high){
            if (right > high || left <= mid && aux[left] < aux[right]){
                nums[cur] = aux[left];
                left ++;
            }else{
                nums[cur] = aux[right];
                right ++;
            }
            cur ++;
        }
        return;
    }
    public static void main(String[] args){
        MergeSort test = new MergeSort();
        int[] nums = {1, 5, 6, 3, 7};
        System.out.printf("%d, %d, %d, %d, %d\n", nums[0], nums[1],nums[2], nums[3], nums[4]);
        test.MergeSort(nums, 0, 4);
    }
}
