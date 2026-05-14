package com.calorie.tracker.feature_journal.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calorie.tracker.feature_journal.data.local.MealDao
import com.calorie.tracker.feature_journal.data.local.MealEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.util.Calendar

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val mealDao: MealDao
) : ViewModel() {

    private val _meals = MutableStateFlow<List<MealEntity>>(emptyList())
    val meals: StateFlow<List<MealEntity>> = _meals.asStateFlow()

    init {
        loadTodayMeals()
    }

    private fun loadTodayMeals() {
        viewModelScope.launch {
            val cal = Calendar.getInstance()
            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            val startOfDay = cal.timeInMillis

            cal.add(Calendar.DAY_OF_MONTH, 1)
            val endOfDay = cal.timeInMillis

            mealDao.getMealsForDate(startOfDay, endOfDay).collectLatest { dailyMeals ->
                _meals.value = dailyMeals
            }
        }
    }
}
