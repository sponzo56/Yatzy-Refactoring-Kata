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
        List<IDie> listFaces = Collections.EMPTY_LIST;
        Collections.addAll(listFaces = new ArrayList<>(),
            new SixFacesDie(6), new SixFacesDie(6), new SixFacesDie(6),
            new SixFacesDie(3), new SixFacesDie(3));
        int faceValue = 6;
        assertEquals(3L, YatzyRoll.countDiceWithFaceValue(faceValue, listFaces));
    }

    @Test
    void getRollComposition() {
        List<IDie> listFaces = Collections.EMPTY_LIST;
        Collections.addAll(listFaces = new ArrayList<>(),
            new SixFacesDie(6), new SixFacesDie(6), new SixFacesDie(6),
            new SixFacesDie(3), new SixFacesDie(3));
        Map<Integer, Long> composition = new HashMap<>();
        composition.put(3, 2L);
        composition.put(6, 3L);
        assertEquals(composition, YatzyRoll.getRollComposition(listFaces));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForGetScore")
    void getScore_ShouldReturnScoreForValidRoll(YatzyRoll roll, long score) {
        assertEquals(score, roll.getScore(roll));
    }

    private static Stream<Arguments> provideArgumentsForGetScore() {

        List<IDie> listFacesChance = Collections.EMPTY_LIST;
        Collections.addAll(listFacesChance = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(1), new SixFacesDie(2),
            new SixFacesDie(3), new SixFacesDie(5));
        YatzyRoll rollChance = new YatzyRoll(listFacesChance, Category.CHANCE);

        List<IDie> listFacesOnes = Collections.EMPTY_LIST;
        Collections.addAll(listFacesOnes = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(1), new SixFacesDie(2),
            new SixFacesDie(3), new SixFacesDie(5));
        YatzyRoll rollOnes = new YatzyRoll(listFacesOnes, Category.ONES);

        List<IDie> listFacesTwos = Collections.EMPTY_LIST;
        Collections.addAll(listFacesTwos = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(1), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(2));
        YatzyRoll rollTwos = new YatzyRoll(listFacesTwos, Category.TWOS);

        List<IDie> listFacesThrees = Collections.EMPTY_LIST;
        Collections.addAll(listFacesThrees = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(3), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(3));
        YatzyRoll rollThrees = new YatzyRoll(listFacesThrees, Category.THREES);

        List<IDie> listFacesFours = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFours = new ArrayList<>(),
            new SixFacesDie(4), new SixFacesDie(3), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(3));
        YatzyRoll rollFours = new YatzyRoll(listFacesFours, Category.FOURS);

        List<IDie> listFacesFives = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFives = new ArrayList<>(),
            new SixFacesDie(4), new SixFacesDie(5), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(3));
        YatzyRoll rollFives = new YatzyRoll(listFacesFives, Category.FIVES);

        List<IDie> listFacesSixes = Collections.EMPTY_LIST;
        Collections.addAll(listFacesSixes = new ArrayList<>(),
            new SixFacesDie(4), new SixFacesDie(5), new SixFacesDie(2),
            new SixFacesDie(6), new SixFacesDie(6));
        YatzyRoll rollSixes = new YatzyRoll(listFacesSixes, Category.SIXES);

        List<IDie> listFacesInvalidYatzy = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidYatzy = new ArrayList<>(),
            new SixFacesDie(4), new SixFacesDie(5), new SixFacesDie(2),
            new SixFacesDie(6), new SixFacesDie(6));
        YatzyRoll rollInvalidYatzy = new YatzyRoll(listFacesInvalidYatzy, Category.YATZY);

        List<IDie> listFacesValidYatzy = Collections.EMPTY_LIST;
        Collections.addAll(listFacesValidYatzy = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(2), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(2));
        YatzyRoll rollValidYatzy = new YatzyRoll(listFacesValidYatzy, Category.YATZY);

        List<IDie> listFacesInvalidYatzy2 = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidYatzy2 = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(6), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(2));
        YatzyRoll rollInvalidYatzy2 = new YatzyRoll(listFacesInvalidYatzy2, Category.YATZY);

        List<IDie> listFacesPair = Collections.EMPTY_LIST;
        Collections.addAll(listFacesPair = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(6), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(2));
        YatzyRoll rollPair = new YatzyRoll(listFacesPair, Category.PAIR);

        List<IDie> listFacesMaxPair = Collections.EMPTY_LIST;
        Collections.addAll(listFacesMaxPair = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(6), new SixFacesDie(5),
            new SixFacesDie(2), new SixFacesDie(5));
        YatzyRoll rollMaxPair = new YatzyRoll(listFacesMaxPair, Category.PAIR);

        List<IDie> listFacesInvalidPair = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidPair = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(2), new SixFacesDie(4),
            new SixFacesDie(3), new SixFacesDie(5));
        YatzyRoll rollInvalidPair = new YatzyRoll(listFacesInvalidPair, Category.PAIR);

        List<IDie> listFacesTwoPairs = Collections.EMPTY_LIST;
        Collections.addAll(listFacesTwoPairs = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(2), new SixFacesDie(4),
            new SixFacesDie(5), new SixFacesDie(5));
        YatzyRoll rollTwoPairs = new YatzyRoll(listFacesTwoPairs, Category.TWO_PAIRS);

        List<IDie> listFacesInvalidTwoPairs = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidTwoPairs = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(2), new SixFacesDie(4),
            new SixFacesDie(2), new SixFacesDie(2));
        YatzyRoll rollInvalidTwoPairs = new YatzyRoll(listFacesInvalidTwoPairs, Category.TWO_PAIRS);

        List<IDie> listFacesThreeOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesThreeOfAKind = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(2), new SixFacesDie(4),
            new SixFacesDie(2), new SixFacesDie(2));
        YatzyRoll rollThreeOfAKind = new YatzyRoll(listFacesThreeOfAKind, Category.THREE_OF_A_KIND);

        List<IDie> listFacesThreeOfAKind2 = Collections.EMPTY_LIST;
        Collections.addAll(listFacesThreeOfAKind2 = new ArrayList<>(),
            new SixFacesDie(6), new SixFacesDie(2), new SixFacesDie(4),
            new SixFacesDie(6), new SixFacesDie(6));
        YatzyRoll rollThreeOfAKind2 = new YatzyRoll(listFacesThreeOfAKind2, Category.THREE_OF_A_KIND);

        List<IDie> listFacesInvalidThreeOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidThreeOfAKind = new ArrayList<>(),
            new SixFacesDie(5), new SixFacesDie(2), new SixFacesDie(4),
            new SixFacesDie(6), new SixFacesDie(6));
        YatzyRoll rollInvalidThreeOfAKind = new YatzyRoll(listFacesInvalidThreeOfAKind, Category.THREE_OF_A_KIND);

        List<IDie> listFacesFourOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFourOfAKind = new ArrayList<>(),
            new SixFacesDie(2), new SixFacesDie(2), new SixFacesDie(2),
            new SixFacesDie(2), new SixFacesDie(5));
        YatzyRoll rollFourOfAKind = new YatzyRoll(listFacesFourOfAKind, Category.FOUR_OF_A_KIND);

        List<IDie> listFacesFourOfAKind2 = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFourOfAKind2 = new ArrayList<>(),
            new SixFacesDie(6), new SixFacesDie(6), new SixFacesDie(6),
            new SixFacesDie(6), new SixFacesDie(6));
        YatzyRoll rollFourOfAKind2 = new YatzyRoll(listFacesFourOfAKind2, Category.FOUR_OF_A_KIND);

        List<IDie> listFacesInvalidFourOfAKind = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidFourOfAKind = new ArrayList<>(),
            new SixFacesDie(5), new SixFacesDie(5), new SixFacesDie(5),
            new SixFacesDie(2), new SixFacesDie(2));
        YatzyRoll rollInvalidFourOfAKind = new YatzyRoll(listFacesInvalidFourOfAKind, Category.FOUR_OF_A_KIND);

        List<IDie> listFacesSmallStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesSmallStraight = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(5), new SixFacesDie(4),
            new SixFacesDie(2), new SixFacesDie(3));
        YatzyRoll rollSmallStraight = new YatzyRoll(listFacesSmallStraight, Category.SMALL_STRAIGHT);

        List<IDie> listFacesInvalidSmallStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidSmallStraight = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(6), new SixFacesDie(4),
            new SixFacesDie(2), new SixFacesDie(3));
        YatzyRoll rollInvalidSmallStraight = new YatzyRoll(listFacesInvalidSmallStraight, Category.SMALL_STRAIGHT);

        List<IDie> listFacesLargeStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesLargeStraight = new ArrayList<>(),
            new SixFacesDie(6), new SixFacesDie(5), new SixFacesDie(4),
            new SixFacesDie(2), new SixFacesDie(3));
        YatzyRoll rollLargeStraight = new YatzyRoll(listFacesLargeStraight, Category.LARGE_STRAIGHT);

        List<IDie> listFacesInvalidLargeStraight = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidLargeStraight = new ArrayList<>(),
            new SixFacesDie(1), new SixFacesDie(6), new SixFacesDie(4),
            new SixFacesDie(2), new SixFacesDie(3));
        YatzyRoll rollInvalidLargeStraight = new YatzyRoll(listFacesInvalidLargeStraight, Category.LARGE_STRAIGHT);

        List<IDie> listFacesFullHouse = Collections.EMPTY_LIST;
        Collections.addAll(listFacesFullHouse = new ArrayList<>(),
            new SixFacesDie(6), new SixFacesDie(6), new SixFacesDie(6),
            new SixFacesDie(3), new SixFacesDie(3));
        YatzyRoll rollFullHouse = new YatzyRoll(listFacesFullHouse, Category.FULL_HOUSE);

        List<IDie> listFacesInvalidFullHouse = Collections.EMPTY_LIST;
        Collections.addAll(listFacesInvalidFullHouse = new ArrayList<>(),
            new SixFacesDie(6), new SixFacesDie(6), new SixFacesDie(4),
            new SixFacesDie(3), new SixFacesDie(3));
        YatzyRoll rollInvalidFullHouse = new YatzyRoll(listFacesInvalidFullHouse, Category.FULL_HOUSE);

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
