//
//  TrainingSessionListItemView.swift
//  iosApp
//
//  Created by earl on 29.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TrainingSessionListItemView: View {
    
    var trainingSession: DomainTrainingSession
    
    var body: some View {
        VStack {
            Text("Trainig - \(trainingSession.title)")
            Text("Date - \(trainingSession.dateTime)")
            
        }
    }
}

//struct TrainingSessionListItemView_Previews: PreviewProvider {
//    static var previews: some View {
//        TrainingSessionListItemView(trainingSession: DomainTrainingSession(id: "Id", dateTime: "12.12.2023", title: "Mock training", type: "Swimming", distance: 2, description: "Mock description"))
//    }
//}
