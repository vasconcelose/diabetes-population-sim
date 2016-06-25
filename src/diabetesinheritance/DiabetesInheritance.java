package diabetesinheritance;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import model.Man;
import model.Woman;
import util.Constants;
import util.Odds;

public class DiabetesInheritance {

	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException {
		System.out.println("First generation - not printed!");

		// Creating the first generation (whose parents are unknown)
		Generation firstGeneration = new Generation(0);
		for (int i = 0; i < Constants.POPULATION_SIZE; i++) {
			boolean male = Odds.getRandomSex();
			if (male) {
				boolean diabetic = Math.random() < Constants.DIABETICS;
				boolean underEleven = diabetic ? new Random().nextBoolean()
						: false;
				Man man = new Man(true, diabetic, underEleven);
				firstGeneration.addMan(man);
				if (diabetic) {
					firstGeneration.incrementNumberOfDiabetics();
				}
			} else {
				boolean diabetic = Math.random() < Constants.DIABETICS;
				boolean underEleven = diabetic ? new Random().nextBoolean()
						: false;
				boolean momUnderTwentyFive = Math.random() < Constants.MOMS_UNDER_AGE_25;
				Woman woman = new Woman(false, diabetic, underEleven,
						momUnderTwentyFive);
				firstGeneration.addWoman(woman);
				if (diabetic) {
					firstGeneration.incrementNumberOfDiabetics();
				}
			}
		}

		// Post-first generation and the ones after that
		Generation currentGeneration;
		Generation nextGeneration = firstGeneration;
		System.out.println("Printing...");
		PrintWriter printWriter = new PrintWriter("diabetessim.csv", "UTF-8");
		printWriter.println("Initial population," + Constants.POPULATION_SIZE);
		printWriter.println("Initial proportion of diabetics,"
				+ Constants.DIABETICS);
		printWriter.println("Fertility," + Constants.WOMEN_S_FERTILITY);
		printWriter.println("Proportion of moms under 25,"
				+ Constants.MOMS_UNDER_AGE_25);
		printWriter.println("Generations," + Constants.GENERATIONS);
		printWriter.println("Exchange factor," + Constants.EXCHANGE_FACTOR);
		printWriter
				.println("Generation,Size,Men,Women,Diabetics,Diabetic men, Diabetic women,Diabetic men before 11,Diabetic women before 11,Moms under 25");

		for (int i = 0; i < Constants.GENERATIONS; i++) {
			
			if (i != 0) {
				System.out.println("Generation " + i);
			} else {
				System.out.println("Post-first generation");
			}
			currentGeneration = nextGeneration;

			//
			// Population dynamics ...
			//

			for (int ii = 0; ii < (int) (nextGeneration.getMen().size() / Constants.EXCHANGE_FACTOR); ii++) {
				currentGeneration.removeRandomMan();
				boolean diabetic = Math.random() < Constants.DIABETICS;
				boolean underEleven = diabetic ? new Random().nextBoolean()
						: false;
				Man man = new Man(true, diabetic, underEleven);
				if (diabetic) {
					currentGeneration.incrementNumberOfDiabetics();
				}
				currentGeneration.addMan(man);
			}

			for (int ii = 0; ii < (int) (nextGeneration.getWomen().size() / Constants.EXCHANGE_FACTOR); ii++) {
				currentGeneration.removeRandomWoman();
				boolean diabetic = Math.random() < Constants.DIABETICS;
				boolean underEleven = diabetic ? new Random().nextBoolean()
						: false;
				Woman woman = new Woman(true, diabetic, underEleven,
						new Random().nextBoolean());
				if (diabetic) {
					currentGeneration.incrementNumberOfDiabetics();
				}
				currentGeneration.addWoman(woman);
			}

			//
			// ...
			//

			nextGeneration = new Generation(i + 1);
			currentGeneration.procreate(nextGeneration);
			nextGeneration.mature();

			//
			// OUTPUT ...
			//
			// display output
			 System.out.println("*** Generation size: "
			 + nextGeneration.getNumberOfIndividuals());
			 System.out.println("Number of men: "
			 + nextGeneration.getMen().size());
			 System.out.println("Number of women: "
			 + nextGeneration.getWomen().size());
			 System.out.println("*** Number of diabetics: "
			 + nextGeneration.getNumberOfDiabetics());
			 System.out.println("Number of diabetic men: "
			 + nextGeneration.numberOfDiabeticMen());
			 System.out.println("Number of diabetic women: "
			 + nextGeneration.numberOfDiabeticWomen());
			 System.out.println("Number of diabetic men before 11: "
			 + nextGeneration.numberOfDiabeticMenUnderEleven());
			 System.out.println("Number of diabetic women before 11: "
			 + nextGeneration.numberOfDiabeticWomenUnderEleven());
			 System.out.println("Number of moms under 25: "
			 + nextGeneration.numberOfMomsUnderTwentyFive());
			// write output to file: CHANGE FILE NAME!!!!!
			printWriter.println(nextGeneration.getGenerationNumber() + ","
					+ nextGeneration.getNumberOfIndividuals() + ","
					+ nextGeneration.getMen().size() + ","
					+ nextGeneration.getWomen().size() + ","
					+ nextGeneration.getNumberOfDiabetics() + ","
					+ nextGeneration.numberOfDiabeticMen() + ","
					+ nextGeneration.numberOfDiabeticWomen() + ","
					+ nextGeneration.numberOfDiabeticMenUnderEleven() + ","
					+ nextGeneration.numberOfDiabeticWomenUnderEleven() + ","
					+ nextGeneration.numberOfMomsUnderTwentyFive());
			//
			// ...
			//
		}

		
		// This verifies the robustness of Java's random number generator
//		for (int i = 0; i < 1000000; i++) {
//			double d = 0.1 + Math.random() * 0.15;
//			printWriter.println(d);
//		}
		printWriter.close();
		System.out.println("Finished");
	}
}

