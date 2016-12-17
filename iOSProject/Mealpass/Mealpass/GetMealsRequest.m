//
//  GetMealsRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GetMealsRequest.h"

@implementation GetMealsRequest


-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    [super executeOnComplete:onSuccess onError:onError];
    
    
    BaseRequestArgs *baseRequestArgs = [self getBaseParameters];
    NSDictionary *parameters = [baseRequestArgs toDictionary];
    
    [self executeWithRequestUrl:@"getMeals" withParameters:parameters];
}


@end
