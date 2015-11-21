//
//  ViewController.swift
//  Twitter Demo
//
//  Created by Simran Preet S Narang on 11/15/15.
//  Copyright © 2015 CompleteStack. All rights reserved.
//

import UIKit
import OAuthSwift

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func onLoginAction(sender: AnyObject) {
        
    }
    
    @IBAction func oAuthAction(sender: AnyObject) {
        let oauthswift = OAuth2Swift(
            consumerKey:    twitterConsumerKey,
            consumerSecret: twitterConsumerSecret,
            authorizeUrl:   "https://www.fitbit.com/oauth2/authorize?response_type=code&client_id=229R6V",
            responseType:   "code"
        )
        
        oauthswift.authorizeWithCallbackURL( NSURL(string: "fitbitdemo://oauth")!, scope: "activity%20heartrate", state:"", success: {
            (credential, response, parameters) -> Void in
            }, failure: {(error:NSError!) -> Void in
                print(error.localizedDescription)
        })
    }
    
}

























