public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeros < 1) {
                    zeros++;
                    continue;
                } else {
                    return res;
                }
            }
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeros == 1) {
                if (nums[i] == 0) res[i] = product;
                else res[i] = 0;
            } else {
                res[i] = product / nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
        int[] nums = {0, 2, 0, 4};
        System.out.println(test.productExceptSelf(nums));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }
        elementsBeforeProduct = 1;
        for (int i = 0; i < n; i++) {
            res[i] = res[i] * elementsBeforeProduct;
            elementsBeforeProduct = elementsBeforeProduct * nums[i];
        }
        return res;
    }
}