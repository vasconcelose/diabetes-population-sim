package model;

public class Man extends Person {
	private boolean beforeAgeEleven;

	public Man(boolean man, boolean diabetic, boolean beforeAgeEleven) {
		super(man, diabetic);
		this.beforeAgeEleven = beforeAgeEleven;
	}

	public boolean isBeforeAgeEleven() {
		return beforeAgeEleven;
	}

	public void setBeforeAgeEleven(boolean beforeAgeEleven) {
		this.beforeAgeEleven = beforeAgeEleven;
	}
}

