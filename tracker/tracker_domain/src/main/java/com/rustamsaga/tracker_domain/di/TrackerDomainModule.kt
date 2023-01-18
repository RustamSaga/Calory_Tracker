package com.rustamsaga.tracker_domain.di

import com.rustamsaga.core.domain.preferences.Preferences
import com.rustamsaga.tracker_domain.model.TrackedFood
import com.rustamsaga.tracker_domain.repository.TrackerRepository
import com.rustamsaga.tracker_domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCase(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFoodUseCase(repository),
            searchFood = SearchFoodUseCase(repository),
            getFoodForDate = GetFoodForDateUseCase(repository),
            deleteTrackedFood = DeleteTrackedFoodUseCase(repository),
            calculateMealNutrients = CalculateMealNutrientsUseCase(preferences)
        )
    }
}