package com.neu.mealpass.user.preference;

public class Ingredients {

	private int id;
	private IngredientsEnum ingredientsEnum;
	private IngredientsLike ingredientsLike;
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
	public IngredientsLike getIngredientsLike() {
		return ingredientsLike;
	}
	public void setIngredientsLike(IngredientsLike ingredientsLike) {
		this.ingredientsLike = ingredientsLike;
	}
}
