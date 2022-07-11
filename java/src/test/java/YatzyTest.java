import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    void countDiceWithFaceValue() {
        List<Die> listFaces = Collections.EMPTY_LIST;
        Collections.addAll(listFaces = new ArrayList<>(),
            new Die(6), new Die(6), new Die(6),
            new Die(3), new Die(3));
        int faceValue = 6;
        assertEquals(3L, Roll.countDiceWithFaceValue(faceValue, listFaces));
    }

    @Test
    void getRollComposition() {
        List<Die> listFaces = Collections.EMPTY_LIST;
        Collections.addAll(listFaces = new ArrayList<>(),
            new Die(6), new Die(6), new Die(6),
            new Die(3), new Die(3));
        Map<Integer, Long> composition = new HashMap<>();
        composition.put(3, 2L);
        composition.put(6, 3L);
        assertEquals(composition, Roll.getRollComposition(listFaces));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForGetScore")
    void getScore_ShouldReturnScoreForValidRoll(Roll roll, long score) {
        assertEquals(score, roll.getScore(roll));
    }

    private static Stream<Arguments> provideArgumentsForGetScore() {

        List<Die> listFacesChance = Collections.EMPTY_LIST;
        Collections.addAll(listFacesChance = new ArrayList<>(),
            new Die(1), new Die(1), new Die(2),
            new Die(3), new Die(5));
        Roll rollChance = new Roll(listFacesChance, Category.CHANCE);

        List<Die> listFacesOnes = Collections.EMPTY_LIST;
        Collections.addAll(listFacesOnes = new ArrayList<>(),
            new Die(1), new Die(1), new Die(2),
            new Die(3), new Die(5));
        Roll rollOnes = new Roll(listFacesOnes, Category.ONES);

        List<Die> listFacesTwos = Collections.EMPTY_LIST;
        Collections.addAll(listFacesTwos = new ArrayList<>(),
            new Die(1), new Die(1), new Die(2),
            new Die(2), new Die(2));
        Roll rollTwos = new Roll(listFacesTwos, Category.TWOS);

        List<Die> listFacesThrees = Collections.EMPTY_LIST;
        Collections.addAll(listFacesThrees = new ArrayList<>(),
            new Die(1), new Die(3), new Die(2),
            new Die(2), new Die(3));
        Roll rollThrees = new Roll(listFacesThrees, Category.THREES);

        List<Die> listFacesFours = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFours = new ArrayList<>(),
            new Die(4), new Die(3), new Die(2),
            new Die(2), new Die(3));
        Roll rollFours = new Roll(listFacesFours, Category.FOURS);

        List<Die> listFacesFives = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFives = new ArrayList<>(),
            new Die(4), new Die(5), new Die(2),
            new Die(2), new Die(3));
        Roll rollFives = new Roll(listFacesFives, Category.FIVES);

        List<Die> listFacesSixes = Collections.EMPTY_LIST;
        Collections.addAll(listFacesSixes = new ArrayList<>(),
            new Die(4), new Die(5), new Die(2),
            new Die(6), new Die(6));
        Roll rollSixes = new Roll(listFacesSixes, Category.SIXES);

        List<Die> listFacesInvalidYatzy = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidYatzy = new ArrayList<>(),
            new Die(4), new Die(5), new Die(2),
            new Die(6), new Die(6));
        Roll rollInvalidYatzy = new Roll(listFacesInvalidYatzy, Category.YATZY);

        List<Die> listFacesValidYatzy = Collections.EMPTY_LIST;
        Collections.addAll(listFacesValidYatzy = new ArrayList<>(),
            new Die(2), new Die(2), new Die(2),
            new Die(2), new Die(2));
        Roll rollValidYatzy = new Roll(listFacesValidYatzy, Category.YATZY);

        List<Die> listFacesInvalidYatzy2 = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidYatzy2 = new ArrayList<>(),
            new Die(2), new Die(6), new Die(2),
            new Die(2), new Die(2));
        Roll rollInvalidYatzy2 = new Roll(listFacesInvalidYatzy2, Category.YATZY);

        List<Die> listFacesPair = Collections.EMPTY_LIST;
        Collections.addAll(listFacesPair = new ArrayList<>(),
            new Die(2), new Die(6), new Die(2),
            new Die(2), new Die(2));
        Roll rollPair = new Roll(listFacesPair, Category.PAIR);

        List<Die> listFacesMaxPair = Collections.EMPTY_LIST;
        Collections.addAll(listFacesMaxPair = new ArrayList<>(),
            new Die(2), new Die(6), new Die(5),
            new Die(2), new Die(5));
        Roll rollMaxPair = new Roll(listFacesMaxPair, Category.PAIR);

        List<Die> listFacesInvalidPair = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidPair = new ArrayList<>(),
            new Die(1), new Die(2), new Die(4),
            new Die(3), new Die(5));
        Roll rollInvalidPair = new Roll(listFacesInvalidPair, Category.PAIR);

        List<Die> listFacesTwoPairs = Collections.EMPTY_LIST;
        Collections.addAll(listFacesTwoPairs = new ArrayList<>(),
            new Die(2), new Die(2), new Die(4),
            new Die(5), new Die(5));
        Roll rollTwoPairs = new Roll(listFacesTwoPairs, Category.TWO_PAIRS);

        List<Die> listFacesInvalidTwoPairs = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidTwoPairs = new ArrayList<>(),
            new Die(2), new Die(2), new Die(4),
            new Die(2), new Die(2));
        Roll rollInvalidTwoPairs = new Roll(listFacesInvalidTwoPairs, Category.TWO_PAIRS);

        List<Die> listFacesThreeOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesThreeOfAKind = new ArrayList<>(),
            new Die(2), new Die(2), new Die(4),
            new Die(2), new Die(2));
        Roll rollThreeOfAKind = new Roll(listFacesThreeOfAKind, Category.THREE_OF_A_KIND);

        List<Die> listFacesThreeOfAKind2 = Collections.EMPTY_LIST;
        Collections.addAll(listFacesThreeOfAKind2 = new ArrayList<>(),
            new Die(6), new Die(2), new Die(4),
            new Die(6), new Die(6));
        Roll rollThreeOfAKind2 = new Roll(listFacesThreeOfAKind2, Category.THREE_OF_A_KIND);

        List<Die> listFacesInvalidThreeOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidThreeOfAKind = new ArrayList<>(),
            new Die(5), new Die(2), new Die(4),
            new Die(6), new Die(6));
        Roll rollInvalidThreeOfAKind = new Roll(listFacesInvalidThreeOfAKind, Category.THREE_OF_A_KIND);

        List<Die> listFacesFourOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFourOfAKind = new ArrayList<>(),
            new Die(2), new Die(2), new Die(2),
            new Die(2), new Die(5));
        Roll rollFourOfAKind = new Roll(listFacesFourOfAKind, Category.FOUR_OF_A_KIND);

        List<Die> listFacesFourOfAKind2 = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFourOfAKind2 = new ArrayList<>(),
            new Die(6), new Die(6), new Die(6),
            new Die(6), new Die(6));
        Roll rollFourOfAKind2 = new Roll(listFacesFourOfAKind2, Category.FOUR_OF_A_KIND);

        List<Die> listFacesInvalidFourOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidFourOfAKind = new ArrayList<>(),
            new Die(5), new Die(5), new Die(5),
            new Die(2), new Die(2));
        Roll rollInvalidFourOfAKind = new Roll(listFacesInvalidFourOfAKind, Category.FOUR_OF_A_KIND);

        List<Die> listFacesSmallStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesSmallStraight = new ArrayList<>(),
            new Die(1), new Die(5), new Die(4),
            new Die(2), new Die(3));
        Roll rollSmallStraight = new Roll(listFacesSmallStraight, Category.SMALL_STRAIGHT);

        List<Die> listFacesInvalidSmallStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidSmallStraight = new ArrayList<>(),
            new Die(1), new Die(6), new Die(4),
            new Die(2), new Die(3));
        Roll rollInvalidSmallStraight = new Roll(listFacesInvalidSmallStraight, Category.SMALL_STRAIGHT);

        List<Die> listFacesLargeStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesLargeStraight = new ArrayList<>(),
            new Die(6), new Die(5), new Die(4),
            new Die(2), new Die(3));
        Roll rollLargeStraight = new Roll(listFacesLargeStraight, Category.LARGE_STRAIGHT);

        List<Die> listFacesInvalidLargeStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidLargeStraight = new ArrayList<>(),
            new Die(1), new Die(6), new Die(4),
            new Die(2), new Die(3));
        Roll rollInvalidLargeStraight = new Roll(listFacesInvalidLargeStraight, Category.LARGE_STRAIGHT);

        List<Die> listFacesFullHouse = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFullHouse = new ArrayList<>(),
            new Die(6), new Die(6), new Die(6),
            new Die(3), new Die(3));
        Roll rollFullHouse = new Roll(listFacesFullHouse, Category.FULL_HOUSE);

        List<Die> listFacesInvalidFullHouse = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidFullHouse = new ArrayList<>(),
            new Die(6), new Die(6), new Die(4),
            new Die(3), new Die(3));
        Roll rollInvalidFullHouse = new Roll(listFacesInvalidFullHouse, Category.FULL_HOUSE);

        return Stream.of(
            Arguments.of(rollChance, 12L),
            Arguments.of(rollOnes, 2L),
            Arguments.of(rollTwos, 6L),
            Arguments.of(rollThrees, 6L),
            Arguments.of(rollFours, 4L),
            Arguments.of(rollFives, 5L),
            Arguments.of(rollSixes, 12L),
            Arguments.of(rollInvalidYatzy, 0L),
            Arguments.of(rollValidYatzy, 50L),
            Arguments.of(rollInvalidYatzy2, 0L),
            Arguments.of(rollPair, 4L),
            Arguments.of(rollMaxPair, 10L),
            Arguments.of(rollInvalidPair, 0L),
            Arguments.of(rollTwoPairs, 14L),
            Arguments.of(rollInvalidTwoPairs, 0L),
            Arguments.of(rollThreeOfAKind, 6L),
            Arguments.of(rollThreeOfAKind2, 18L),
            Arguments.of(rollInvalidThreeOfAKind, 0L),
            Arguments.of(rollFourOfAKind, 8L),
            Arguments.of(rollFourOfAKind2, 24L),
            Arguments.of(rollInvalidFourOfAKind, 0L),
            Arguments.of(rollSmallStraight, 15L),
            Arguments.of(rollInvalidSmallStraight, 0L),
            Arguments.of(rollLargeStraight, 20L),
            Arguments.of(rollInvalidLargeStraight, 0L),
            Arguments.of(rollFullHouse, 24L),
            Arguments.of(rollInvalidFullHouse, 0L)
        );
    }
}
