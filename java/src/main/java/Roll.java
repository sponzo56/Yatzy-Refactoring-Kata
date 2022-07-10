import java.util.*;

public class Roll implements IRoll {

    private final List<Die> listDice;
    private final Category category;

    public Roll(List<Die> listDice, Category category) {
        this.listDice = listDice;
        this.category = category;
    }

    @Override
    public long countDiceWithFaceValue(int faceValue, List<Die> listDice) {
        return 0;
    }

    @Override
    public long getScore(Roll roll) {
        return 0;
    }
}
