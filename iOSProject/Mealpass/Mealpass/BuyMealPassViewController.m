//
//  SignupViewController.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/14/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BuyMealPassViewController.h"
#import "User.h"
#import "SignupRequest.h"
#import "BuyMealPassRequest.h"
#import "MealPassOption.h"
@interface BuyMealPassViewController ()

@end

@implementation BuyMealPassViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
     _loadingAnimationView = [LoadingAnimationView new];
    UIColor *color =  [UIColor colorWithRed:255.0f/255.0f
                                      green:0.0f/255.0f
                                       blue:0.0f/255.0f
                                      alpha:0.9f];
    self.navigationController.navigationBar.barTintColor = color;
    [self.navigationController.navigationBar
     setTitleTextAttributes:@{NSForegroundColorAttributeName : [UIColor whiteColor]}];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(BOOL) textFieldShouldReturn: (UITextField *) textField{
    [textField resignFirstResponder];
    return YES;
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)chooseMealOption1:(id)sender {
    [self onValidationSuccessful:@"1":@"Lunch A Bunch":@"12 MEALS FOR $34.68":12];
}
- (IBAction)chooseMealOption2:(id)sender {
    [self onValidationSuccessful:@"2":@"Lunch A Lot":@"20 MEALS FOR $63.80":20];
}
/**
 1	Lunch A Bunch	12 MEALS FOR $34.68 (SAVE $30!)	43200	12 MEALS FOR $34.68 (SAVE $30!)		12
 2	Lunch A Lot	20 MEALS FOR  $63.80 (SAVE $40!)	43200	20 MEALS FOR  $63.80 (SAVE $40!)		20
 **/
-(void) onValidationSuccessful:(NSString*)optionNo :(NSString*)mealPassName :(NSString*)mealPassDescription :(NSInteger)totalMeals{
    //Set MealPassOption Object
    MealPassOption *mealPassOption = [[MealPassOption alloc] init];
    mealPassOption.mealPassDescription = mealPassDescription;
    mealPassOption.mealPassId = optionNo;
    mealPassOption.mealPassName=mealPassName;
    mealPassOption.totalMeals =totalMeals;
    mealPassOption.durationInMinutes=@"43200";
    
    BuyMealPassRequest *buyMealPassRequest = [[BuyMealPassRequest alloc] initWithMealPassOption:mealPassOption];
    [buyMealPassRequest executeOnComplete:^(Response* response) {
        NSLog(@"%@", response);
        [_loadingAnimationView hide];
        if([Response isStatusOk:[response statusCode]]){
        [Response saveResponse:response];
       
        }else{
            [self showError:response.statusUserMessage];
        }
      
        
    } onError: ^(NSError* error){
        NSLog(@"%@", error);
        [_loadingAnimationView hide];
         [self showError:@"Error while Choosing Meal Plan"];
    }];
    
    
    [_loadingAnimationView showWithMessage:@"Loading" inView:self.view];
    
}

-(void) showError :(NSString *) errorMessage{
    
    if(!errorMessage){
        errorMessage = @"Error while Choosing Meal Plan ! Please try again";
    }
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Error"
                                                    message:errorMessage
                                                   delegate:self
                                          cancelButtonTitle:@"OK"
                                          otherButtonTitles:nil];
    [alert show];
}

@end
