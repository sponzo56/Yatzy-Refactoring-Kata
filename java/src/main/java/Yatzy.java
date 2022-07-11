import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Yatzy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to game of Yatzy !");
        System.out.println("Enter your first DieSixFaces (face number from 1 to 6)");
        SixFacesDie sixFacesDie1 = new SixFacesDie(scanner.nextInt());
        System.out.println("Enter your second DieSixFaces");
        SixFacesDie sixFacesDie2 = new SixFacesDie(scanner.nextInt());
        System.out.println("Enter your third DieSixFaces");
        SixFacesDie sixFacesDie3 = new SixFacesDie(scanner.nextInt());
        System.out.println("Enter your fourth DieSixFaces");
        SixFacesDie sixFacesDie4 = new SixFacesDie(scanner.nextInt());
        System.out.println("Enter your fifth DieSixFaces");
        SixFacesDie sixFacesDie5 = new SixFacesDie(scanner.nextInt());

        System.out.println("Enter the category you wanna play for (CHANCE, YATZY, ONES...)");
        Category category = Category.valueOf(scanner.next().toUpperCase());

        List<IDie> listFaces = Collections.EMPTY_LIST;
        Collections.addAll(listFaces = new ArrayList<>(), sixFacesDie1, sixFacesDie2, sixFacesDie3, sixFacesDie4, sixFacesDie5);
        YatzyRoll roll = new YatzyRoll(listFaces, category);

        System.out.println("Your score is : " + roll.getScore(roll));



    }

}



