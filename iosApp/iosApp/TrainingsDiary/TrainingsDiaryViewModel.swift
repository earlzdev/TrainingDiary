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
//                        if case let .failure(error) = completion {
//                            let moneyFlowError = MoneyFlowError.GetMoneySummary(throwable:  error.throwable)
//                            error.throwable.logError(
//                                moneyFlowError: moneyFlowError,
//                                message: "Got error while transforming Flow to Publisher"
//                            )
//                            let uiErrorMessage = DI.getErrorMapper().getUIErrorMessage(error: moneyFlowError)
//                            self.homeModel = HomeModel.Error(uiErrorMessage: uiErrorMessage)
//                        }
                        print("SMTH")
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
    
//    @Published var trainingsSessionList: [DomainTrainingSession] = []
//    private let usecase = Di.getTrainingsDiaryUseCase()
//    
//    func getTrainingSessions() {
//        usecase.getTrainingSessions(onSuccess: { list in
//            onMainThread {
//                self.trainingsSessionList = list
//            }
//        }, onError: { error in
//            print("error -> \(error)")
//        })
//    }
}
