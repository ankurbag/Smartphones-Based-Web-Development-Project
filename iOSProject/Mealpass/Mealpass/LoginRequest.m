//
//  LoginRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LoginRequest.h"
#import <AFNetworking/AFNetworking.h>
#import "BaseRequestArgs.h"

@implementation LoginRequest

-(id) initWithUsername : (NSString*) a_username andPassword:(NSString*) a_password{
    
    self = [super init];
    if(self) {
        _username = a_username;
        _password = a_password;
    }
    return self;
}

-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    [super executeOnComplete:onSuccess onError:onError];
    Account *account = [[Account alloc] init];
    [account setUserName:_username];
    [account setPassword:_password];
    [account setAccountType:@"Basic"];
    
    BaseRequestArgs *baseRequestArgs = [[BaseRequestArgs alloc] init];
    [baseRequestArgs setAccount:account];
    NSDictionary *parameters = [baseRequestArgs toDictionary];
    
    [self executeWithRequestUrl:@"login" withParameters:parameters];
}

@end
