import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
//        KoinHelper().doInitKoin()
        startKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            ContentView()
		}
	}
}
