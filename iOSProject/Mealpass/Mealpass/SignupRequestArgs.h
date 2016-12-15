//
//  SignupRequestArgs.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/14/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>
#import "User.h"

@interface SignupRequestArgs : JSONModel

@property (nonatomic) User *user;
@end
