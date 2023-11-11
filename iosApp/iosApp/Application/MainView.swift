//
//  MainView.swift
//  iosApp
//
//  Created by Ilya Saushin on 05.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        TabView {
            TrainingsDiaryView()
                .tabItem {
                    Label("Diary", systemImage: "list.dash")
                }
            ProfileView()
                .tabItem {
                    Label("Profile", systemImage: "person")
                }
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
