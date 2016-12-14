//
//  Response.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "Account.h"
#import <JSONModel/JSONModel.h>

@interface Response : JSONModel

@property (nonatomic) Account *account;

@end
