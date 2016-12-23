//
//  SignupViewController.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/14/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "LoadingAnimationView.h"

@interface BuyMealPassViewController : UIViewController

@property  LoadingAnimationView *loadingAnimationView;

@property (weak, nonatomic) IBOutlet UITextField *fName;
@property (weak, nonatomic) IBOutlet UITextField *lName;

@property (weak, nonatomic) IBOutlet UITextField *email;

@property (weak, nonatomic) IBOutlet UITextField *password;

- (IBAction)chooseMealOption1:(id)sender ;
- (IBAction)chooseMealOption2:(id)sender;

@end
