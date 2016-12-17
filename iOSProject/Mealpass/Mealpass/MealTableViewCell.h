//
//  MealTableViewCell.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MealTableViewCell : UITableViewCell

@property (nonatomic, weak) IBOutlet UILabel *mealLabel;
@property (nonatomic, weak) IBOutlet UILabel *hotelNameLabel;
@property (nonatomic, weak) IBOutlet UIImageView *mealImageView;
@end
