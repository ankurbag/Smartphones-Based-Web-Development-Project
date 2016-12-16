//
//  SignupViewController.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/14/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "SignupViewController.h"
#import "User.h"
#import "SignupRequest.h"
@interface SignupViewController ()

@end

@implementation SignupViewController

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

- (IBAction)onSignup:(id)sender {
    [self onValidationSuccessful];
}

-(void) onValidationSuccessful {
    
    User *user = [[User alloc] init];
    Account *account = [[Account alloc] init];
    [account setUserName:_email.text];
    [account setPassword:_password.text];
    [user setName: [_fName.text stringByAppendingString:_lName.text]];
    [user setEmailAddress:_email.text];
    [user setAccount:account];
    
    SignupRequest *signupRequest = [[SignupRequest alloc] initWithUser:user];
    
    [signupRequest executeOnComplete : ^(Response* response) {
        [Response saveResponse:response];
        NSLog(@"%@", response);
        [_loadingAnimationView hide];
        
    } onError: ^(NSError* error){
        NSLog(@"%@", error);
        [_loadingAnimationView hide];
    }];
    
    
    [_loadingAnimationView showWithMessage:@"Loading" inView:self.view];
    
}
@end
