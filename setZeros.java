/**
 * Created by chensilan on 9/25/15.
 */
public class setZeros {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return;
    }
    public static void main (String[] args) {
        setZeros test = new setZeros();
        int[] nums = {1, 0, 3, 2, 0, 12};
        test.moveZeroes(nums);
    }
}
