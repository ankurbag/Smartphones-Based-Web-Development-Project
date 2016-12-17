//
//  RestaurantMeal.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "Restaurant.h"
#import "Meal.h"


@interface RestaurantMeal : JSONModel
/*
 private Restaurant restaurant;
	private Meal meal;
	private int totalMeals;
 */

@property (nonatomic) Restaurant<Optional> *restaurant;
@property (nonatomic) Meal<Optional> *meal;
@property (nonatomic) NSString<Optional> *totalMeals;

@end
