//
//  Restaurant.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <JSONModel/JSONModel.h>
@interface Restaurant : JSONModel

/*
 private int id;
	private Address address;
	private String restaurantName;
 
 */

@property (nonatomic) NSString<Optional> *id;
@property (nonatomic) NSString<Optional> *restaurantName;
@property (nonatomic) NSString<Optional> *ratings;


@end

