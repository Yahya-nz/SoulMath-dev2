package com.ramiyon.soulmath.presentation.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.ContextThemeWrapper
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ramiyon.soulmath.R
import com.ramiyon.soulmath.domain.model.learning_journey.GameDifficultyLearningJourney
import com.ramiyon.soulmath.domain.model.learning_journey.GameLearningJourney
import com.ramiyon.soulmath.domain.model.learning_journey.LearningJourney
import com.ramiyon.soulmath.domain.model.learning_journey.MaterialLearningJourney
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LearningJourneyAdapterTest {

    @Test
    fun difficultyCrownsFollowProgressWhenARowIsReused() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()

        instrumentation.runOnMainSync {
            val context = ContextThemeWrapper(instrumentation.targetContext, R.style.Theme_SoulMath)
            val adapter = LearningJourneyAdapter()
            val holder = adapter.onCreateViewHolder(FrameLayout(context), 0)
            val mixedProgress = listOf(
                GameDifficultyLearningJourney(true, false, false),
                GameDifficultyLearningJourney(false, true, false),
                GameDifficultyLearningJourney(false, false, true)
            )
            val noProgress = List(3) { GameDifficultyLearningJourney(false, false, false) }

            for (progress in listOf(mixedProgress, noProgress)) {
                adapter.submitData(listOf(learningJourney(progress)))
                adapter.onBindViewHolder(holder, 0)
                val subModules = listOf(
                    holder.view.firstSubModule,
                    holder.view.secondSubModule,
                    holder.view.thirdSubModule
                )

                subModules.forEachIndexed { index, binding ->
                    assertCrown(context, binding.ivSubModuleFirstCrown, progress[index].easy)
                    assertCrown(context, binding.ivSubModuleSecondCrown, progress[index].medium)
                    assertCrown(context, binding.ivSubModuleThirdCrown, progress[index].hard)
                }
            }
        }
    }

    private fun assertCrown(context: Context, imageView: ImageView, isCrowned: Boolean) {
        val resource = if (isCrowned) R.drawable.ic_crowned else R.drawable.ic_uncrowned
        val expected = requireNotNull(AppCompatResources.getDrawable(context, resource))
            .toBitmap(48, 48, Bitmap.Config.ARGB_8888)
        val actual = requireNotNull(imageView.drawable)
            .toBitmap(48, 48, Bitmap.Config.ARGB_8888)

        assertTrue("Crown does not match its difficulty progress", expected.sameAs(actual))
    }

    private fun learningJourney(
        progress: List<GameDifficultyLearningJourney<Boolean>>
    ) = LearningJourney(
        moduleId = "module",
        moduleTitle = "Numbers",
        moduleImage = "",
        moduleIconLocked = "",
        moduleIconUnlocked = "",
        isModuleUnlocked = true,
        materialLearningJourneyResponse = MaterialLearningJourney("module", 0.0, "material"),
        gameLearningJourneyResponses = progress.mapIndexed { index, crowns ->
            GameLearningJourney(
                moduleId = "module",
                subModuleId = "submodule-$index",
                subModuleTitle = "Numbers $index",
                gameIds = GameDifficultyLearningJourney("easy", "medium", "hard"),
                isGameUnlocked = true,
                gamePercentage = 0.0,
                isDifficultiesUnlocked = GameDifficultyLearningJourney(true, true, true),
                isDifficultiesCrowned = crowns
            )
        }
    )
}
