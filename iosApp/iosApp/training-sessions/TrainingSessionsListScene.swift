//
//  TrainingSessionsListScene.swift
//  iosApp
//
//  Created by earl on 28.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TrainingSessionsListScene: View {
    
    var trainigSessions: [TrainingSession]
    
    var body: some View {
        return List(trainigSessions) { trainingSession in
            TrainingSessionsListItem(trainingSession: trainingSession)
        }
    }
}

struct TrainingSessionsListScene_Previews: PreviewProvider {
    static var previews: some View {
        let trainingSessions = [
            TrainingSession(id: "1", dateTime: "2022-01-01 10:00", title: "Morning Run", type: "Running", distance: "5 km", description: "Easy pace"),
            TrainingSession(id: "2", dateTime: "2022-01-02 18:00", title: "Evening Swim", type: "Swimming", distance: "1 km", description: "Freestyle drills"),
            TrainingSession(id: "3", dateTime: "2022-01-03 07:30", title: "Yoga Class", type: "Yoga", distance: "-", description: "Beginner level"),
            TrainingSession(id: "4", dateTime: "2022-01-04 12:00", title: "Lunchtime Walk", type: "Walking", distance: "3 km", description: "Moderate pace"),
            TrainingSession(id: "5", dateTime: "2022-01-05 20:00", title: "Night Ride", type: "Cycling", distance: "15 km", description: "Hilly terrain"),
            TrainingSession(id: "6", dateTime: "2022-01-06 09:00", title: "Morning Jog", type: "Running", distance: "7 km", description: "Interval training"),
            TrainingSession(id: "7", dateTime: "2022-01-07 17:00", title: "Afternoon Swim", type: "Swimming", distance: "2 km", description: "Breaststroke drills"),
            TrainingSession(id: "8", dateTime: "2022-01-08 08:00", title: "Hiking Trip", type: "Hiking", distance: "10 km", description: "Mountain trail"),
            TrainingSession(id: "9", dateTime: "2022-01-09 16:00", title: "Strength Training", type: "Fitness", distance: "-", description: "Weightlifting"),
            TrainingSession(id: "10", dateTime: "2022-01-10 11:30", title: "Lunchtime Run", type: "Running", distance: "8 km", description: "Tempo run")
        ]
        TrainingSessionsListScene(trainigSessions: trainingSessions)
    }
}
