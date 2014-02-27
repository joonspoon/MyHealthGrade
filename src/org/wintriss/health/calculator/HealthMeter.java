package org.wintriss.health.calculator;

import java.io.InputStream;

public class HealthMeter {
	private int diet;
	private int smoke;
	private int exercise;
	private int fastFood;
	private int obese;
	ExcelStuff excelStuff;

	public HealthMeter(InputStream excelFile) {
		this.excelStuff = new ExcelStuff(excelFile);
	}

	// public static void main(String[] args) {
	// new HealthMeter().askQuestions();
	// }

	public void setDiet(int diet) {
		this.diet = diet;
	}

	public void setSmoke(int smoke) {
		this.smoke = smoke;
	}

	public void setExercise(int exercise) {
		this.exercise = exercise;
	}

	public void setFastFood(int fastFood) {
		this.fastFood = fastFood;
	}

	public void setObese(int obese) {
		this.obese = obese;
	}

	public void setExcelStuff(ExcelStuff excelStuff) {
		this.excelStuff = excelStuff;
	}

	public String compareScores(String location) {
		Location l = excelStuff.getLocation(location);
		System.out.println(l.getName());
		int communityScore = excelStuff.calculateScore(l);
		if (calculateScore() >= communityScore) {
			return "Your personal score was " + (calculateScore() - communityScore) + " percent higher than the average combined score for "
					+ location;
			// JOptionPane.showMessageDialog(null, "Your personal score was " +
			// (calculateScore() - communityScore)
			// + " percent higher than the average combined score for " +
			// location);
		} else {
			return "Your personal score was " + (communityScore - calculateScore()) + " percent lower than the average combined score for "
					+ location;
			// JOptionPane.showMessageDialog(null, "Your personal score was " +
			// (communityScore - calculateScore())
			// + " percent lower than the average combined score for " +
			// location);
		}
	}

	private void askQuestions() {

		diet = question("Are you currently controlling your diet?");
		smoke = question("Do you not smoke on a regular basis, or never smoke?");
		exercise = question("Do you get more than 30 minutes of excercise on most days?");
		fastFood = question("Do you consume fast food more fewer than three meals a week?");
		obese = question("Do you not suffer from obesity (the state of being unhealthily overweight)?");
		// String location =
		// JOptionPane.showInputDialog("Where would you like to compare your score to?");
		compareScores("alpine");
	}

	private int question(String question) {
		int result;
		// result = JOptionPane.showConfirmDialog(null, question);
		return 0;
	}

	private int calculateScore() {
		int score = 0;
		if (diet == 0) {
			score += 20;
		}
		if (smoke == 0) {
			score += 20;
		}
		if (exercise == 0) {
			score += 20;
		}
		if (fastFood == 0) {
			score += 20;
		}
		if (obese == 0) {
			score += 20;
		}
		System.out.println("Your score is: " + score + "%");
		return score;
	}
}
