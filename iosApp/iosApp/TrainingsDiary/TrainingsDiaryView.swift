//
//  TrainingsDiaryView.swift
//  iosApp
//
//  Created by Ilya Saushin on 28.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TrainingsDiaryView: View {
    
    @ObservedObject var viewModel: TrainingsDiaryViewModel = TrainingsDiaryViewModel()
    
    var body: some View {
        TrainingDiaryContent(
            uiState: $viewModel.uiState,
            onAppear: {
                viewModel.loadTrainingSessions()
                viewModel.startObserving()
            },
            onDisappear: {
                viewModel.stopObserving()
                
            }
        )
    }
}

struct TrainingDiaryContent: View {
    
    @Binding var uiState: TrainingsDiaryUiStateiOS
    
    let onAppear  : () -> Void
    let onDisappear  : () -> Void
    
    var body: some View {
        VStack {
            if uiState.isLoading == true {
                ProgressView("Loading...")
                    .progressViewStyle(CircularProgressViewStyle(tint: .blue))
            } else if !uiState.trainingSessionsList.isEmpty {
                List(uiState.trainingSessionsList, id: \.self) { training in
                    TrainingSessionListItemView(trainingSession: training)
                }
            }
        }
        .onAppear {
            onAppear()
        }.onDisappear {
            onDisappear()
        }
    }
}

struct TrainingsDiaryView_Previews: PreviewProvider {
    static var previews: some View {
        TrainingsDiaryView()
    }
}
