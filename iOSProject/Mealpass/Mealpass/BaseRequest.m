//
//  BaseRequest.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BaseRequest.h"
#import "RequestConstants.h"
#import "Response.h"

@implementation BaseRequest

-(void) executeWithRequestUrl : (NSString *)requestUrl withParameters:(NSDictionary*)parameters{
    
    NSURLSessionConfiguration *configuration = [NSURLSessionConfiguration defaultSessionConfiguration];
    AFURLSessionManager *manager = [[AFURLSessionManager alloc] initWithSessionConfiguration:configuration];
    NSMutableURLRequest *request =  [[AFJSONRequestSerializer serializer] requestWithMethod:@"POST" URLString:[baseURL stringByAppendingString:requestUrl] parameters:parameters error:nil ];
    
    NSURLSessionDataTask *dataTask = [manager dataTaskWithRequest:request completionHandler:^(NSURLResponse *response, id responseObject, NSError *error) {
        if (error) {
            NSLog(@"Error: %@", error);
            self.onError(error);
        } else {
            
            NSError *error;
            Response *response = [[Response alloc] initWithDictionary:responseObject error:&error];
            self.onSuccess(response);
            
            NSLog(@"%@ %@", response, responseObject);
        }
    }];
    [dataTask resume];
}

-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    self.onSuccess = onSuccess;
    self.onError = onError;
    
}

@end
