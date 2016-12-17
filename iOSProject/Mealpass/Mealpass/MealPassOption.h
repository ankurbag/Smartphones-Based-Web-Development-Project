//
//  MealPassOption.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/16/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>

@interface MealPassOption : JSONModel

/*
 private int mealPassId;
	private String mealPassName;
	private String mealPassDurationText;
	private String durationInMinutes;
	private String mealPassDescription;
	private String imageUrl;
	private int totalMeals;
 
 */

@property (nonatomic) NSString<Optional> *mealPassId;
@property (nonatomic) NSString<Optional> *mealPassName;
@property (nonatomic) NSString<Optional> *mealPassDurationText;
@property (nonatomic) NSString<Optional> *durationInMinutes;
@property (nonatomic) NSString<Optional> *mealPassDescription;
@property (nonatomic) NSString<Optional> *imageUrl;
@property (nonatomic) NSInteger totalMeals;

@end
