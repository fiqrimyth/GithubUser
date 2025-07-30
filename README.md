# GithubUser

**GithubUser** is an Android application that utilizes the [GitHub API](https://developer.github.com/v3/) to search for users on GitHub, view their detailed profile information, followers, following, and repositories.  
The app is built following modern Android development practices such as **Clean Architecture**, **MVVM**, **Hilt**, **Room**, and **Jetpack Compose**, ensuring testability, scalability, and maintainability.

---

## ✨ Features

- 🔍 Search for GitHub users
- 👤 View user profile details
- 👥 Display followers and following
- 📁 Show public repositories
- 💾 Cache data locally using Room
- 🚀 Perform network operations with Kotlin Coroutines
- 🧪 Test-ready architecture with modular structure

---

## 🏗 Architecture

The app is based on **MVVM** and follows the **Clean Architecture** principles:


Each layer has its own responsibility and communicates via interfaces, which makes the app easier to test and maintain.

---

## 🧰 Tech Stack & Libraries

### Jetpack & AndroidX
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) — UI logic with lifecycle awareness
- [LiveData / StateFlow](https://developer.android.com/topic/libraries/architecture/livedata) — Reactive data updates
- [Room](https://developer.android.com/topic/libraries/architecture/room) — Database persistence
- [Navigation](https://developer.android.com/jetpack/compose/navigation) — Navigation between screens
- [Compose](https://developer.android.com/jetpack/compose) *(if applicable)* — Declarative UI framework

### Network & Serialization
- [Retrofit](https://square.github.io/retrofit/) — Type-safe HTTP client
- [Gson](https://github.com/google/gson) — JSON serialization/deserialization

### Dependency Injection
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) — Android DI framework

### Concurrency
- [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines) — For background threading and async logic

### Image Loading
- [Coil](https://coil-kt.github.io/coil/) — Lightweight image loading library for Android

---

## ✅ Requirements

- Android Studio Giraffe or newer
- Kotlin 1.9+
- Gradle 8.0+
- Minimum SDK 24

---

## 🚀 Getting Started

1. Clone this repository:

```bash
git clone https://github.com/your-username/GithubUser.git
