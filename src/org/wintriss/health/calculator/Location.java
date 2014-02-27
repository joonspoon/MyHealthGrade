package org.wintriss.health.calculator;
public class Location {
	private String excersise;
	private String dietControl;
	private String smoking;
	private String fastFood;
	private String obese;
	private String name;

	public Location(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public String getExcersise() {
		return excersise;
	}
	public void setExcersise(String excersise) {
		this.excersise = excersise;
	}
	public String getDietControl() {
		return dietControl;
	}
	public void setDietControl(String dietControl) {
		this.dietControl = dietControl;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getFastFood() {
		return fastFood;
	}
	public void setFastFood(String fastFood) {
		this.fastFood = fastFood;
	}
	public String getObese() {
		return obese;
	}
	public void setObese(String obese) {
		this.obese = obese;
	}
}
