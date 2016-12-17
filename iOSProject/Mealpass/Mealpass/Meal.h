//
//  Meal.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>

@interface Meal : JSONModel
/*
 private int id;
	private String mealName;
	private MealTypeEnum mealTypeEnum;
	private MealPortion mealPortion;
	private List<IngredientsEnum> ingredients;
 
 
 */

@property (nonatomic) NSString<Optional> *id;
@property (nonatomic) NSString<Optional> *mealName;
@property (nonatomic) NSString<Optional> *mealTypeEnum;
@property (nonatomic) NSString<Optional> *restaurantName;
@property (nonatomic) NSString<Optional> *mealPortion;
@property (nonatomic) NSString<Optional> *imagePath;
@property (nonatomic) NSArray<NSString*><Optional> *ingredients;

@end
