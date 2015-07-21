
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == nums[right]) {
                left++;
                continue;
            }
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
        FindMinimumInRotatedSortedArrayII test = new FindMinimumInRotatedSortedArrayII();
        int[] nums = {1, 1};
        System.out.println(test.findMin(nums));
    }
}

