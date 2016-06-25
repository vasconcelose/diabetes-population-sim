// Deal with everything that concerns to randomness
package util;

import java.util.Random;

import model.Man;
import model.Woman;
import util.Constants;

public class Odds {

	public static boolean getRandomSex() {
		return new Random().nextBoolean(); // true: man, false: woman
	}

	public static double oddsForCouple(Man father, Woman mother) {
		if (father.isDiabetic() && !mother.isDiabetic()) {
			if (father.isBeforeAgeEleven()) {
				return Constants.ODDS_FATHER_ONLY * 2.0;
			} else {
				return Constants.ODDS_FATHER_ONLY;
			}
		} else if (!father.isDiabetic() && mother.isDiabetic()) {
			if (mother.isLessThanTwentyFive()) {
				if (mother.isBeforeAgeEleven()) {
					return Constants.ODDS_MOTHER_ONLY_LESS_THAN_TWENTY_FIVE * 2.0;
				} else {
					return Constants.ODDS_MOTHER_ONLY_LESS_THAN_TWENTY_FIVE;
				}
			} else {
				if (mother.isBeforeAgeEleven()) {
					return Constants.ODDS_MOTHER_ONLY_NOT_LESS_THAN_TWENTY_FIVE * 2.0;
				} else {
					return Constants.ODDS_MOTHER_ONLY_NOT_LESS_THAN_TWENTY_FIVE;
				}
			}
		} else if (father.isDiabetic() && mother.isDiabetic()) {
			return 0.1 + Math.random() * 0.15;
		} else {
			return 0.0;
		}
	}

}

