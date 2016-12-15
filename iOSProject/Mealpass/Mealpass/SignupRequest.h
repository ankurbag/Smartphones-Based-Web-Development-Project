//
//  SignupRequest.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/14/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BaseRequest.h"

@interface SignupRequest : BaseRequest

@property (nonatomic) User* user;

-(id) initWithUser : (User*) _user;

@end
