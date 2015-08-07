public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++) {
            while (A[i] != i + 1) {
                if (A[i] >= A.length || A[i] <= 0 || A[i] == A[A[i] - 1]) {
                    break;
                }
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }
    
    
    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] A = {-1, 2, 1};
        System.out.println(test.firstMissingPositive(A));
    }
}