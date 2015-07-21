
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray test = new FindMinimumInRotatedSortedArray();
        int[] nums = {5, 0, 1, 2};
        System.out.println(test.findMin(nums));
    }
}

