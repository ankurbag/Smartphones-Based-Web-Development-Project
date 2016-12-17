//
//  Response.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Response.h"
@implementation Response

+ (id)sharedManager {
    static Response *response = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        response = [[self alloc] init];
        response.mealOrdered = NO;
    });
    return response;
}

+(void) saveResponse : (Response *) response{
    
    Response *actualResponse = [Response sharedManager];
    
    if(response.account){
        [actualResponse setAccount:response.account];
    }
    
    if(response.user){
        [actualResponse setUser:response.user];
    }
    
    if(response.restaurantMeal){
        [actualResponse setRestaurantMeal:response.restaurantMeal];
    }
    
    if(response.mealOrdered){
        [actualResponse setMealOrdered: response.mealOrdered];
    }
    
    if(response.mealPassOptions){
        [actualResponse setMealPassOptions:response.mealPassOptions];
    }
    
    if(response.mealPass){
        [actualResponse setMealPass:response.mealPass];
    }
    
    if(response.userRestaurantMeal){
        [actualResponse setUserRestaurantMeal:response.userRestaurantMeal];
    }
    
   }

+(BOOL) isStatusOk : (NSString*)statusCode{
    
    if([statusCode isEqualToString:@"STATUS_OK"]){
        return YES;
    }
    
    return NO;
}


@end
