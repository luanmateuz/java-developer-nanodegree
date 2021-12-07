package lesson04.loops.ch18;

public class Main {

    /**
     * Lesson 04 - Chapter 18
     * Quiz
     */
    public static void main(String[] args) {
        martingale();
    }

    public static int martingale() {
        int money = 1000;
        int target = 1200;
        int bet = 10;
        while (money > bet) {
            boolean win = play();
            if (win) {
                money += bet;
                bet = 10;
            } else {
                money -= bet;
                bet *= 2;
            }
            if(money >= target)
                break;
        }
        return money;
    }

    private static boolean play() {
        return true;
    }
}
