package diabetesinheritance;

import java.util.ArrayList;
import java.util.Random;

import model.Man;
import model.Woman;
import util.Constants;
import util.Odds;

public class Generation {
	private int generationNumber;
	private int numberOfIndividuals;
	private int numberOfDiabetics;
	private ArrayList<Man> men;
	private ArrayList<Woman> women;

	public Generation(int generationNumber) {
		super();
		this.generationNumber = generationNumber;
		numberOfIndividuals = 0;
		numberOfDiabetics = 0;
		men = new ArrayList<>();
		women = new ArrayList<>();
	}

	/*
	 * Debugging purposes ...
	 */
	public int countNumberOfIndividualsAgain() {
		return men.size() + women.size();
	}

	public int countNumberOfDiabeticsAgain() {
		int nNumberOfDiabetics = 0;
		for (Woman woman : women) {
			if (woman.isDiabetic()) {
				nNumberOfDiabetics++;
			}
		}

		for (Man man : men) {
			if (man.isDiabetic()) {
				nNumberOfDiabetics++;
			}
		}

		return nNumberOfDiabetics;
	}

	public int numberOfMomsUnderTwentyFive() {
		int numberOfMomsUnderTwentyFive = 0;
		for (Woman woman : women) {
			if (woman.isLessThanTwentyFive()) {
				numberOfMomsUnderTwentyFive++;
			}
		}
		return numberOfMomsUnderTwentyFive;
	}
	
	public int numberOfDiabeticMen() {
		int numberOfDiabeticMen = 0;
		for (Man man : men) {
			if (man.isDiabetic()) {
				numberOfDiabeticMen++;
			}
		}
		return numberOfDiabeticMen;
	}
	
	public int numberOfDiabeticWomen() {
		int numberOfDiabeticWomen = 0;
		for (Woman woman : women) {
			if (woman.isDiabetic()) {
				numberOfDiabeticWomen++;
			}
		}
		return numberOfDiabeticWomen;
	}
	
	public int numberOfDiabeticMenUnderEleven() {
		int numberOfDiabeticMenBeforeEleven = 0;
		for (Man man : men) {
			if (man.isBeforeAgeEleven()) {
				numberOfDiabeticMenBeforeEleven++;
			}
		}
		return numberOfDiabeticMenBeforeEleven;
	}
	
	public int numberOfDiabeticWomenUnderEleven() {
		int numberOfDiabeticWomenBeforeEleven = 0;
		for (Woman woman : women) {
			if (woman.isBeforeAgeEleven()) {
				numberOfDiabeticWomenBeforeEleven++;
			}
		}
		return numberOfDiabeticWomenBeforeEleven;
	}

	/*
	 * ...
	 */
	
	public void removeRandomMan() {
		int manToRemove = new Random().nextInt(men.size());
		Man man = men.get(manToRemove);
		if (man.isDiabetic()) {
			numberOfDiabetics--;
		}
		numberOfIndividuals--;
		men.remove(manToRemove);
	}
	
	public void removeRandomWoman() {
		int womanToRemove = new Random().nextInt(women.size());
		Woman woman = women.get(womanToRemove);
		if (woman.isDiabetic()) {
			numberOfDiabetics--;
		}
		numberOfIndividuals--;
		women.remove(womanToRemove);
	}

	public void procreate(Generation childGeneration) {
		for (Woman mother : women) {
			// Same partner ...
//			Random random = new Random();
//			int fatherIndex = random.nextInt(men.size());
//			Man father = men.get(fatherIndex);
//			double childOdds = Odds.oddsForCouple(father, mother);
			// ...
			for (int i = 0; i < Constants.WOMEN_S_FERTILITY; i++) {
				// Random partners ...
				Random random = new Random();
				int fatherIndex = random.nextInt(men.size());
				Man father = men.get(fatherIndex);
				double childOdds = Odds.oddsForCouple(father, mother);
				// ...
				/*
				 * if...else I don't know if the child has diabetes, even if
				 * there are chances, hence, I don't know if he will develop the
				 * disease before age 11. This will be worked out later (mature)
				 */
				if (Odds.getRandomSex()) {
					Man man = new Man(true, false, false);
					man.setChanceOfDevelopingDiabetes(childOdds);
					childGeneration.addMan(man);
				} else {
					Woman woman = new Woman(false, false, false, false);
					woman.setChanceOfDevelopingDiabetes(childOdds);
					childGeneration.addWoman(woman);
				}
			}
		}
	}

	// Make individuals grow to relevant reproductive age
	public void mature() {
		for (Man man : men) {
			// man is diagnosed with diabetes between ages 0 - 11
			for (int i = 0; i < 11; i++) {
				if (Math.random() < man.getChanceOfDevelopingDiabetes()) {
					if (!man.isBeforeAgeEleven()) {
						man.setBeforeAgeEleven(true);
						man.setDiabetic(true);
						incrementNumberOfDiabetics();
					}
				}
			}

			// man is diagnosed with diabetes after age 11
			if (!man.isDiabetic()) {
				if (Math.random() < man.getChanceOfDevelopingDiabetes()) {
					man.setDiabetic(true);
					incrementNumberOfDiabetics();
				}
			}
		}

		for (Woman woman : women) {
			// woman is diagnosed with diabetes between ages 0 - 11
			for (int i = 0; i < 11; i++) {
				if (Math.random() < woman.getChanceOfDevelopingDiabetes()) {
					if (!woman.isBeforeAgeEleven()) {
						woman.setBeforeAgeEleven(true);
						woman.setDiabetic(true);
						incrementNumberOfDiabetics();
					}
				}
			}

			if (!woman.isDiabetic()) {
				// woman is diagnosed with diabetes after age 11
				if (Math.random() < woman.getChanceOfDevelopingDiabetes()) {
					woman.setDiabetic(true);
					incrementNumberOfDiabetics();
				}
			}
		}

		// a percentage of women turns 25 before having children (real one)
		int momsUnderTwentyFive = (int) ((Constants.MOMS_UNDER_AGE_25) * women
				.size());
		int i = 0;
		for (Woman mom : women) {
			if (i == momsUnderTwentyFive) {
				break;
			}
			mom.setLessThanTwentyFive(true);
			i++;
		}
	}

	public void incrementNumberOfDiabetics() {
		numberOfDiabetics++;
	}

	public void addMan(Man man) {
		men.add(man);
		numberOfIndividuals++;
	}

	public void addWoman(Woman woman) {
		women.add(woman);
		numberOfIndividuals++;
	}

	public int getGenerationNumber() {
		return generationNumber;
	}

	public void setGenerationNumber(int generationNumber) {
		this.generationNumber = generationNumber;
	}

	public int getNumberOfIndividuals() {
		return numberOfIndividuals;
	}

	public void setNumberOfIndividuals(int numberOfIndividuals) {
		this.numberOfIndividuals = numberOfIndividuals;
	}

	public int getNumberOfDiabetics() {
		return numberOfDiabetics;
	}

	public void setNumberOfDiabetics(int numberOfDiabetics) {
		this.numberOfDiabetics = numberOfDiabetics;
	}

	public ArrayList<Man> getMen() {
		return men;
	}

	public void setMen(ArrayList<Man> men) {
		this.men = men;
	}

	public ArrayList<Woman> getWomen() {
		return women;
	}

	public void setWomen(ArrayList<Woman> women) {
		this.women = women;
	}
}

