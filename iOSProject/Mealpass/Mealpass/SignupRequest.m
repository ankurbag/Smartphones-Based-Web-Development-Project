//
//  SignupRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/14/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "SignupRequest.h"
#import "User.h"
#import "SignupRequestArgs.h"

@implementation SignupRequest

-(id) initWithUser : (User*) a_user{
    
    self = [super init];
    if(self) {
        _user = a_user;
    }
    return self;
}

-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    [super executeOnComplete:onSuccess onError:onError];
    
    
    SignupRequestArgs *baseRequestArgs = [[SignupRequestArgs alloc] init];
    [baseRequestArgs setUser:_user];
    NSDictionary *parameters = [baseRequestArgs toDictionary];
    
    [self executeWithRequestUrl:@"signup" withParameters:parameters];
}


@end
