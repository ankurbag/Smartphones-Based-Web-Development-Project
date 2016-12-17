//
//  MealHistoryRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/17/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "MealHistoryRequest.h"

@implementation MealHistoryRequest

-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    [super executeOnComplete:onSuccess onError:onError];
    
    
    BaseRequestArgs *baseRequestArgs = [self getBaseParameters];
    NSDictionary *parameters = [baseRequestArgs toDictionary];
    
    [self executeWithRequestUrl:@"mealHistory" withParameters:parameters];
}



@end
