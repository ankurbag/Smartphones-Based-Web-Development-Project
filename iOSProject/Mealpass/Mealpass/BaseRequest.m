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
            
            
            NSData *jsonData = [NSJSONSerialization dataWithJSONObject:responseObject
                                                               options:(NSJSONWritingOptions)    (YES ? NSJSONWritingPrettyPrinted : 0)
                                                                 error:&error];
            
            if (jsonData) {
                
                NSString* json = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
                Response *response = [[Response alloc] initWithString:json error:&error];
                self.onSuccess(response);
                
                NSLog(@"%@ %@", response, responseObject);
            }
            
           
        }
    }];
    [dataTask resume];
}

-(void) executeOnComplete : (void (^)(Response *))onSuccess onError: (void (^)(NSError *))onError{
    
    self.onSuccess = onSuccess;
    self.onError = onError;
    
}

- (BaseRequestArgs*) getBaseParameters{
    
    BaseRequestArgs* baseRequestArgs = [[BaseRequestArgs alloc] init];
    Response *response = [Response sharedManager];
    if(response){
        
        [baseRequestArgs setUser:[response user]];
        [baseRequestArgs setAccount:[response account]];
    }
    
    return baseRequestArgs;
}


@end
