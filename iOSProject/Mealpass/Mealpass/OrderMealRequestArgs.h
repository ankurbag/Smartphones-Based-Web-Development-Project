//
//  OrderMealRequestArgs.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BaseRequestArgs.h"
#import "RestaurantMeal.h"

@interface OrderMealRequestArgs : BaseRequestArgs

@property (nonatomic)  RestaurantMeal *restaurantMeal;

@end
