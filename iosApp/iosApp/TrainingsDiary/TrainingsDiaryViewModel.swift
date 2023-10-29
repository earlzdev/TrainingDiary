//
//  TrainingsDiaryViewModel.swift
//  iosApp
//
//  Created by Ilya Saushin on 28.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

class TrainingsDiaryViewModel: ObservableObject {
    
    @Published var trainingsSessionList: [DomainTrainingSession] = []
    private let usecase = Di.getTrainingsDiaryUseCase()
    
    private var subscriptions = Set<AnyCancellable>()
    
    func getTrainingSessions() {
        usecase.getTrainingSessions(onSuccess: { list in
            onMainThread {
                self.trainingsSessionList = list
            }
        }, onError: { error in
            print("error -> \(error)")
        })
    }
}
