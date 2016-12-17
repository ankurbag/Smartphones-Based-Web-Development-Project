//
//  MainViewController.m
//  SidebarDemo
//
//

#import "MainViewController.h"
#import "SWRevealViewController.h"
#import "MealTableViewCell.h"
#import "GetMealsRequest.h"
#import "MealDetailViewController.h"

@interface MainViewController ()

@end

@implementation MainViewController

- (void)viewDidLoad {
    [super viewDidLoad];

    UIColor *color =  [UIColor colorWithRed:255.0f/255.0f
                                      green:0.0f/255.0f
                                       blue:0.0f/255.0f
                                      alpha:0.9f];
    self.navigationController.navigationBar.barTintColor = color;
    [self.navigationController.navigationBar
     setTitleTextAttributes:@{NSForegroundColorAttributeName : [UIColor whiteColor]}];

    SWRevealViewController *revealViewController = self.revealViewController;
    if ( revealViewController )
    {
        [self.sidebarButton setTarget: self.revealViewController];
        [self.sidebarButton setAction: @selector( revealToggle: )];
        [self.view addGestureRecognizer:self.revealViewController.panGestureRecognizer];
    }
     _loadingAnimationView = [LoadingAnimationView new];
    [self getMeals];
}

-(void) getMeals{
    
    GetMealsRequest *getMealRequest = [[GetMealsRequest alloc] init];
    
    [getMealRequest executeOnComplete : ^(Response* response) {
         NSLog(@"%@", response);
         [_loadingAnimationView hide];
        if(response){
              if([Response isStatusOk:[response statusCode]]){
                   [Response saveResponse:response];
                  _restaurantMeals = response.restaurantMeal;
                  if(_restaurantMeals){
                      [_mealTableVIew reloadData];
                  }
              }else{
                  [self showError:response.statusUserMessage];
              }
            
        }
       
        
    } onError: ^(NSError* error){
        NSLog(@"%@", error);
        [_loadingAnimationView hide];
        [self showError:@"Error while getting meals ! Please try again"];

    }];
    
    
    [_loadingAnimationView showWithMessage:@"Loading" inView:self.view];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    if (_restaurantMeals) {
        return [_restaurantMeals count];
    }
    
    return 0;
}



- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *simpleTableIdentifier = @"MealTableViewCell";
    
    MealTableViewCell *cell = (MealTableViewCell *)[tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
    if (cell == nil)
    {
        NSArray *nib = [[NSBundle mainBundle] loadNibNamed:@"MealTableViewCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    RestaurantMeal *restaurantMeal = [_restaurantMeals objectAtIndex:indexPath.row];
    if(restaurantMeal){
         NSError *error;
        NSDictionary * r = (NSDictionary*)restaurantMeal;
         Restaurant *restaurant = [[Restaurant alloc] initWithDictionary:r[@"restaurant"] error:&error];
        if(restaurant){
             cell.hotelNameLabel.text = [restaurant restaurantName];
        }
        Meal *meal = [[Meal alloc] initWithDictionary:r[@"meal"] error:&error];
        if(meal){
             cell.mealLabel.text = [meal mealName];
        }
    }
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    // Navigation logic may go here, for example:
    // Create the next view controller.
   [self performSegueWithIdentifier:@"mealDetailSegue" sender:self];
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
   
    NSIndexPath *indexPath = [_mealTableVIew indexPathForSelectedRow];
    if ([[segue identifier] isEqualToString:@"mealDetailSegue"]) {
        
        MealDetailViewController *vc = [segue destinationViewController];
        RestaurantMeal * restaurantMeal = [self.restaurantMeals objectAtIndex:indexPath.row];
        vc.restaurantMeal = restaurantMeal;
    }

}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 140;
}

-(void) showError :(NSString *) errorMessage{
    
    if(!errorMessage){
        errorMessage = @"Error while getting meals ! Please try again";
    }
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Error"
                                                    message:errorMessage
                                                   delegate:self
                                          cancelButtonTitle:@"OK"
                                          otherButtonTitles:nil];
    [alert show];
}



@end
