
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int e : nums) {
            if (count == 0) {
                candidate = e;
                count += 1;
            } else if (e == candidate) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] nums = {1, 2, 3, 1, 1, 2};
        System.out.println(test.majorityElement(nums));
    }
}