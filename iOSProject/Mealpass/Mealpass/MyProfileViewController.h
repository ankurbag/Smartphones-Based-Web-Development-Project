//
//  PhotoViewController.h
//  SidebarDemo
//
//  Created by Simon Ng on 10/11/14.
//  Copyright (c) 2014 AppCoda. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MyProfileViewController : UIViewController
@property (weak, nonatomic) IBOutlet UIBarButtonItem *sidebarButton;
@property (weak, nonatomic) IBOutlet UIImageView *photoImageView;
@property (weak, nonatomic) IBOutlet UILabel *userNameLabel;
@property (strong, nonatomic) NSString *photoFilename;
@property (weak, nonatomic) IBOutlet UILabel *cycleStartDate;
@property (weak, nonatomic) IBOutlet UILabel *cycleEndDate;
@property (weak, nonatomic) IBOutlet UILabel *mealsRemaining;
@end
