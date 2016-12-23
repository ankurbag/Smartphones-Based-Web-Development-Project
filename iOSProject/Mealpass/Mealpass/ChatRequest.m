//
//  ChatRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/17/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "ChatRequest.h"
#import "ChatRequestArgs.h"

@implementation ChatRequest


-(id) initWithUserChat: (NSString*) a_userChat {
    
    self = [super init];
    if(self) {
        _userChat = a_userChat;
        
    }
    return self;
}
-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    [super executeOnComplete:onSuccess onError:onError];

    BaseRequestArgs *baseRequestArgs = [self getBaseParameters];
    ChatRequestArgs *chatRequestArgs = [[ChatRequestArgs alloc] init];
    [chatRequestArgs setBotMessage:_userChat];
    [chatRequestArgs setBaseParameters:baseRequestArgs];
    
    NSDictionary *parameters = [chatRequestArgs toDictionary];
    
    [self executeWithRequestUrl:@"botHelp" withParameters:parameters];
}


@end
