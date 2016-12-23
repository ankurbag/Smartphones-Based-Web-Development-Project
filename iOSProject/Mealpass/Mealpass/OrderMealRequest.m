//
//  OrderMealRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "OrderMealRequest.h"
#import "OrderMealRequestArgs.h"

@implementation OrderMealRequest

-(id) initWithRestaurantMeal : (RestaurantMeal*) a_restaurantMeal{
    
    self = [super init];
    if(self) {
        _restaurantMeal = a_restaurantMeal;
    }
    return self;
}

-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    [super executeOnComplete:onSuccess onError:onError];
    
    
    BaseRequestArgs *baseRequestArgs = [self getBaseParameters];
    OrderMealRequestArgs *orderMealRequestArgs = [[OrderMealRequestArgs alloc] init];
    [orderMealRequestArgs setRestaurantMeal:_restaurantMeal];
    [orderMealRequestArgs setBaseParameters:baseRequestArgs];
    
    NSDictionary *parameters = [orderMealRequestArgs toDictionary];
    
    [self executeWithRequestUrl:@"orderMeal" withParameters:parameters];
}


@end
