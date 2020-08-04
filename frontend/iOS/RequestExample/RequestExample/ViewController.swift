//
//  ViewController.swift
//  RequestExample
//
//  Created by Aaron Lee on 8/4/20.
//  Copyright © 2020 Aaron Lee. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    let url: String = "http://localhost:4000"  // url with port

    // MARK: - IBOutlet
    @IBOutlet weak var txtData: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    // MARK: - IBAction
    @IBAction func btnSendData(_ sender: UIButton) {
        let message: String = txtData.text ?? ""  // text field text
        let data: Dictionary = ["message": message]
        
        guard let url = URL(string: url) else { return }  // Server URL
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"  // Request Method: POST
        
        do {  // Body Data ---> based on dic
            request.httpBody = try JSONSerialization.data(withJSONObject: data, options: .prettyPrinted)
        } catch {
            print(error.localizedDescription)
        }
        
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        request.addValue("application/json", forHTTPHeaderField: "Accept-Type")
        
        let session = URLSession.shared
        session.dataTask(with: request, completionHandler: { (data, response, error) in
            print("Success")
            }).resume()
    }
}

