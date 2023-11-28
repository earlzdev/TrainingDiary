//
//  TrainingsDiaryMainView.swift
//  iosApp
//
//  Created by Ilya Saushin on 11.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TrainingsDiaryMainView: View {
    
    var uiState: TrainingsDiaryUiStateiOS
    
    var body: some View {
        VStack {
            HStack {
                Text("Statistics block:")
                    .frame(width: UIScreen.main.bounds.width, alignment: .leading)
                    .padding(.leading, 40)
                    .padding(.top, 20)
            }
            ScrollView(.horizontal) {
                HStack {
                    TrainingStatisticListItemView()
                        .frame(width: UIScreen.main.bounds.width)
                }
            }
            HStack {
                Text("Diary:")
                    .frame(width: UIScreen.main.bounds.width, alignment: .leading)
                    .padding(.leading, 40)
            }
            ScrollView {
                ForEach(uiState.trainingSessionsList, id: \.self) { training in
                    TrainingSessionListItemView(trainingSession: training)
                        .padding(.horizontal, 20)
                        .padding(.vertical, 5)
                }
            }
        }
    }
}

struct TrainingsDiaryMainView_Previews: PreviewProvider {
    static var previews: some View {
        TrainingsDiaryMainView(uiState: TrainingsDiaryUiStateiOS(trainingSessionsList: [], isLoading: false, error: "No error"))
    }
}
