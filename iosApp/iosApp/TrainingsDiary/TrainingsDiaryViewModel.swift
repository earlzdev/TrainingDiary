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
    
    private func getTrainingsDiaryUseCase() -> TrainingsDiaryUseCaseiOS {
        TrainingSessionsComponent().trainingsDiaryUseCaseiOS
    }
    
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

//
//       func deleteTransaction(transactionId: Int64) {
//           homeUseCase().deleteTransaction(
//               transactionId: transactionId,
//               onError: { error in
//                   self.snackbarData = error.toSnackbarData()
//               }
//           )
//       }

       deinit {
           TrainingSessionsComponent().trainingsDiaryUseCaseiOS.onDestroy()
       }
    
    
//    lazy var trainingsDiaryUseCase = TrainingsDiaryUseCaseImpl(repository: TrainingSessionsComponent().trainingsDiaryRepository, viewUpdate: { [weak self] model in
//        self?.trainingsDiaryModel = model
//    })
//    
//    func startObserving() {
//        self.trainingsDiaryUseCase.fetchActualTrainingDiaryModel()
//    }
//    
//    func stopObserving() {
//        self.trainingsDiaryUseCase.onDestroy()
//    }
    
//    var usecase = TrainingsDiary
}

//@Published var homeModel: HomeModel = HomeModel.Loading()
//
//lazy var useCase = HomeUseCaseImpl(moneyRepository: MoneyRepositoryFake(), viewUpdate: { [weak self] model in
//    self?.homeModel = model
//})
//
//func startObserving() {
//    self.useCase.computeData()
//}
//
//func stopObserving() {
//    self.useCase.onDestroy()
//}
