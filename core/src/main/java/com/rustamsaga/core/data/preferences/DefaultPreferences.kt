package com.rustamsaga.core.data.preferences

import android.content.SharedPreferences
import com.rustamsaga.core.domain.model.ActivityLevel
import com.rustamsaga.core.domain.model.Gender
import com.rustamsaga.core.domain.model.GoalType
import com.rustamsaga.core.domain.model.UserInfo
import com.rustamsaga.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharPref: SharedPreferences
) : Preferences {
    override fun saveGender(gender: Gender) {
        sharPref.edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharPref.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharPref.edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharPref.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharPref.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, level.name)
            .apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharPref.edit()
            .putString(Preferences.KEY_GOAL_TYPE, type.name)
            .apply()
    }

    override fun saveCardRatio(ratio: Float) {
        sharPref.edit()
            .putFloat(Preferences.KEY_CARD_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharPref.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharPref.edit()
            .putFloat(Preferences.KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharPref.getInt(Preferences.KEY_AGE, -1)
        val genderString = sharPref.getString(Preferences.KEY_GENDER, null)
        val weight = sharPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val height = sharPref.getFloat(Preferences.KEY_HEIGHT, -1f)
        val activityLevelString = sharPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalTypeString = sharPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharPref.getFloat(Preferences.KEY_CARD_RATIO, -1f)
        val proteinRatio = sharPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharPref.getFloat(Preferences.KEY_FAT_RATIO, -1f)


        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalTypeString ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio

        )
    }
}