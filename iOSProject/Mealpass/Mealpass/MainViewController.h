//
//  MainViewController.h
//  SidebarDemo
//
//  Created by Simon Ng on 10/11/14.
//  Copyright (c) 2014 AppCoda. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "RestaurantMeal.h"
#import "LoadingAnimationView.h"

@interface MainViewController : UIViewController

@property  LoadingAnimationView *loadingAnimationView;
@property (weak, nonatomic) IBOutlet UITableView *mealTableVIew;
@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property NSArray<RestaurantMeal*> *restaurantMeals;
@end
