import java.util.List;

public interface IRoll {

    int nbDice = 5;

    long countDiceWithFaceValue(int faceValue, List<Die> listDice);

    long getScore(Roll roll);
}
