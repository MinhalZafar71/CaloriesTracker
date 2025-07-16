package com.sftech.core.data.preferences

import android.content.SharedPreferences
import com.sftech.core.domain.model.ActivityLevel
import com.sftech.core.domain.model.Gender
import com.sftech.core.domain.model.GoalType
import com.sftech.core.domain.model.UserInfo
import com.sftech.core.domain.preferences.Preferences
import androidx.core.content.edit

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun saveGender(gender: Gender) {
        sharedPref.edit {
            putString(Preferences.KEY_GENDER, gender.name)
        }
    }

    override fun saveAge(age: Int) {
        sharedPref.edit {
            putInt(Preferences.KEY_AGE, age)
        }
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit {
            putFloat(Preferences.KEY_WEIGHT, weight)
        }
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit {
            putInt(Preferences.KEY_HEIGHT, height)
        }
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref.edit {
            putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.name)
        }
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPref.edit {
            putString(Preferences.KEY_GOAL_TYPE, goalType.name)
        }
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit {
            putFloat(Preferences.KEY_CARB_RATIO, ratio)
        }
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit {
            putFloat(Preferences.KEY_PROTEIN_RATIO, ratio)
        }
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit {
            putFloat(Preferences.KEY_FAT_RATIO, ratio)
        }
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharedPref.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalTypeString = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1f)


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














