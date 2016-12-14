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

- (IBAction)signIn:(id)sender {
    
    LoginRequest *loginRequest = [[LoginRequest alloc] initWithUsername:@"Sabrish" andPassword:@"sab123456#"];
    [loginRequest executeOnComplete : ^(Response* response) {
        
        NSLog(@"%@", response);
        [_loadingAnimationView hide];
        
    } onError: ^(NSError* error){
        NSLog(@"%@", error);
        [_loadingAnimationView hide];
    }];
    
   
    [_loadingAnimationView showWithMessage:@"Loading" inView:self.view];

}
@end
