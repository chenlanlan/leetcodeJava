public class CountPrimes {
    public int countPrimes(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int res = 0, j = 2;
        while (j < n) {
            if (nums[j] != 0) {
                res++;
                int current = j * 2;
                while (current < n) {
                    nums[current] = 0;
                    current = current + j;
                }
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();
        System.out.println(test.countPrimes(13));
    }
}