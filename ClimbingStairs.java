public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }else{
            int[] step = new int[n];
            step[0] = 1;
            step[1] = 2;
            for (int i = 2; i < n; i++){
                step[i] = step[i - 1] + step[i - 2];
            }
            System.out.println("hello");
            return step[n - 1];
        }
    }
    public static void main(String[] args){
        ClimbingStairs test = new ClimbingStairs();
        test.climbStairs(5);
        System.out.println(test.climbStairs(5));
    }
}

