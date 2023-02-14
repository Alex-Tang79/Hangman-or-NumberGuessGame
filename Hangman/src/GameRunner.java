import java.util.Scanner;
import java.util.ArrayList;

public class GameRunner {
    public static void main(String[] args) throws Exception {
        ArrayList<Hangman> hangmans = new ArrayList<Hangman>();
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;
        int difficulty = 1;

        while (keepGoing) {
            hangmans.add(new Hangman(difficulty));
            System.out.println("You won! Type [y] to play again with less lives and more difficult words!");
            keepGoing = sc.nextLine().toLowerCase().equals("y");
            difficulty++;
        }
    }
}
