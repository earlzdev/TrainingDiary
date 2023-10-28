//
//  TrainingSessionsViewModel.swift
//  iosApp
//
//  Created by earl on 22.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class TrainingSessionsViewModel {
    
    func test() {
        print("do test request on \(Thread.current)")
        TrainingSessionsComponent().doTestRequest(completionHandler: { data, error in
            print("test request done \(data)")
        })
    }
    
//    func getTrainingSessionsList() -> [TrainingSession] {
//
//    }
}
