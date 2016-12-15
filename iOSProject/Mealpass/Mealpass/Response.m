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
    
}

@end
