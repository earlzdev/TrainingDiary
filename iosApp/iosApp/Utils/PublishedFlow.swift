//
//  PublishedFlow.swift
//  iosApp
//
//  Created by earl on 28.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Combine
import shared

func createPublisher<T>(_ flowAdapter: FlowWrapper<T>) -> AnyPublisher<T, KotlinError> {
    let subject = PassthroughSubject<T, KotlinError>()
    let job = flowAdapter.subscribe { (item) in
        subject.send(item)
    } onError: { (error) in
       subject.send(completion: .failure(KotlinError(error)))
    } onComplete: {
        subject.send(completion: .finished)
    }
    return subject.handleEvents(receiveCancel: {
        job.cancel(cause: nil)
    }).eraseToAnyPublisher()
}


func onMainThread(_ closure: @escaping () -> Void) {
    DispatchQueue.main.async {
        closure()
    }
}

class PublishedFlow<T> : ObservableObject {
    @Published
    var output: T

    init<E>(_ publisher: AnyPublisher<T, E>, defaultValue: T) {
        output = defaultValue

        publisher
            .replaceError(with: defaultValue)
            .compactMap { $0 }
            .receive(on: DispatchQueue.main)
            .assign(to: &$output)
    }
}

class KotlinError: LocalizedError {
    let throwable: KotlinThrowable
    init(_ throwable: KotlinThrowable) {
        self.throwable = throwable
    }
    var errorDescription: String? {
        get { throwable.message }
    }
}
