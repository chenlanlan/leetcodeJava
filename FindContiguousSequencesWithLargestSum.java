import java.util.List;
import java.util.ArrayList;

public class FindContiguousSequencesWithLargestSum {
    public int FindContiguousSequencesWithLargestSum(int[] nums) {
        int curSum = 0;
        int curMax = 0;
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            array.add(nums[i]);
            if (curMax < curSum) {
                curMax = curSum;
                res = new ArrayList<Integer>(array);
            } else if (curSum < 0) {
                curSum = 0;
                array.clear();
            }
        }
        for (int num : res) {
            System.out.println(num);
        }
        return curMax;
    }

    public static void main(String[] args) {
        FindContiguousSequencesWithLargestSum test = new FindContiguousSequencesWithLargestSum();
        int[] nums = {4, -1, 2, -2, -1, -3};
        System.out.println(test.FindContiguousSequencesWithLargestSum(nums));
    }
}