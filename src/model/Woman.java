package model;

public class Woman extends Person {
	private boolean beforeAgeEleven;
	private boolean lessThanTwentyFive;

	public Woman(boolean man, boolean diabetic, boolean beforeAgeEleven,
			boolean lessThanTwentyFive) {
		super(man, diabetic);
		this.beforeAgeEleven = beforeAgeEleven;
		this.lessThanTwentyFive = lessThanTwentyFive;
	}

	public boolean isBeforeAgeEleven() {
		return beforeAgeEleven;
	}

	public void setBeforeAgeEleven(boolean beforeAgeEleven) {
		this.beforeAgeEleven = beforeAgeEleven;
	}

	public boolean isLessThanTwentyFive() {
		return lessThanTwentyFive;
	}

	public void setLessThanTwentyFive(boolean lessThanTwentyFive) {
		this.lessThanTwentyFive = lessThanTwentyFive;
	}
}

