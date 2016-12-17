//
//  MealTableViewCell.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "MealTableViewCell.h"

@implementation MealTableViewCell

@synthesize  mealLabel = _mealLabel;
@synthesize hotelNameLabel = _hotelNameLabel;
@synthesize mealImageView = _mealImageView;

- (void)awakeFromNib {
    [super awakeFromNib];
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

@end
