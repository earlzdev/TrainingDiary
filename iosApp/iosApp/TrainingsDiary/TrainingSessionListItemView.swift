//
//  TrainingSessionListItemView.swift
//  iosApp
//
//  Created by Ilya Saushin on 29.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TrainingSessionListItemView: View {
    
    var trainingSession: DomainTrainingSession
    
    var body: some View {
        ZStack {
            Rectangle()
                .foregroundColor(.clear)
                .frame(width: 352, height: 75)
                .background(Color.BackgroundColor)
                .cornerRadius(8)
                .shadow(color: .black.opacity(0.25), radius: 2, x: 0, y: 4)
                .overlay(
                    RoundedRectangle(cornerRadius: 8)
                        .inset(by: 1)
                        .stroke(Color.OnBackgroundColor, lineWidth: 2)
                        .overlay(
                            HStack {
                                VStack(alignment: .leading) {
                                    Spacer()
                                    Text("\(trainingSession.dateTime.formatDateTime())")
                                        .font(
                                            Font(SharedResources.fontsMontserrat().bold.uiFont(withSize: 14))
                                        )
                                    Spacer()
                                    HStack(alignment: .center) {
                                        Text("\(trainingSession.type)")
                                            .font(
                                                Font(SharedResources.fontsMontserrat().bold.uiFont(withSize: 16))
                                            )
                                        defineAndGetTrainingSessionImage()
                                    }
                                    Spacer()
                                }
                                .padding(.leading, 16)
                                Spacer()
                                VStack(alignment: .trailing) {
                                    Spacer()
                                    Text("\(trainingSession.duration.formatDuration())")
                                        .font(
                                            Font(SharedResources.fontsMontserrat().semibold.uiFont(withSize: 15))
                                        )
                                    Spacer()
                                    HStack {
                                        Text("\(trainingSession.distance)km")
                                            .font(
                                                Font(SharedResources.fontsMontserrat().semibold.uiFont(withSize: 15))
                                            )
                                        Text("\(trainingSession.pulse)")
                                            .font(
                                                Font(SharedResources.fontsMontserrat().semibold.uiFont(withSize: 15))
                                            )
                                        Image(resource: \.ic_heart_rate)
                                    }
                                    Spacer()
                                }
                                .padding(.trailing, 16)
                            }
                        )
                )
        }
    }
    
    private func defineAndGetTrainingSessionImage() -> Image {
        if trainingSession.type == "Running" {
            return Image(resource: \.ic_run)
        } else if trainingSession.type == "Swimming" {
            return Image(resource: \.ic_swim)
        } else {
            return Image(resource: \.ic_gym)
        }
    }
}

struct TrainingSessionListItemView_Previews: PreviewProvider {
    static var previews: some View {
        TrainingSessionListItemView(trainingSession: trainingSession)
    }
}

let trainingSession = DomainTrainingSession(
        id: "test",
        dateTime: 1699785100000,
        title: "Title",
        type: "Running",
        distance: 10,
        duration: 5700000,
        description: "Test",
        pulse: 154
    )
