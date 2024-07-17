package org.kata.yatzy.yatzy1;

import org.kata.yatzy.Die;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Yatzy1 {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIFTEEN = 15;
    public static final int TWENTY = 20;
    public static final int FIFTY = 50;

    private Yatzy1() {
    }

    public static int chance(List<Die> dice) {
        return dice
                .stream()
                .map(Die::getValue)
                .reduce(ZERO, Integer::sum);
    }

    public static int yatzy(List<Die> dice) {
        return dice.stream().distinct().count() == ONE ? FIFTY : ZERO;
    }

    public static int ones(List<Die> dice) {
        return oneNumberCategory(dice, Die.ONE);
    }

    public static int twos(List<Die> dice) {
        return oneNumberCategory(dice, Die.TWO);
    }

    public static int threes(List<Die> dice) {
        return oneNumberCategory(dice, Die.THREE);
    }

    public static int fours(List<Die> dice) {
        return oneNumberCategory(dice, Die.FOUR);
    }

    public static int fives(List<Die> dice) {
        return oneNumberCategory(dice, Die.FIVE);
    }

    public static int sixes(List<Die> dice) {
        return oneNumberCategory(dice, Die.SIX);
    }

    public static int pair(List<Die> dice) {
        return occurrencesOfAKind(dice, TWO);
    }

    public static int twoPairs(List<Die> dice) {
        List<Die> pairsDice = dice
                .stream()
                .filter(die -> count(dice, die) >= TWO)
                .distinct()
                .toList();
        if (pairsDice.size() != TWO) {
            return ZERO;
        }
        return TWO * pairsDice
                .stream()
                .map(Die::getValue)
                .reduce(ZERO, Integer::sum);
    }

    public static int threeOfAKind(List<Die> dice) {
        return occurrencesOfAKind(dice, THREE);
    }

    public static int fourOfAKind(List<Die> dice) {
        return occurrencesOfAKind(dice, FOUR);
    }

    public static int smallStraight(List<Die> dice) {
        final Set<Die> smallStraightSet = Set.of(Die.ONE, Die.TWO, Die.THREE, Die.FOUR, Die.FIVE);
        if (straight(dice, smallStraightSet)) {
            return FIFTEEN;
        }
        return ZERO;
    }

    public static int largeStraight(List<Die> dice) {
        final Set<Die> largeStraightSet = Set.of(Die.TWO, Die.THREE, Die.FOUR, Die.FIVE, Die.SIX);
        if (straight(dice, largeStraightSet)) {
            return TWENTY;
        }
        return ZERO;
    }

    public static int fullHouse(List<Die> dice) {
        int twoOccurrencesDie = numberOccurrencesDie(dice, TWO);
        int threeOccurrencesDie = numberOccurrencesDie(dice, THREE);

        return twoOccurrencesDie > ZERO && threeOccurrencesDie > ZERO ?
                twoOccurrencesDie * TWO + threeOccurrencesDie * THREE :
                ZERO;
    }

    private static int numberOccurrencesDie(List<Die> dice, int occurrences) {
        return dice
                .stream()
                .filter(die -> count(dice, die) == occurrences)
                .findFirst()
                .map(Die::getValue)
                .orElse(ZERO);
    }

    private static int count(List<Die> dice, Die die) {
        return (int) dice.stream()
                .filter(die::equals)
                .count();
    }

    private static int oneNumberCategory(List<Die> dice, Die die) {
        return count(dice, die) * die.getValue();
    }

    private static int occurrencesOfAKind(List<Die> dice, int occurrences) {
        return dice
                .stream()
                .filter(die -> count(dice, die) >= occurrences)
                .map(Die::getValue)
                .max(Integer::compareTo)
                .map(die -> die * occurrences)
                .orElse(ZERO);
    }

    private static boolean straight(List<Die> dice, Set<Die> straightDice) {
        return new HashSet<>(dice).equals(straightDice);
    }
}
