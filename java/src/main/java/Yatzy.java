import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Yatzy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to game of Yatzy !");
        System.out.println("Enter your first die (face number from 0 to 6)");
        Die die1 = new Die(scanner.nextInt());
        System.out.println("Enter your second die");
        Die die2 = new Die(scanner.nextInt());
        System.out.println("Enter your third die");
        Die die3 = new Die(scanner.nextInt());
        System.out.println("Enter your fourth die");
        Die die4 = new Die(scanner.nextInt());
        System.out.println("Enter your fifth die");
        Die die5 = new Die(scanner.nextInt());

        System.out.println("Enter the category you wanna play for (CHANCE, YATZY, ONES...)");
        Category category = Category.valueOf(scanner.next().toUpperCase());

        List<Die> listFaces = Collections.EMPTY_LIST;
        Collections.addAll(listFaces = new ArrayList<>(), die1, die2, die3, die4, die5);
        Roll roll = new Roll(listFaces, category);

        System.out.println("Your score is : " + roll.getScore(roll));



    }

}



