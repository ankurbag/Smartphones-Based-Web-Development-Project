//
//  User.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/14/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>
#import "Account.h"

@interface User : JSONModel

/*
 private int id;
	private String name;
	private String phoneNum;
	private String emailAddress;
	private Address address;
	private UserPreference userPreference;
	private Account account;
 
 */

@property (nonatomic) NSString<Optional> *id;
@property (nonatomic) NSString<Optional> *name;
@property (nonatomic) NSString<Optional> *phoneNum;
@property (nonatomic) NSString<Optional> *emailAddress;
@property (nonatomic) Account<Optional> *account;


@end
