public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
        return;
    }
    public void reverse(int[] nums, int start, int end){
        for (int i = start; i <= (start + end) / 2; i++){
            int temp = nums[i];
            nums[i] = nums[end - (i - start)];
            nums[end - (i - start)] = temp;
        }
        return;
    }
    public static void main(String[] args){
        RotateArray test = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        test.rotate(nums, 2);
    }
}

