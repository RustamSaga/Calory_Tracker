package com.rustamsaga.tracker_domain.use_case

data class TrackerUseCases(
    val trackFood: TrackFoodUseCase,
    val searchFood: SearchFoodUseCase,
    val getFoodForDate: GetFoodForDateUseCase,
    val deleteTrackedFood: DeleteTrackedFoodUseCase,
    val calculateMealNutrients: CalculateMealNutrientsUseCase
    )