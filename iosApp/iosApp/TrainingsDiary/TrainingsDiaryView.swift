//
//  TrainingsDiaryView.swift
//  iosApp
//
//  Created by Ilya Saushin on 28.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TrainingsDiaryView: View {
    
    @ObservedObject var viewModel: TrainingsDiaryViewModel = TrainingsDiaryViewModel()
    
    var body: some View {
        VStack {
            Text("Title -> \(viewModel.trainingsDiaryModel.title)")
        }
        .onAppear {
            self.viewModel.startObserving()
        }
    }
}

struct TrainingsDiaryView_Previews: PreviewProvider {
    static var previews: some View {
        TrainingsDiaryView()
    }
}
