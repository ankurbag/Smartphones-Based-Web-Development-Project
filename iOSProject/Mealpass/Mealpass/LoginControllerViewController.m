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
    [self performSegueWithIdentifier:@"home" sender:self];
    //[self onValidationSuccessful];
   
}

-(void) onValidationSuccessful{
    LoginRequest *loginRequest = [[LoginRequest alloc] initWithUsername:_usernameTextField.text andPassword:_passwordTextfield.text];
    [loginRequest executeOnComplete : ^(Response* response) {
        
        [Response saveResponse:response];
        NSLog(@"%@", response);
        NSLog(@"saved response %@", [Response sharedManager]);
        [_loadingAnimationView hide];
        
    } onError: ^(NSError* error){
        NSLog(@"%@", error);
        [_loadingAnimationView hide];
    }];
    
    
    [_loadingAnimationView showWithMessage:@"Loading" inView:self.view];

}
@end
