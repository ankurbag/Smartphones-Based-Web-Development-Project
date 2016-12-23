//
//  ChatRequest.h
//  Mealpass
//
//  Created by Sabrish Ramamoorthy on 12/17/16.
//  Copyright © 2016 Sabrish Ramamoorthy. All rights reserved.
//

#import "BaseRequest.h"

@interface ChatRequest : BaseRequest
@property (nonatomic) NSString* userChat;


-(id) initWithUserChat: (NSString*) a_userChat ;
@end
