//
//  Response.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>
#import "User.h"
#import "RestaurantMeal.h"
#import "MealPassOption.h"
#import "MealPass.h"

@interface Response : JSONModel

@property (nonatomic) NSString *statusCode;
@property (nonatomic) NSString<Optional> *statusUserMessage;
@property (nonatomic) Account *account;
@property (nonatomic) User<Optional> *user;
@property (nonatomic) BOOL mealOrdered;
@property (nonatomic) NSArray<RestaurantMeal*><Optional> *restaurantMeal;
@property (nonatomic) NSArray<MealPassOption *><Optional> *mealPassOptions;
@property (nonatomic) MealPass<Optional> *mealPass;
@property (nonatomic) RestaurantMeal <Optional> *userRestaurantMeal;

+ (id)sharedManager;
+(void) saveResponse : (Response *) response;
+(BOOL) isStatusOk : (NSString*)statusCode;
@end
