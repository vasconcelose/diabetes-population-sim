package model;

public class Person {
	private boolean man;
	private boolean diabetic;
	private double chanceOfDevelopingDiabetes; // first generation will not be
												// instantiated with this

	public Person(boolean man, boolean diabetic) {
		super();
		this.man = man;
		this.diabetic = diabetic;
	}

	public boolean isMan() {
		return man;
	}

	public void setMan(boolean man) {
		this.man = man;
	}

	public boolean isDiabetic() {
		return diabetic;
	}

	public void setDiabetic(boolean diabetic) {
		this.diabetic = diabetic;
	}

	public double getChanceOfDevelopingDiabetes() {
		return chanceOfDevelopingDiabetes;
	}

	public void setChanceOfDevelopingDiabetes(double chanceOfDevelopingDiabetes) {
		this.chanceOfDevelopingDiabetes = chanceOfDevelopingDiabetes;
	}
}
