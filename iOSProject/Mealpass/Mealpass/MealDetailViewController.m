//
//  MealDetailViewController.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/15/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "MealDetailViewController.h"
#import "OrderMealRequest.h"

@interface MealDetailViewController ()

@end

@implementation MealDetailViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    UIColor *color =  [UIColor colorWithRed:255.0f/255.0f
                                      green:0.0f/255.0f
                                       blue:0.0f/255.0f
                                      alpha:0.9f];
    self.navigationController.navigationBar.barTintColor = color;
    [self.navigationController.navigationBar
     setTitleTextAttributes:@{NSForegroundColorAttributeName : [UIColor whiteColor]}];
     _loadingAnimationView = [LoadingAnimationView new];
    [self loadData];
}

-(void) loadData{
    
    if(_restaurantMeal){
        NSError *error;

        NSDictionary * r = (NSDictionary*)_restaurantMeal;
        Meal *meal = [[Meal alloc] initWithDictionary:r[@"meal"] error:&error];
        
        if(meal){
            _mealNameLabel.text = meal.mealName;
            _ingredientsLabel.text = [NSString stringWithFormat:@"%@", meal.ingredients];
        }
        
        Restaurant *restaurant = [[Restaurant alloc] initWithDictionary:r[@"restaurant"] error:&error];
        if(restaurant){
            _restaurantLabel.text = restaurant.restaurantName;
        }
        
        Response *response = [Response sharedManager];
        if(response){
            if(response.mealOrdered){
                _warningLabel.hidden = NO;
                _orderButton.hidden = YES;
            }else{
                _warningLabel.hidden = YES;
                _orderButton.hidden = NO;
            }
        }
       
    }
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)orderMeal:(id)sender {
    
    OrderMealRequest *orderMealRequest = [[OrderMealRequest alloc] initWithRestaurantMeal:_restaurantMeal];
    
    [orderMealRequest executeOnComplete : ^(Response* response) {
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
         [self showError:@"Error while Ordering meal ! Please try again"];
    }];
    
    
    [_loadingAnimationView showWithMessage:@"Loading" inView:self.view];
}

-(void) showError :(NSString *) errorMessage{
    
    if(!errorMessage){
        errorMessage = @"Error while Ordering meal ! Please try again";
    }
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Error"
                                                    message:errorMessage
                                                   delegate:self
                                          cancelButtonTitle:@"OK"
                                          otherButtonTitles:nil];
    [alert show];
}

@end
