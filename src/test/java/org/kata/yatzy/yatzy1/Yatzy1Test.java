package org.kata.yatzy.yatzy1;

import org.junit.jupiter.api.Test;
import org.kata.yatzy.Die;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Yatzy1Test {

    @Test
    void chance_scores_the_sum_of_all_dice() {
        assertEquals(15, Yatzy1.chance(List.of(Die.TWO, Die.THREE, Die.FOUR, Die.FIVE, Die.ONE)));
        assertEquals(16, Yatzy1.chance(List.of(Die.THREE, Die.THREE, Die.FOUR, Die.FIVE, Die.ONE)));
    }

    @Test
    void yatzy_scores_fifty() {
        assertEquals(50, Yatzy1.yatzy(List.of(Die.FOUR, Die.FOUR, Die.FOUR, Die.FOUR, Die.FOUR)));
        assertEquals(50, Yatzy1.yatzy(List.of(Die.SIX, Die.SIX, Die.SIX, Die.SIX, Die.SIX)));
        assertEquals(0, Yatzy1.yatzy(List.of(Die.SIX, Die.SIX, Die.SIX, Die.SIX, Die.THREE)));
    }

    @Test
    void ones_scores_the_number_of_one_dice() {
        assertEquals(1, Yatzy1.ones(List.of(Die.ONE, Die.TWO, Die.THREE, Die.FOUR, Die.FIVE)));
        assertEquals(2, Yatzy1.ones(List.of(Die.ONE, Die.TWO, Die.ONE, Die.FOUR, Die.FIVE)));
        assertEquals(0, Yatzy1.ones(List.of(Die.SIX, Die.TWO, Die.TWO, Die.FOUR, Die.FIVE)));
        assertEquals(4, Yatzy1.ones(List.of(Die.ONE, Die.TWO, Die.ONE, Die.ONE, Die.ONE)));
    }

    @Test
    void twos_scores_the_number_of_two_dice() {
        assertEquals(4, Yatzy1.twos(List.of(Die.ONE, Die.TWO, Die.THREE, Die.TWO, Die.SIX)));
        assertEquals(10, Yatzy1.twos(List.of(Die.TWO, Die.TWO, Die.TWO, Die.TWO, Die.TWO)));
    }

    @Test
    void threes_scores_the_number_of_three_dice() {
        assertEquals(6, Yatzy1.threes(List.of(Die.ONE, Die.TWO, Die.THREE, Die.TWO, Die.THREE)));
        assertEquals(12, Yatzy1.threes(List.of(Die.TWO, Die.THREE, Die.THREE, Die.THREE, Die.THREE)));
    }

    @Test
    void fours_scores_the_number_of_four_dice() {
        assertEquals(12, Yatzy1.fours(List.of(Die.FOUR, Die.FOUR, Die.FOUR, Die.FIVE, Die.FIVE)));
        assertEquals(8, Yatzy1.fours(List.of(Die.FOUR, Die.FOUR, Die.FIVE, Die.FIVE, Die.FIVE)));
        assertEquals(4, Yatzy1.fours(List.of(Die.FOUR, Die.FIVE, Die.FIVE, Die.FIVE, Die.FIVE)));
    }

    @Test
    void fives_scores_the_number_of_four_dice() {
        assertEquals(10, Yatzy1.fives(List.of(Die.FOUR, Die.FOUR, Die.FOUR, Die.FIVE, Die.FIVE)));
        assertEquals(15, Yatzy1.fives(List.of(Die.FOUR, Die.FOUR, Die.FIVE, Die.FIVE, Die.FIVE)));
        assertEquals(20, Yatzy1.fives(List.of(Die.FOUR, Die.FIVE, Die.FIVE, Die.FIVE, Die.FIVE)));
    }

    @Test
    void sixes_scores_the_number_of_six_dice() {
        assertEquals(0, Yatzy1.sixes(List.of(Die.FOUR, Die.FOUR, Die.FOUR, Die.FIVE, Die.FIVE)));
        assertEquals(6, Yatzy1.sixes(List.of(Die.FOUR, Die.FOUR, Die.SIX, Die.FIVE, Die.FIVE)));
        assertEquals(18, Yatzy1.sixes(List.of(Die.SIX, Die.FIVE, Die.SIX, Die.SIX, Die.FIVE)));
    }

    @Test
    void one_pair_scores_the_sum_of_the_two_highest_matching_dice() {
        assertEquals(6, Yatzy1.pair(List.of(Die.THREE, Die.FOUR, Die.THREE, Die.FIVE, Die.SIX)));
        assertEquals(10, Yatzy1.pair(List.of(Die.FIVE, Die.THREE, Die.THREE, Die.THREE, Die.FIVE)));
        assertEquals(12, Yatzy1.pair(List.of(Die.FIVE, Die.THREE, Die.SIX, Die.SIX, Die.FIVE)));
    }

    @Test
    void two_pairs_scores_the_sum_of_the_two_pairs_of_matching_dice() {
        assertEquals(16, Yatzy1.twoPairs(List.of(Die.THREE, Die.THREE, Die.FIVE, Die.FOUR, Die.FIVE)));
        assertEquals(16, Yatzy1.twoPairs(List.of(Die.THREE, Die.THREE, Die.FIVE, Die.FIVE, Die.FIVE)));
    }

    @Test
    void three_of_a_kind_scores_the_sum_of_the_three_matching_dice() {
        assertEquals(9, Yatzy1.threeOfAKind(List.of(Die.THREE, Die.THREE, Die.THREE, Die.FOUR, Die.FIVE)));
        assertEquals(15, Yatzy1.threeOfAKind(List.of(Die.FIVE, Die.THREE, Die.FIVE, Die.FOUR, Die.FIVE)));
        assertEquals(9, Yatzy1.threeOfAKind(List.of(Die.THREE, Die.THREE, Die.THREE, Die.THREE, Die.FIVE)));
    }

    @Test
    void four_of_a_kind_scores_the_sum_of_the_four_matching_dice() {
        assertEquals(12, Yatzy1.fourOfAKind(List.of(Die.THREE, Die.THREE, Die.THREE, Die.THREE, Die.FIVE)));
        assertEquals(20, Yatzy1.fourOfAKind(List.of(Die.FIVE, Die.FIVE, Die.FIVE, Die.FOUR, Die.FIVE)));
        assertEquals(9, Yatzy1.threeOfAKind(List.of(Die.THREE, Die.THREE, Die.THREE, Die.THREE, Die.THREE)));
    }

    @Test
    void small_straight_scores_fifteen() {
        assertEquals(15, Yatzy1.smallStraight(List.of(Die.ONE, Die.TWO, Die.THREE, Die.FOUR, Die.FIVE)));
        assertEquals(15, Yatzy1.smallStraight(List.of(Die.TWO, Die.THREE, Die.FOUR, Die.FIVE, Die.ONE)));
        assertEquals(0, Yatzy1.smallStraight(List.of(Die.ONE, Die.TWO, Die.TWO, Die.FOUR, Die.FIVE)));
    }

    @Test
    void large_straight_scores_twenty() {
        assertEquals(20, Yatzy1.largeStraight(List.of(Die.SIX, Die.TWO, Die.THREE, Die.FOUR, Die.FIVE)));
        assertEquals(20, Yatzy1.largeStraight(List.of(Die.TWO, Die.THREE, Die.FOUR, Die.FIVE, Die.SIX)));
        assertEquals(0, Yatzy1.largeStraight(List.of(Die.ONE, Die.TWO, Die.TWO, Die.FOUR, Die.FIVE)));
    }

    @Test
    void full_house_scores_the_sum_of_two_and_three_of_a_kind_dice() {
        assertEquals(18, Yatzy1.fullHouse(List.of(Die.SIX, Die.TWO, Die.TWO, Die.TWO, Die.SIX)));
        assertEquals(0, Yatzy1.fullHouse(List.of(Die.TWO, Die.THREE, Die.FOUR, Die.FIVE, Die.SIX)));
    }

}
