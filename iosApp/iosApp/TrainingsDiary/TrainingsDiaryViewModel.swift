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

    @Published var uiState: TrainingsDiaryUiStateiOS = TrainingsDiaryUiStateiOS.init(trainingSessionsList: [], isLoading: true, error: "")
    private let uiStatePublisher: TrainingsDiaryStatePublisheriOS = Di.getTrainingsDiaryUiStatePublisher()
    private var subscriptions = Set<AnyCancellable>()
    
    func startObserving() {
        createPublisher(uiStatePublisher.publishState())
            .eraseToAnyPublisher()
            .receive(on: DispatchQueue.global(qos: .userInitiated))
            .sink(
                receiveCompletion: { completion in
                    print("SMTH \(completion)")
                },
                receiveValue: { genericResponse in
                    onMainThread {
                        self.uiState = genericResponse
                    }
                }
            ).store(in: &self.subscriptions)
    }
    
    func stopObserving() {
        uiStatePublisher.onDestroy()
    }
    
    func loadTrainingSessions() {
        uiStatePublisher.loadTrainingSessions()
    }
}
