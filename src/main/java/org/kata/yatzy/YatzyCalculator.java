package org.kata.yatzy;

import java.util.List;

public interface YatzyCalculator {
    List<YatzyCategory> validCategories();

    int score(List<Die> dice, YatzyCategory category);
}
