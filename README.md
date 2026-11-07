# SoulMath

**Android mathematics learning for inclusive classrooms.**

SoulMath helps vocational high school students with intellectual disabilities practice basic mathematics through visual lessons, videos, and exercises. The project grew from educational research at Universitas Brawijaya and work with SMKN 2 Malang.

[School implementation](https://filkom.ub.ac.id/2023/11/06/filkom-ub-hasilkan-aplikasi-untuk-pembelajaran-anak-berkebutuhan-khusus-abk-tunagrahita-di-smkn-2-malang/) · [Usability study](https://garuda.kemdiktisaintek.go.id/documents/detail/4730916) · [Build the app](#build-the-app)

## Research and use

- **School implementation in 2023.** FILKOM UB reported an implementation session with 16 students on 3 August 2023. The school gave positive feedback and planned to continue using SoulMath for a year. [University report](https://filkom.ub.ac.id/2023/11/06/filkom-ub-hasilkan-aplikasi-untuk-pembelajaran-anak-berkebutuhan-khusus-abk-tunagrahita-di-smkn-2-malang/)
- **Usability evaluation in 2024.** Yahya conducted a five-day study with nine students at SMKN 2 Malang for his undergraduate thesis. The resulting journal article reports a task success rate of 70.37% and a System Usability Scale score of 61.6. Findings include confusing navigation, insufficient interactive guidance, and an on-screen keyboard that could cover quiz questions. [Published study](https://garuda.kemdiktisaintek.go.id/documents/detail/4730916)
- **Teaching material.** A Universitas Brawijaya UX evaluation course on Indonesia's SPADA platform features SoulMath in a usability-testing assignment. [Course material](https://lmsspada.kemdiktisaintek.go.id/course/view.php?id=3814&lang=en)

These records describe the distributed SoulMath application and its research history. This repository contains the **dev2 Android development source**, with application ID `com.ramiyon.soulmath`. The university report links to the `com.ramiyon.soulmath_v2` distribution.

## Source overview

| Area | What is present in this checkout |
| --- | --- |
| Account | Registration, sign-in, and profile screens |
| Learning | Learning journeys, material onboarding, video playback, and XP rewards |
| Progress | Module progress, difficulty crowns, and leaderboard screens |
| Quizzes | Easy, medium, and hard layouts with early activity implementations |

Quiz development is still in progress. The easy activity loads the first question, the medium activity has unfinished loading and success callbacks, and the hard activity has pending question-binding callbacks. Completing those flows will make it possible to reproduce and test the keyboard finding against this source version.

## Build the app

The source uses Kotlin, Android Views with XML and ViewBinding, MVVM, Koin, Retrofit, Firebase, Room, and ExoPlayer.

| Requirement | Version |
| --- | --- |
| JDK for Gradle | 11 |
| Gradle wrapper | 7.4 |
| Android Gradle Plugin | 7.3.0 |
| Kotlin | 1.7.10 |
| Android compile and target SDK | 33 |
| Android minimum SDK | 21 |
| Default SDK Build Tools for AGP 7.3 | 30.0.3 |

Gradle 7.4 and JDK 11 match the Android plugin's documented toolchain. [Android compatibility reference](https://developer.android.com/build/releases/agp-7-3-0-release-notes)

1. Clone the repository and open its root in Android Studio.

   ```sh
   git clone https://github.com/Yahya-nz/SoulMath-dev2.git
   cd SoulMath-dev2
   ```

2. Set the project's Gradle JDK to **11**. Install Android 13 / API 33 and SDK Build-Tools 30.0.3 with SDK Manager.
3. Set the SDK path through Android Studio or a local `local.properties` file containing `sdk.dir=/path/to/Android/sdk`.
4. Configure Firebase for application ID `com.ramiyon.soulmath` and use the matching `app/google-services.json`.
5. Configure a compatible backend in `app/src/main/java/com/ramiyon/soulmath/data/di/DataModule.kt`. API contracts are defined in `data/source/remote/api/ApiService.kt`. Account, learning, and progress features rely on that service.
6. Build a debug APK.

   ```sh
   ./gradlew :app:assembleDebug
   ```

The APK is written to `app/build/outputs/apk/debug/app-debug.apk`. The first Gradle run downloads the wrapper distribution and project dependencies.

## Verify changes

Run the unit tests, lint, and debug build with the configured JDK, SDK, and network access to dependency repositories.

```sh
./gradlew :app:testDebugUnitTest :app:lintDebug :app:assembleDebug
```

For device tests, connect an Android device or start an emulator before running the following command.

```sh
./gradlew :app:connectedDebugAndroidTest
```

For learning-progress changes, check a locked module, an unlocked module, and mixed easy / medium / hard completion states. Scroll away and back to check that recycled rows display the current progress.

## Research priorities

The usability findings provide concrete work for future contributions.

- Complete the quiz answer and question-advance flows, then reproduce the keyboard problem on small landscape screens.
- Keep the question readable while a student enters an answer and add a regression test for that behavior.
- Improve navigation and interactive guidance, including visual and audio cues.
- Evaluate XP requirements with teachers and students before changing progression rules.

A contribution should include the affected screen, reproduction steps, device or emulator details, and the checks performed.

## Team and contribution

| Contributor | Role recorded for this project |
| --- | --- |
| Yahya | Usability testing and evaluation |
| Dhamar Santi Kusuma Wardani | UI/UX design |
| Kylix Eza Saputra | UI/UX design and Android development |
| Nanda Safira | Curriculum and research |

Yahya designed test scenarios, observed students using the app, collected interviews and SUS responses, and documented recommendations in his thesis and subsequent journal publication. The publication lists him as **Yakhya Nahnul Saputro**. [Research record](https://garuda.kemdiktisaintek.go.id/documents/detail/4730916)

## License

This repository is distributed under the [Apache License 2.0](LICENSE).
