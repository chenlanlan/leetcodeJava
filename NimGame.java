public class NimGame {
    public boolean canWinNim(int n) {
        if (n <= 3) return true;
        if (n % 4 == 0) return false;
        else return true;
    }
    
    public static void main(String[] args) {
        NimGame test = new NimGame();
        System.out.println(test.canWinNim(4));
    }
}