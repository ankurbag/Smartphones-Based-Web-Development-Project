//
//  LoginRequest.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "RequestStatus.h"
#import "BaseRequest.h"

@interface LoginRequest : BaseRequest

@property (nonatomic) NSString* username;
@property (nonatomic) NSString* password;

-(id) initWithUsername : (NSString*) _username andPassword:(NSString*) _password ;

@end
