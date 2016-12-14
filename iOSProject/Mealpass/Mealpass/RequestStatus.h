//
//  RequestStatus.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Response.h"

@protocol RequestStatus <NSObject>

-(void) onCompletion: (Response*) response;
-(void) onError: (NSError*) error;

@end
