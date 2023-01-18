package com.rustamsaga.tracker_domain.use_case

import com.rustamsaga.tracker_domain.model.TrackedFood
import com.rustamsaga.tracker_domain.repository.TrackerRepository

class DeleteTrackedFoodUseCase(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}