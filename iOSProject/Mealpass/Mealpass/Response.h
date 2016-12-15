//
//  Response.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>
#import "User.h"

@interface Response : JSONModel

@property (nonatomic) NSString *statusCode;
@property (nonatomic) Account *account;
@property (nonatomic) User<Optional> *user;
+ (id)sharedManager;
+(void) saveResponse : (Response *) response;
@end
