//
//  ViewController.swift
//  HealthSync
//
//  Created by Simran Preet S Narang on 10/18/15.
//  Copyright © 2015 SwiftStudio. All rights reserved.
//

import UIKit
import OAuthSwift
import Alamofire

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    @IBAction func buttonPressed(sender: UIButton) {
        doOAuthFitbit()
    }
    
    @IBAction func getWeight(sender: UIButton) {
        performGetWeightCall()
    }
    
    
    
    func doOAuthFitbit(){
        let oauthswift = OAuth1Swift(
            consumerKey:    Fitbit["consumerKey"]!,
            consumerSecret: Fitbit["consumerSecret"]!,
            requestTokenUrl: "https://api.fitbit.com/oauth/request_token",
            authorizeUrl:    "https://www.fitbit.com/oauth/authorize",
            accessTokenUrl:  "https://api.fitbit.com/oauth/access_token"
        )
        oauthswift.authorizeWithCallbackURL( NSURL(string: "oauth-swift://oauth-callback/fitbit")!, success: {
            credential, response in
            
            Fitbit["oauthToken"] = credential.oauth_token
            Fitbit["oauthTokenSecret"] = credential.oauth_token_secret
            
            print("OauthToken:\(Fitbit["oauthToken"]!)")
            self.showAlertView("Fitbit", message: "oauth_token:\(Fitbit["oauthToken"]!)\n\noauth_toke_secret:\(Fitbit["oauthTokenSecret"]!)")
            
            }, failure: {(error:NSError!) -> Void in
                print(error.localizedDescription)
        })
    }
    
    
    func getSignature(timeStamp:String, dateString:String)->String {
        
        let message = "GET&https%3A%2F%2Fapi.fitbit.com%2F1%2Fuser%2F-%2Fbody%2Flog%2Fweight%2Fdate%2F\(dateString).json&oauth_consumer_key%3D\(Fitbit["consumerKey"]!)%26oauth_nonce%3D%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D\(timeStamp)%26oauth_token%3D\( Fitbit["oauthToken"]!)%26oauth_version%3D1.0"
        
        let key = "\(Fitbit["consumerSecret"]!)&\(Fitbit["oauthTokenSecret"]!)"
        
        let hmacResult:String = message.hmac(HMACAlgorithm.SHA1, key: key)
        
        return hmacResult
    }
    
    
    
    
    func performGetWeightCall() {
        
        let timeStamp = "1446616917"
        let dateString = "2015-10-30"
        let signature = getSignature(timeStamp,dateString: dateString)
        
        let postEndpoint: String = "https://api.fitbit.com/1/user/-/body/log/weight/date/\(dateString).json"
        let headers = [
            "Authorization":"OAuth oauth_consumer_key=\(Fitbit["consumerKey"]!),oauth_token=\(Fitbit["oauthToken"]!),oauth_nonce=,oauth_signature=\(signature),oauth_signature_method=HMAC-SHA1,oauth_timestamp=\(timeStamp),oauth_version=1.0"
        ]
        
        Alamofire.request(.GET, postEndpoint, headers: headers)
            .responseJSON { response in
                print(response)
        }
    }
    
    func showAlertView(title: String, message: String) {
        let alert = UIAlertController(title: title, message: message, preferredStyle: UIAlertControllerStyle.Alert)
        alert.addAction(UIAlertAction(title: "Close", style: UIAlertActionStyle.Default, handler: nil))
        self.presentViewController(alert, animated: true, completion: nil)
    }
    
    
}