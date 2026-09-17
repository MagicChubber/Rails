import SwiftUI
import ComposeApp

@main
struct TypesafeApp: App {
    init() {
         DependenciesKt.doInitKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
