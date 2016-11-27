package com.neu.mealpass.user.preference;

public class Ingredients {

	private int id;
	private IngredientsEnum ingredientsEnum;
	private double likePrecentage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IngredientsEnum getIngredientsEnum() {
		return ingredientsEnum;
	}
	public void setIngredientsEnum(IngredientsEnum ingredientsEnum) {
		this.ingredientsEnum = ingredientsEnum;
	}
	public double getLikePrecentage() {
		return likePrecentage;
	}
	public void setLikePrecentage(double likePrecentage) {
		this.likePrecentage = likePrecentage;
	}
	
	
}
