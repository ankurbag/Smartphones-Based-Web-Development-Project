//
//  BuyMealPassRequest.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/17/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BaseRequest.h"

@interface BuyMealPassRequest : BaseRequest

@property (nonatomic) MealPassOption* mealPassOption;
-(id) initWithMealPassOption : (MealPassOption*) a_mealPassOption;

@end

