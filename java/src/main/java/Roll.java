import java.util.*;
import java.util.stream.IntStream;

public class Roll implements IRoll {

    private final List<Die> listDice;
    private final Category category;

    public Roll(List<Die> listDice, Category category) {
        this.listDice = listDice;
        this.category = category;
    }

    public static long countDiceWithFaceValue(int faceValue, List<Die> listDice) {
        return listDice.stream().filter(d -> d.getFaceValue() == faceValue)
            .count();
    }

    public static Map<Integer, Long> getRollComposition(List<Die> listDice) {
        Map<Integer, Long> composition = new HashMap<>();
        IntStream facesRange = IntStream.range(1, Die.nbFaces + 1);
        facesRange.forEach(f -> {
            if (Roll.countDiceWithFaceValue(f, listDice) != 0) {
                composition.put(f,Roll.countDiceWithFaceValue(f, listDice));
            }
        });
        return composition;
    }

    @Override
    public long getScore(Roll roll) {
        Map<Integer, Long> rollComposition = getRollComposition(roll.listDice);
        long score = 0;
        switch (roll.category) {
            case CHANCE:
                score = roll.listDice.stream().map(Die::getFaceValue).reduce(0, Integer::sum);
                break;
            case YATZY:
                score = rollComposition.size() == 1 ? 50L : 0L;
                break;
            case ONES:
                if (rollComposition.containsKey(1)) score = rollComposition.get(1);
                break;
            case TWOS:
                if (rollComposition.containsKey(2)) score = rollComposition.get(2) * 2;
                break;
            case THREES:
                if (rollComposition.containsKey(3)) score = rollComposition.get(3) * 3;
                break;
            case FOURS:
                if (rollComposition.containsKey(4)) score = rollComposition.get(4) * 4;
                break;
            case FIVES:
                if (rollComposition.containsKey(5)) score = rollComposition.get(5) * 5;
                break;
            case SIXES:
                if (rollComposition.containsKey(6)) score = rollComposition.get(6) * 6;
                break;
            case PAIR:
                rollComposition.values().removeIf(v -> v.equals(1L));
                if (rollComposition.size() != 0) score = Collections.max(rollComposition.keySet()) * 2;
                break;
            case TWO_PAIRS:
                rollComposition.values().removeIf(v -> v.equals(1L));
                if (rollComposition.size() == 2) score = rollComposition.keySet().stream().reduce(0, Integer::sum) * 2;
                break;
            case THREE_OF_A_KIND:
                rollComposition.values().removeIf(v -> v.equals(1L) || v.equals(2L));
                if (rollComposition.size() == 1) score = rollComposition.keySet().stream().reduce(0, Integer::sum) * 3;
                break;
            case FOUR_OF_A_KIND:
                rollComposition.values().removeIf(v -> v.equals(1L) || v.equals(2L) || v.equals(3L));
                if (rollComposition.size() == 1) score = rollComposition.keySet().stream().reduce(0, Integer::sum) * 4;
                break;
            case SMALL_STRAIGHT:
                if (rollComposition.keySet().size() == Roll.nbDice
                    && Collections.min(rollComposition.keySet()) == 1
                    && Collections.max(rollComposition.keySet()) == 5) score = 15L;
                break;
            case LARGE_STRAIGHT:
                if (rollComposition.keySet().size() == Roll.nbDice
                    && Collections.min(rollComposition.keySet()) == 2
                    && Collections.max(rollComposition.keySet()) == 6) score = 20L;
                break;
            case FULL_HOUSE:
                if (rollComposition.containsValue(2L) && rollComposition.containsValue(3L))
                    score = roll.listDice.stream().map(Die::getFaceValue).reduce(0, Integer::sum);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + roll.category);
        }
        return score;
    }
}
