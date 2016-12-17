//
//  OrderMealRequest.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BaseRequest.h"

@interface OrderMealRequest : BaseRequest

@property (nonatomic) RestaurantMeal* restaurantMeal;
-(id) initWithRestaurantMeal : (RestaurantMeal*) a_restaurantMeal;
@end
