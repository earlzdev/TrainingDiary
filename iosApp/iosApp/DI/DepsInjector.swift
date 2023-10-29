//
//  DepsInjector.swift
//  iosApp
//
//  Created by Ilya Saushin on 29.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

func startKoin() {

    let koinApplication = Koin_iosKt.doInitKoiniOS()
    _koin = koinApplication.koin
    koin.openKoinScope()
}

private var _koin: Koin_coreKoin?
var koin: Koin_coreKoin {
    return _koin!
}

let Di = DepsInjector.instance

class DepsInjector {
 
    /** Singletion */
    fileprivate  static let instance = DepsInjector()

    private init() {}

    func getTrainingsDiaryUseCase() -> TrainingsDiaryUseCaseiOS {
        guard let usecase = koin.getFromScope(objCClass: TrainingsDiaryUseCaseiOS.self) as? TrainingsDiaryUseCaseiOS else {
            fatalError("TrainingDiaryUseCaseIOS cannot be null")
        }
        return usecase
    }
}
