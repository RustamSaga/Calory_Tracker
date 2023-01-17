package com.rustamsaga.tracker_data.mapper

import com.rustamsaga.tracker_data.local.entity.TrackedFoodEntity
import com.rustamsaga.tracker_domain.model.MealType
import com.rustamsaga.tracker_domain.model.TrackedFood
import java.time.LocalDate

fun TrackedFoodEntity.toTrackedFood(): TrackedFood {
    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        data = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}

fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        dayOfMonth = data.dayOfMonth,
        month = data.monthValue,
        year = data.year,
        calories = calories,
        id = id
    )
}