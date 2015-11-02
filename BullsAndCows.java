public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] numbers = new int[10];
        int countRight = 0, countWrong = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countRight++;
            } else {
                if (numbers[secret.charAt(i) - '0']++ < 0) countWrong++;
                if (numbers[guess.charAt(i) - '0']-- > 0) countWrong++;
            }
        }
        return countRight + "A" + countWrong + "B";
    }
    
}