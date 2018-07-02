//
//  SecondViewController.swift
//  ios-tab-app
//
//  Created by Jose Guilherme Costa Varandas on 01/07/18.
//  Copyright © 2018 Jose Guilherme Costa Varandas. All rights reserved.
//

import UIKit
import React

class SecondViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        loadJSBundle()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func loadJSBundle() {
        NSLog("loadJSBundle")
        let jsBundleLocation = URL(string: "http://localhost:8081/index.bundle?platform=ios")
        let mockData:NSDictionary = ["scores":
            [
                ["name":"Alex", "value":"42"],
                ["name":"Joel", "value":"10"]
            ]
        ]
        
        let rootView = RCTRootView(
            bundleURL: jsBundleLocation,
            moduleName: "reactTdcBundle",
            initialProperties: mockData as [NSObject : AnyObject],
            launchOptions: nil
        )
        
        self.view = rootView
    }
}

