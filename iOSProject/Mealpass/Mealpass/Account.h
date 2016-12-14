//
//  Account.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//
#import <JSONModel/JSONModel.h>
@interface Account : JSONModel
/*
 private String userName;
	private String password;
	private String token;
	private String accountType;
 
 */
@property (nonatomic) NSString<Optional> *userName;
@property (nonatomic) NSString<Optional> *password;
@property (nonatomic) NSString<Optional> *token;
@property (nonatomic) NSString<Optional> *accountType;
@end
