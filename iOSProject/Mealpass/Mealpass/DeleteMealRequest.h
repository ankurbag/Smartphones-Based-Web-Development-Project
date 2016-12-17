//
//  DeleteMealRequest.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/17/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BaseRequest.h"

@interface DeleteMealRequest :BaseRequest

@property (nonatomic) RestaurantMeal* restaurantMeal;
-(id) initWithRestaurantMeal : (RestaurantMeal*) a_restaurantMeal;

@end
