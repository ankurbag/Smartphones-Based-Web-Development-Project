//
//  BuyMealPassRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/17/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BuyMealPassRequest.h"
#import "MealOptionArgs.h"

@implementation BuyMealPassRequest

-(id) initWithMealPassOption : (MealPassOption*) a_mealPassOption{
    
    self = [super init];
    if(self) {
        _mealPassOption = a_mealPassOption;
    }
    return self;
}

-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    [super executeOnComplete:onSuccess onError:onError];
    
    
    BaseRequestArgs *baseRequestArgs = [self getBaseParameters];
    MealOptionArgs *orderMealRequestArgs = [[MealOptionArgs alloc] init];
    [orderMealRequestArgs setMealPassOption:_mealPassOption];
    [orderMealRequestArgs setBaseParameters:baseRequestArgs];
    
    NSDictionary *parameters = [orderMealRequestArgs toDictionary];
    
    [self executeWithRequestUrl:@"buyMealPass" withParameters:parameters];
}


@end
