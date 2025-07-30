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

## Screenshoot

<img width="414" height="685" alt="Screenshot 2025-07-30 at 9 37 38 AM" src="https://github.com/user-attachments/assets/ed919749-9fc8-41c7-a30b-ffd7b5341da4" />
<img width="411" height="690" alt="Screenshot 2025-07-30 at 9 38 53 AM" src="https://github.com/user-attachments/assets/51b7d0fe-346d-4f6b-93ab-8a727a0f99a0" />
<img width="414" height="684" alt="Screenshot 2025-07-30 at 9 38 26 AM" src="https://github.com/user-attachments/assets/3c9b44cf-42b6-466a-a1d7-67df05757bf8" />
<img width="411" height="687" alt="Screenshot 2025-07-30 at 9 38 16 AM" src="https://github.com/user-attachments/assets/0fb39ebe-8fab-43b2-8972-d7d26c7365b2" />

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
