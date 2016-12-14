//
//  Request.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/13/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//
#import <JSONModel/JSONModel.h>
#import "Account.h"

@interface BaseRequestArgs : JSONModel

/*
 private Account account;
	private User user;
	private HashMap<String, String> opaqueData;
	private String botMessage;
 
 */

@property (nonatomic) Account *account;

@end
