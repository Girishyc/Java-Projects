//
//  AppDelegate.swift
//  Twitter Demo
//
//  Created by Simran Preet S Narang on 11/15/15.
//  Copyright © 2015 CompleteStack. All rights reserved.
//

import UIKit
import OAuthSwift
import Alamofire

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?


    func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {
        // Override point for customization after application launch.
        return true
    }

    func applicationWillResignActive(application: UIApplication) {
        // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
        // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
    }

    func applicationDidEnterBackground(application: UIApplication) {
        // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
        // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
    }

    func applicationWillEnterForeground(application: UIApplication) {
        // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
    }

    func applicationDidBecomeActive(application: UIApplication) {
        // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    }

    func applicationWillTerminate(application: UIApplication) {
        // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    }
    
    func application(application: UIApplication, openURL url: NSURL, sourceApplication: String?, annotation: AnyObject) -> Bool {
        print("\(url)")
        
        var parameter = Dictionary<String, AnyObject>()
        var headers = Dictionary<String, String>()
        
//        headers["Authorization"] = "Basic MjI5UjZWOjFlNDkzOGVlMzA3ZDk4MmI2NWFmYmQyZGYwYTU1ZDBi"
//        headers["Content-Type"] = "application/x-www-form-urlencoded"
//        
        parameter["grant_type"] = "authorization_code"
        parameter["client_id"] = "229R6V"
        parameter["redirect_uri"] = "fitbitdemo://oauth"
        let code = (url.query!).characters.split{$0 == "="}.map(String.init)
        parameter["code"] = code[1]
        
        print(parameter)
        
        let urlstring =  "https://api.fitbit.com/oauth2/token?grant_type=authorization_code&client_id=229R6V&redirect_uri=fitbitdemo://oauth&code="+code[1];
        
        Alamofire.request(.POST, urlstring, parameters: parameter, headers:["Authorization":"Basic MjI5UjZWOjFlNDkzOGVlMzA3ZDk4MmI2NWFmYmQyZGYwYTU1ZDBi","Content-Type":"application/x-www-form-urlencoded"]).responseJSON{ response in
            guard response.result.error == nil else {
                // got an error in getting the data, need to handle it
                print("error calling GET on /posts/1")
                print(response.result.error!)
                return
            }
            
            if let value: AnyObject = response.result.value {
                // handle the results as JSON, without a bunch of nested if loops
                print(value)
            }
        }
        
        return true
    }


}
