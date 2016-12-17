//
//  MealDetailViewController.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "LoadingAnimationView.h"
#import "RestaurantMeal.h"

@interface MealDetailViewController : UIViewController

@property  LoadingAnimationView *loadingAnimationView;

@property (nonatomic) RestaurantMeal *restaurantMeal;

@property (weak, nonatomic) IBOutlet UIImageView *mealImageView;

@property (weak, nonatomic) IBOutlet UILabel *mealNameLabel;
@property (weak, nonatomic) IBOutlet UILabel *ingredientsLabel;
@property (weak, nonatomic) IBOutlet UILabel *restaurantLabel;
@property (weak, nonatomic) IBOutlet UILabel *addressLabel;
- (IBAction)orderMeal:(id)sender;
@property (weak, nonatomic) IBOutlet UILabel *warningLabel;
@property (weak, nonatomic) IBOutlet UIButton *orderButton;

@end
