
public class FindIndices {
    public int FindIndices(int[] nums) {
        int[] res = {-1, -1};
        int i = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) break;
        }//from start to end find the first descending point;
        int min = nums[i];
        for (int j = i; j < nums.length; j++) {
            if (nums[j] < min) min = nums[j];
        }//from the first descending point to end find the MIN number;
        int small = nums[0];
        int m = 0;
        for (int h = 0; h <= i; h++) {
            if (nums[h] <= min && nums[h] > small) {
                small = nums[h];
                m = h;
            }
        }//from start to descending point find the largest number that smaller than(or equal to) MIN;and m is just after this number;
        res[0] = m + 1;
        //find n;
        for (i = nums.length - 2; i >= 0; i --) {
            if (nums[i + 1] < nums[i]) break;
        }
        int max = nums[i];
        for (int j = i; j >= 0; j --) {
            if (nums[j] > max) max = nums[j];
        }
        int large = nums[nums.length - 1];
        int n = 0;
        for(int h = nums.length - 1; h >= i; h--) {
            if (nums[h] >= max && nums[h] < large){
                large = nums[h];
                n = h;
            }
        }
        res[1] = n - 1;
        return res[1];
    }
    public static void main(String[] args) {
        FindIndices test = new FindIndices();
        int[]nums = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println(test.FindIndices(nums));
    }
}