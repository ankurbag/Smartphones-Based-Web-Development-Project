//
//  MealPass.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/16/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>

@interface MealPass : JSONModel
/*
 private int id;
	private String planName;
	private long startDate;
	private long endDate;
	private int mealTotal;
	private int mealUsed;
	private User user;
	private boolean active;
 
 */


@property (nonatomic) NSInteger id;
@property (nonatomic) NSString<Optional> *planName;
@property (nonatomic) NSString<Optional> *startDate;
@property (nonatomic) NSString<Optional> *endDate;
@property (nonatomic) NSInteger mealTotal;
@property (nonatomic) NSInteger mealUsed;
@property (nonatomic) BOOL active;

@end
