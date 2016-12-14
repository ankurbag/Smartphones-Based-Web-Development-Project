//
//  BaseRequest.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <AFNetworking/AFNetworking.h>
#import "Response.h"

@interface BaseRequest :NSObject
    
@property void (^onSuccess)(Response*);
@property  void (^onError)(NSError*);

-(void) executeWithRequestUrl : (NSString *)requestUrl withParameters:(NSDictionary*)parameters;
-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError;

@end
