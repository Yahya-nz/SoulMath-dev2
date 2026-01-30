# SoulMath - Gamified Mathematics Learning App

> A gamified Android educational application that transforms mathematics learning into an engaging experience through XP rewards, competitive leaderboards, and progressive difficulty levels.

**This is a GROUP PROJECT** | Self-initiated project by Team Ramiyon

---

## Summary

SoulMath is an interactive mathematics learning platform that combines video-based educational content with quiz games across three difficulty tiers, featuring real-time leaderboards and an XP progression system to motivate student engagement.

---

## Description

SoulMath addresses the declining interest in mathematics among students by transforming traditional learning into a game-like experience. The application integrates structured learning journeys with video materials, interactive quizzes, and a comprehensive reward system. Students earn experience points (XP) through completing lessons and games, compete on global leaderboards, and unlock new content as they progress—creating a self-sustaining cycle of motivation and achievement.

The app employs Clean Architecture with MVVM pattern, ensuring scalability and maintainability while delivering smooth user experiences across Android devices (SDK 21+).

---

## Challenge

Our client envisioned an educational app that could compete with entertainment apps for students' attention. The primary challenges we faced included:

**Client Requirements:** The client requested a fully gamified learning experience with real-time competitive features, video streaming capabilities, and offline support—all within a tight development timeline. Balancing feature richness with performance optimization required careful architectural decisions.

**Technical Complexity:** Implementing encrypted local storage (SQLCipher) while maintaining sync with Firebase required building a robust multi-layer data management system. Integrating ExoPlayer with custom reward triggers and handling various network states added significant complexity to the video playback feature.

---

## Problem Statement

Traditional math learning applications often fail to sustain student engagement. Students complete initial lessons but quickly abandon the app due to monotonous interfaces and lack of motivation. The absence of social/competitive elements makes learning feel isolated, and rigid content structures don't adapt to individual progress levels—resulting in both frustrated beginners and bored advanced learners.

---

## Design Process

Our approach began with user research among target students (ages 10-16) to understand their gaming habits and learning preferences. We mapped the customer journey from onboarding to daily engagement, identifying key moments where gamification could boost retention.

We adopted Clean Architecture to separate concerns across data, domain, and presentation layers. The team utilized collaborative Git workflows with feature branching, code reviews, and continuous integration. UI/UX decisions prioritized intuitive navigation with Material Design principles while incorporating playful elements that resonate with younger audiences.

---

## Solution

SoulMath delivers a comprehensive gamified learning ecosystem:

**Progressive Learning Journeys** — Structured modules with video lessons that unlock sequentially, ensuring foundational concepts are mastered before advancing. Each completed material rewards XP and tracks progress visually.

**Three-Tier Game System** — Quiz games across Easy, Medium, and Hard difficulties with image-supported questions. The landscape-optimized interface provides immersive gameplay while reinforcing learned concepts.

**Competitive Leaderboards** — Real-time rankings foster healthy competition among students. The global leaderboard displays XP standings, motivating continuous engagement and improvement.

**Daily Bonus System** — Calendar-based daily rewards encourage consistent app usage. Students receive bonus XP for check-ins, building habitual learning patterns.

**Secure User Profiles** — Firebase Authentication with encrypted local storage (SQLCipher) protects student data while DataStore manages preferences. Profile customization with avatars adds personalization.

---

## Impact & Results

The gamification approach demonstrated measurable improvements in user engagement metrics during testing phases. Students showed increased daily active usage compared to traditional learning apps, with the leaderboard feature driving particularly strong retention among competitive users. The XP system created clear progress visibility that motivated lesson completion rates.

**Key Learnings:** This project deepened our understanding of balancing educational value with entertainment elements. We learned that gamification works best when rewards feel meaningful and progress is clearly visualized. Implementing Clean Architecture proved invaluable for managing complexity as features expanded, and our Git workflow significantly reduced integration conflicts in parallel development.

---

## Technologies Used

| Layer | Technologies |
|-------|-------------|
| **Language** | Kotlin 1.7.10 |
| **Architecture** | MVVM, Clean Architecture, Repository Pattern |
| **Dependency Injection** | Koin 3.3.0 |
| **Backend Services** | Firebase (Auth, Firestore, Storage, Analytics) |
| **Networking** | Retrofit 2.9.0, OkHttp 5.0.0-alpha, Gson |
| **Local Database** | Room 2.4.3 + SQLCipher 4.5.0 (Encryption) |
| **Async Operations** | Kotlin Coroutines, Flow, LiveData |
| **Media Playback** | ExoPlayer 2.18.1 |
| **UI Components** | Material Design, Navigation Component, ViewBinding |
| **Image Loading** | Glide 4.13.0 |
| **Animations** | Lottie 4.2.2, Shimmer Effects |
| **Version Control** | Git with GitFlow branching strategy |

---

## Features & Usage

### Authentication
Launch the app and register with email/password or sign in with Google. The "Remember Me" option keeps you logged in for convenience.

### Home Dashboard
The main hub displays your current XP, learning journey progress, and available modules. Tap any unlocked module to begin learning or access games.

### Learning Materials
Select a learning journey to view available materials. Watch video lessons in full-screen landscape mode—XP is automatically awarded upon completion. Progress is saved locally and synced to the cloud.

### Quiz Games
Choose your difficulty level (Easy/Medium/Hard) and answer multiple-choice questions. Questions may include images for visual problems. Track your score and earn XP based on performance.

### Leaderboard
Access the leaderboard from the bottom navigation to view global rankings. Your current rank is highlighted, showing XP standings against other students.

### Daily Bonus
Check in daily to claim bonus XP. The calendar view tracks your streak and rewards consistent engagement.

### Profile
Customize your avatar, update personal information, and view your XP history and learning statistics.

---

## Team & Roles

| Name | Role |
|------|------|
| **Yahya** | Testing User & Evaluation |
| **Dhamar Santi Kusuma Wardani** | UI/UX Designer |
| **Kylix Eza Saputra** | UI/UX Designer & Android Developer |
| **Nanda Safira** | Curriculum & Researcher |

---

## My Contribution

As **Testing User & Evaluation**, I was responsible for conducting comprehensive user testing sessions and evaluating the application's usability across different user scenarios. I designed test cases, documented bug reports, and provided actionable feedback to the development team. My systematic evaluation process directly improved the user experience by identifying friction points in the learning flow and game mechanics, ensuring the final product met both functional requirements and user expectations.

---

## Build & Run

```bash
# Clone repository
git clone https://github.com/Yahya-nz/SoulMath-dev2.git

# Open in Android Studio (Arctic Fox or newer)
# Sync Gradle dependencies
# Configure Firebase (add google-services.json)
# Run on device/emulator (min SDK 21)
```

---

**Target SDK:** 33 (Android 13) | **Min SDK:** 21 (Android 5.0) | **Build Tool:** Gradle 7.3.0
