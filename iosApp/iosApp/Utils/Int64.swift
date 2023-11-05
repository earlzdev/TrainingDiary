//
//  Int64.swift
//  iosApp
//
//  Created by Ilya Saushin on 05.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

extension Int64 {
    
    func formatDateTime() -> String {
        let date = Date(timeIntervalSince1970: TimeInterval(self / 1000))
        let dateFormatter = DateFormatter()

        let calendar = Calendar.current
        let currentYear = calendar.component(.year, from: Date())
        let year = calendar.component(.year, from: date)
            
        if currentYear != year {
            dateFormatter.dateFormat = "d MMM yyyy HH:mm"
        } else {
            dateFormatter.dateFormat = "d MMM HH:mm"
        }
            
        let timeString = dateFormatter.string(from: date)
        
        return "\(timeString)"
    }
    
    func formatDuration() -> String {
        let hours = self / 3600000
        let minutes = (self % 3600000) / 60000
            
        return "\(hours)h \(minutes)min"
    }
}
