//
//  TrainingStatisticListItemView.swift
//  iosApp
//
//  Created by earl on 11.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TrainingStatisticListItemView: View {
    var body: some View {
        ZStack {
            Rectangle()
                .foregroundColor(.clear)
                .frame(width: .infinity, height: 140)
                .background(Color.BackgroundColor)
                .cornerRadius(8)
                .shadow(color: .black.opacity(0.25), radius: 2, x: 0, y: 4)
                .overlay(
                    RoundedRectangle(cornerRadius: 8)
                        .inset(by: 1)
                        .stroke(Color.OnBackgroundColor, lineWidth: 2)
                        .overlay(
                            VStack {
                                Text("Statistics block is not ready yet")
                            }
                        )
                )
        }.padding(20)
    }
}

struct TrainingStatisticListItemView_Previews: PreviewProvider {
    static var previews: some View {
        TrainingStatisticListItemView()
    }
}
