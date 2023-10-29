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
    
    @Published var trainingsDiaryModel: DomainTrainingsDiaryModel = DomainTrainingsDiaryModel(id: 0, title: "NON iOS")
    
    private var subscriptions = Set<AnyCancellable>()
    
    func startObserving() {
        let usecase = Di.getTrainingsDiaryUseCase()
        createPublisher(usecase.observeTrainingsDiaryModel())
            .eraseToAnyPublisher()
            .receive(on: DispatchQueue.global(qos: .userInitiated))
            .sink(
                receiveCompletion: { completion in
                    if case let .failure(error) = completion {
                        self.trainingsDiaryModel = DomainTrainingsDiaryModel(id: 0, title: "ERROR \(error)")
                    }
                },
                receiveValue: { genericResponse in
                    onMainThread {
                        self.trainingsDiaryModel = genericResponse
                    }
                }
            )
            .store(in: &self.subscriptions)
    }
}
