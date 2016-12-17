//
//  BaseRequestArgs.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BaseRequestArgs.h"

@implementation BaseRequestArgs

-(void) setBaseParameters : (BaseRequestArgs *) baseRequestArgs{
    
    _account = baseRequestArgs.account;
    _user = baseRequestArgs.user;
}

@end
