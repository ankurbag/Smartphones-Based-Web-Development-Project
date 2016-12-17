//
//  LoginControllerViewController.m
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/12/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "LoginControllerViewController.h"
#import "BaseRequestArgs.h"
#import "LoginRequest.h"
#import "RequestStatus.h"


@interface LoginControllerViewController ()

@end

@implementation LoginControllerViewController

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

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

-(BOOL) textFieldShouldReturn: (UITextField *) textField{
    [textField resignFirstResponder];
    return YES;
}

- (IBAction)signIn:(id)sender {
    [self onValidationSuccessful];
   
}

-(void) onValidationSuccessful{
    LoginRequest *loginRequest = [[LoginRequest alloc] initWithUsername:_usernameTextField.text andPassword:_passwordTextfield.text];
    [loginRequest executeOnComplete : ^(Response* response) {
        
         [_loadingAnimationView hide];
        if([Response isStatusOk:[response statusCode]]){
            [Response saveResponse:response];
            NSLog(@"%@", response);
            NSLog(@"saved response %@", [Response sharedManager]);
            [self performSegueWithIdentifier:@"home" sender:self];
        }else{
            
            [self showError:response.statusUserMessage];
        }
        
    } onError: ^(NSError* error){
        NSLog(@"%@", error);
        [_loadingAnimationView hide];
         [self showError:@"Error while Login ! Please try again"];
    }];
    
    
    [_loadingAnimationView showWithMessage:@"Loading" inView:self.view];

}

-(void) showError :(NSString *) errorMessage{
    
    if(!errorMessage){
        errorMessage = @"Error while Login ! Please try again";
    }
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Error"
                                                    message:errorMessage
                                                   delegate:self
                                          cancelButtonTitle:@"OK"
                                          otherButtonTitles:nil];
    [alert show];
}
@end
