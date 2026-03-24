# Feed Explorer

This is a production-ready Android application demonstrating modern development practices, Clean Architecture, and a robust tech stack. The app fetches a list of medical professionals from a remote API and displays their details in a reactive, Material 3-compliant interface.
## Tech Stack

#### Core Language & Concurrency
* **Kotlin**: 100% Kotlin-based codebase.

* **Coroutines**: For non-blocking asynchronous operations.

* **Flow & StateFlow**: Reactive data streams to handle UI state and events.

#### User Interface
* **Jetpack Compose**: Fully declarative UI implementation.

* **Material 3**: Modern design system with dynamic coloring and elevated components.

* **Navigation Compose**: Type-safe navigation (Version 2.8.0+) using @Serializable routes.

* **Coil**: Efficient, Kotlin-first image loading for professional avatars.

#### Architecture
* **MVVM (Model-View-ViewModel)**: Clear separation between UI logic and state.

* **Clean Architecture**: Structured into Data, Domain, and Presentation layers.

* **Repository Pattern**: Provides a single source of truth for data retrieval.

#### Networking & Serialization
* **Retrofit**: Type-safe HTTP client for API communication.

* **Kotlinx Serialization**: Native Kotlin JSON parsing (no reflection required).

* **OkHttp**: Networking layer with interceptors for logging and timeouts.

#### Dependency Injection
* **Hilt (Dagger)**: Standardized DI container to manage object lifecycles and simplify testing.

## Usage

Clone the repository

```bash
git clone https://github.com/IGonzB/FeedExplorer.git
```

Open in Android Studio: (Ladybug | 2024.2.1 or newer recommended).

Sync Gradle: Ensure all dependencies are downloaded.

Run Tests:
```bash
./gradlew test
```

Build & Run: Deploy to an emulator or physical device.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
